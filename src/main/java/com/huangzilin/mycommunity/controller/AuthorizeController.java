package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.AccessTokenDTO;
import com.huangzilin.mycommunity.dto.GithubUser;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
@PropertySource(value = {"classpath:accessGithub.properties"})//从此文件中读取登录github的相关数据
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${client_id}")
    private String client_id;

    @Value("${client_secret}")
    private String client_secret;

    @Value("${redirect_uri}")
    private String redirect_uri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public ModelAndView callback(@RequestParam(name = "code")String code,
                                 @RequestParam(name = "state")String state,
                                 HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        //构造AccessTokenDTO对象
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);

        String token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(token);

        if (githubUser != null){
            /*登录成功/

            /*使用accountId查找数据库，若有user，则执行更新，否则执行插入*/
            String accountId = String.valueOf(githubUser.getId());
            String myToken = UUID.randomUUID().toString();
            if(userMapper.findUserByAccountId(accountId) != null){
                /*用户已在数据库中*/
                userMapper.updateUserByAccountId(accountId, myToken, System.currentTimeMillis(), githubUser.getAvatarUrl());
            }else {
                /*用户不在数据库中*/
                /*把user放进数据库*/
                CommunityUser user = new CommunityUser();
                user.setToken(myToken);
                user.setName(githubUser.getName());
                user.setAccountId(accountId);
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(System.currentTimeMillis());
                user.setAvatarUrl(githubUser.getAvatarUrl());

                userMapper.insertUser(user);

            }
            response.addCookie(new Cookie("token", myToken));

        }else {
            /*登录失败*/
        }
        return modelAndView;
    }
}
