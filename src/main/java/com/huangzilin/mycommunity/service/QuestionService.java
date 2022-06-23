package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.dto.PaginationDTO;
import com.huangzilin.mycommunity.dto.QuestionDTO;
import com.huangzilin.mycommunity.mapper.QuestionDynamicSqlSupport;
import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.po.Question;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public void insertOrUpdateQuestion(String title, String description, String tag, Integer creator, Integer questionId){
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        question.setCreator(creator);
        if(questionId == 0){
            /*没有回传id，是新添加问题*/
            questionMapper.insert(question);
        }else {
            /*有回传id，是修改问题*/
            question.setId(questionId);
            questionMapper.updateByPrimaryKey(question);
        }
    }

    public PaginationDTO findList(Integer page, Integer size) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        Long num = questionMapper.count(CountDSLCompleter.allRows());/*问题总数*/
        Integer total_page = Math.toIntExact(num % size == 0 ? num / size : num / size + 1); /*页面总数*/

        /*防止越界访问*/
        if(page < 1)
            page = 1;
        if(page > total_page)
            page = total_page;

        Integer offset = (page-1) * size;
        SelectStatementProvider selectStatement = select(questionMapper.selectList)
                .from(QuestionDynamicSqlSupport.question)
                .limit(size)
                .offset(offset)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<Question> questions = questionMapper.selectMany(selectStatement);

        PaginationDTO paginationDTO = new PaginationDTO();

        for(Question question:questions){
            CommunityUser user =    userMapper.findUserByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            /*赋值*/
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);


        paginationDTO.setPagination(total_page, page, size);

        return paginationDTO;
    }
    /*组装，同时使用UserMapper和QuestionMapper，实现QuestionDTO*/

    public PaginationDTO findListByCreator(Integer creator,Integer page, Integer size){
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        Integer num = Math.toIntExact(questionMapper.count(c ->
                c.where(QuestionDynamicSqlSupport.creator, isEqualTo(creator))));/*问题总数*/
        int total_page = num % size == 0 ? num / size : num / size + 1; /*页面总数*/

        /*防止越界访问*/
        if(page < 1)
            page = 1;
        if(page > total_page)
            page = total_page;

        Integer offset = (page-1) * size;
        /*根据用户id查出所问问题*/
        SelectStatementProvider selectStatement = select(questionMapper.selectList)
                .from(QuestionDynamicSqlSupport.question)
                .where(QuestionDynamicSqlSupport.creator, isEqualTo(creator))
                .limit(size)
                .offset(offset)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<Question> questions = questionMapper.selectMany(selectStatement);

        /*构造页面所需信息*/
        PaginationDTO paginationDTO = new PaginationDTO();
        CommunityUser user = userMapper.findUserByID(creator);
        for(Question question:questions){
            QuestionDTO questionDTO = new QuestionDTO();
            /*赋值*/
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOS);
        paginationDTO.setPagination(total_page, page, size);
        return paginationDTO;
    }


    public QuestionDTO findQuestionById(Integer questionId) {
        /*浏览数加1功能暂时删除*/
        Question question = questionMapper.selectByPrimaryKey(questionId).get();
        CommunityUser user = userMapper.findUserByID(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        /*赋值*/
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
}
