package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.PaginationDTO;
import com.huangzilin.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public ModelAndView index(@RequestParam(name = "page", defaultValue = "1")Integer page,
                              @RequestParam(name = "size", defaultValue = "5")Integer size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        /*在页面中显示问题列表*/
        PaginationDTO pagination = questionService.findList(page, size);
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }
}
