package com.huangzilin.mycommunity.service;

import com.huangzilin.mycommunity.dto.GithubUser;
import com.huangzilin.mycommunity.mapper.CommunityUserDynamicSqlSupport;
import com.huangzilin.mycommunity.mapper.CommunityUserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Service
public class CommunityUserService {
    @Autowired
    private CommunityUserMapper communityUserMapper;
    public String updateUser(GithubUser githubUser){
        /*登录成功时，使用accountId查找数据库，若有user，则执行更新，否则执行插入*/
        String accountId = String.valueOf(githubUser.getId());
        String myToken = UUID.randomUUID().toString();

        SelectStatementProvider selectStatement = select(communityUserMapper.selectList)
                .from(CommunityUserDynamicSqlSupport.communityUser)
                .where(CommunityUserDynamicSqlSupport.accountId,isEqualTo(accountId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        CommunityUser user = communityUserMapper.selectOne(selectStatement).get();

        if(user != null){
            /*用户已在数据库中*/
            user.setToken(myToken);
            user.setAvatarUrl(githubUser.getAvatarUrl());
            user.setGmtModified(System.currentTimeMillis());

            communityUserMapper.updateByPrimaryKey(user);
        }else {
            /*用户不在数据库中*/
            /*把user放进数据库*/
            user = new CommunityUser();
            user.setToken(myToken);
            user.setName(githubUser.getName());
            user.setAccountId(accountId);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(System.currentTimeMillis());
            user.setAvatarUrl(githubUser.getAvatarUrl());

            communityUserMapper.insert(user);
        }
        return myToken;
    }

    public CommunityUser findUserByToken(String token){
        SelectStatementProvider selectStatement = select(communityUserMapper.selectList)
                .from(CommunityUserDynamicSqlSupport.communityUser)
                .where(CommunityUserDynamicSqlSupport.token,isEqualTo(token))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        CommunityUser user = communityUserMapper.selectOne(selectStatement).get();
        return user;
    }
}
