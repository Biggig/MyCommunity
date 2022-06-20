package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.PaginationDTO;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.service.LoginService;
import com.huangzilin.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private LoginService loginService;
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request,
                              @RequestParam(name = "page", defaultValue = "1")Integer page,
                              @RequestParam(name = "size", defaultValue = "2")Integer size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        loginService.checkLogin(request);

        /*在页面中显示问题列表*/
        PaginationDTO pagination = questionService.findList(page, size);
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }
}
