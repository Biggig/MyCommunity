package com.huangzilin.mycommunity.provider;

import com.alibaba.fastjson.JSON;
import com.huangzilin.mycommunity.dto.AccessTokenDTO;
import com.huangzilin.mycommunity.dto.GithubUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Component
@PropertySource("classpath:accessGithub.properties")
public class GithubProvider {
    @Value("${token_url}")
    private String token_url;

    @Value("${user_url}")
    private String user_url;

    /*获取令牌*/
    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws IOException {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .url(token_url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string();
            String token = result.substring(StringUtils.indexOf(result,"=")+1,StringUtils.indexOf(result,"&"));
            System.out.println(token);
            return token;
        }
    }

    public GithubUser getUser(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(user_url)
                .header("Authorization","token "+ accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();
            GithubUser githubUser = JSON.parseObject(str,GithubUser.class);
            return githubUser;
        }
    }

}
