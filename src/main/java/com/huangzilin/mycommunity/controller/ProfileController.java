package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.PaginationDTO;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.service.LoginService;
import com.huangzilin.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public ModelAndView profile(@PathVariable(name = "action")String action,
                                HttpServletRequest request,
                                @RequestParam(name = "page", defaultValue = "1")Integer page,
                                @RequestParam(name = "size", defaultValue = "2")Integer size){
        ModelAndView modelAndView = new ModelAndView();
        CommunityUser user = loginService.checkLogin(request);
        /*没有登录则直接跳转至首页*/
        if (user == null){
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }

        if("questions".equals(action)){
            modelAndView.addObject("section", "questions");
            modelAndView.addObject("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            modelAndView.addObject("section", "replies");
            modelAndView.addObject("sectionName", "最新回复");
        }
        modelAndView.setViewName("profile");

        PaginationDTO pagination = questionService.findListByCreator(user.getId(), page, size);
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }

}
