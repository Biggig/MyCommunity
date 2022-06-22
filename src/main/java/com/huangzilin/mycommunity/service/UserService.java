package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.dto.GithubUser;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public String updateUser(GithubUser githubUser){
        /*登录成功时，使用accountId查找数据库，若有user，则执行更新，否则执行插入*/
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
        return myToken;
    }
}
