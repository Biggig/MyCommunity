package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.mapper.QuestionMapper;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.po.Question;
import com.huangzilin.mycommunity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginService loginService;
    @GetMapping("/publish")
    public ModelAndView publishProblem(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("publish");
        modelAndView.addObject("error", null);
        return modelAndView;
    }

    /*接收前端“问题”表单信息，加入到数据库*/
    @PostMapping("/publish")
    public ModelAndView addProblem(
            @RequestParam("title")String title,
            @RequestParam("description")String description,
            @RequestParam("tag")String tag,
            HttpServletRequest request
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", title);
        modelAndView.addObject("description", description);
        modelAndView.addObject("tag", tag);
        /*前后端都需要使用验证*/
        if (title == null || title.trim()==""){
            modelAndView.addObject("error", "标题不能为空");
            modelAndView.setViewName("publish");
            return modelAndView;
        }

        if (description == null || description.trim()==""){
            modelAndView.addObject("error", "问题补充不能为空");
            modelAndView.setViewName("publish");
            return modelAndView;
        }

        if (tag == null || tag.trim()==""){
            modelAndView.addObject("error", "标签不能为空");
            modelAndView.setViewName("publish");
            return modelAndView;
        }

        CommunityUser user = loginService.checkLogin(request);
        if (user == null){
            /*有错误停留在publish页面*/
            modelAndView.addObject("error", "用户未登录");
            modelAndView.setViewName("publish");
            return modelAndView;
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        question.setCreator(user.getId());
        questionMapper.insertQuestion(question);

        /*成功添加，返回首页*/
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
