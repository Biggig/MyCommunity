package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.QuestionDTO;
import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.po.Question;
import com.huangzilin.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{questionId}")
    public ModelAndView question(@PathVariable(name = "questionId")Integer questionId){
        ModelAndView modelAndView = new ModelAndView();
        QuestionDTO questionDTO = questionService.findQuestionById(questionId);
        modelAndView.setViewName("question");
        modelAndView.addObject("question",questionDTO);
        return modelAndView;
    }
}
