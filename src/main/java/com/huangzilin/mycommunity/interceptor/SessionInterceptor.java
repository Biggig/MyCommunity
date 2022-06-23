package com.huangzilin.mycommunity.interceptor;

import com.huangzilin.mycommunity.mapper.CommunityUserDynamicSqlSupport;
import com.huangzilin.mycommunity.mapper.CommunityUserMapper;
import com.huangzilin.mycommunity.mapper.QuestionDynamicSqlSupport;
import com.huangzilin.mycommunity.mapper.UserMapper;
import com.huangzilin.mycommunity.po.CommunityUser;
import com.huangzilin.mycommunity.service.CommunityUserService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private CommunityUserService communityUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*拦截请求，在请求执行前执行*/
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie:cookies) {
                if("token".equals(cookie.getName())){
                    /*cookie中存在token，证明处于登录状态，从数据库中读取用户信息*/
                    String myToken = cookie.getValue();
                    CommunityUser user = communityUserService.findUserByToken(myToken);
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
