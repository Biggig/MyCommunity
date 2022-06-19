package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.dto.QuestionDTO;
import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.po.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public List<QuestionDTO> findList() {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questions = questionMapper.findList();
        for(Question question:questions){
            CommunityUser user = userMapper.findUserByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            /*赋值*/
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
    /*组装，同时使用UserMapper和QuestionMapper，实现QuestionDTO*/
}
