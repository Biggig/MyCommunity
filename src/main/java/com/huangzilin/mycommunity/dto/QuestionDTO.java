package com.huangzilin.mycommunity.dto;

import com.huangzilin.mycommunity.po.CommunityUser;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String  description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private CommunityUser user;
}
