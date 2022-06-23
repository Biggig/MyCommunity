package com.huangzilin.mycommunity.po;

import javax.annotation.Generated;

public class CommunityUser {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.391+08:00", comments="Source field: COMMUNITY_USER.ID")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.394+08:00", comments="Source field: COMMUNITY_USER.ACCOUNT_ID")
    private String accountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.NAME")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.TOKEN")
    private String token;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.GMT_MODIFIED")
    private Long gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.BIO")
    private String bio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.AVATAR_URL")
    private String avatarUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.394+08:00", comments="Source field: COMMUNITY_USER.ID")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.394+08:00", comments="Source field: COMMUNITY_USER.ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.ACCOUNT_ID")
    public String getAccountId() {
        return accountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.ACCOUNT_ID")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.NAME")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.NAME")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.TOKEN")
    public String getToken() {
        return token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.395+08:00", comments="Source field: COMMUNITY_USER.TOKEN")
    public void setToken(String token) {
        this.token = token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.GMT_MODIFIED")
    public Long getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.GMT_MODIFIED")
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.BIO")
    public String getBio() {
        return bio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.BIO")
    public void setBio(String bio) {
        this.bio = bio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.AVATAR_URL")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.396+08:00", comments="Source field: COMMUNITY_USER.AVATAR_URL")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}