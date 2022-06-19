package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.QuestionDTO;
import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.po.Question;
import com.huangzilin.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie:cookies) {
                if("token".equals(cookie.getName())){
                    /*cookie中存在token，证明处于登录状态，从数据库中读取用户信息*/
                    String myToken = cookie.getValue();
                    CommunityUser user = userMapper.findUserByToken(myToken);
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        /*在页面中显示问题列表*/
        List<QuestionDTO> questionDTOS = questionService.findList();
        modelAndView.addObject("questions", questionDTOS);
        return modelAndView;
    }
}
