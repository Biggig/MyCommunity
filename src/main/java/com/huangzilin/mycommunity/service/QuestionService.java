package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.dto.PaginationDTO;
import com.huangzilin.mycommunity.dto.QuestionDTO;
import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.po.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO findList(Integer page, Integer size) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        Integer num = questionMapper.count();/*问题总数*/
        int total_page = num % size == 0 ? num / size : num / size + 1; /*页面总数*/

        /*防止越界访问*/
        if(page < 1)
            page = 1;
        if(page > total_page)
            page = total_page;

        Integer offset = (page-1) * size;
        List<Question> questions = questionMapper.findList(offset, size);

        PaginationDTO paginationDTO = new PaginationDTO();

        for(Question question:questions){
            CommunityUser user = userMapper.findUserByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            /*赋值*/
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);


        paginationDTO.setPagination(num, page, size);

        return paginationDTO;
    }
    /*组装，同时使用UserMapper和QuestionMapper，实现QuestionDTO*/

    public PaginationDTO findListByCreator(Integer creator,Integer page, Integer size){
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        Integer num = questionMapper.countByCreator(creator);/*问题总数*/
        int total_page = num % size == 0 ? num / size : num / size + 1; /*页面总数*/

        /*防止越界访问*/
        if(page < 1)
            page = 1;
        if(page > total_page)
            page = total_page;

        Integer offset = (page-1) * size;
        /*根据用户id查出所问问题*/
        List<Question> questions = questionMapper.findListByCreator(creator, offset, size);

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
        paginationDTO.setPagination(num, page, size);
        return paginationDTO;
    }


}
