package com.huangzilin.mycommunity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class GithubUser {
    //储存github返回的用户信息
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "bio")
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
