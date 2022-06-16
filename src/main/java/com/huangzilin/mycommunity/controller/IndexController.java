package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if("token".equals(cookie.getName())){
                /*cookie中存在token，证明处于登录状态，从数据库中读取用户信息*/
                String myToken = cookie.getValue();
                CommunityUser user = userMapper.findUserByToken(myToken);
                request.getSession().setAttribute("user", user);
            }
        }
        return "index";
    }
}
