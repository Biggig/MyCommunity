package com.huangzilin.mycommunity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GithubUser {
    //储存github返回的用户信息
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "bio")
    private String bio;
    @JSONField(name = "avatar_url")
    private String avatarUrl;
}
