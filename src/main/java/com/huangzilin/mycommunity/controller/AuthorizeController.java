package com.huangzilin.mycommunity.controller;

import com.huangzilin.mycommunity.dto.AccessTokenDTO;
import com.huangzilin.mycommunity.dto.GithubUser;
import com.huangzilin.mycommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@PropertySource(value = {"classpath:accessGithub.properties"})//从此文件中读取登录github的相关数据
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public ModelAndView callback(@RequestParam(name = "code")String code,
                                 @RequestParam(name = "state")String state) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        //构造AccessTokenDTO对象
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);

        String token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(token);

        modelAndView.addObject("userName",githubUser.getName());
        return modelAndView;
    }
}
