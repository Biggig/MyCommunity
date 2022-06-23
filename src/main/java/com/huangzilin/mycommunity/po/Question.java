package com.huangzilin.mycommunity.po;

import javax.annotation.Generated;

public class Question {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.ID")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.TITLE")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.GMT_MODIFIED")
    private Long gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.CREATOR")
    private Integer creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    private Integer commentCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    private Integer viewCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    private Integer likeCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.TAG")
    private String tag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.DESCRIPTION")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.ID")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.TITLE")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.418+08:00", comments="Source field: QUESTION.GMT_MODIFIED")
    public Long getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.GMT_MODIFIED")
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.CREATOR")
    public Integer getCreator() {
        return creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.CREATOR")
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    public Integer getCommentCount() {
        return commentCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    public Integer getViewCount() {
        return viewCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    public Integer getLikeCount() {
        return likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.TAG")
    public String getTag() {
        return tag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.TAG")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.419+08:00", comments="Source field: QUESTION.DESCRIPTION")
    public void setDescription(String description) {
        this.description = description;
    }
}