package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;
    public CommunityUser checkLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie:cookies) {
                if("token".equals(cookie.getName())){
                    /*cookie中存在token，证明处于登录状态，从数据库中读取用户信息*/
                    String myToken = cookie.getValue();
                    CommunityUser user = userMapper.findUserByToken(myToken);
                    request.getSession().setAttribute("user", user);
                    return user;
                }
            }
        }
        return null;
    }
}
