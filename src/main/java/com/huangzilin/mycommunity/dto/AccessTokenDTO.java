package com.huangzilin.mycommunity.dto;

import lombok.Data;

/*用于储存github登录信息*/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
