package com.huangzilin.mycommunity.po;

import lombok.Data;

@Data
public class CommunityUser {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
