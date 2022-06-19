# 无聊社区

## 资料
[功能参考](https://www.mawen.co/)  
[Vim语法](https://zhuanlan.zhihu.com/p/68111471)  
[Git ssh登录](https://blog.csdn.net/lonyw/article/details/75392410)  
[Markdown语法](https://markdown.com.cn/basic-syntax/)  
[Bootstrap](https://v3.bootcss.com/getting-started/)  
[Github 授权登录](https://docs.github.com/cn/developers/apps/building-oauth-apps/creating-an-oauth-app)  
[OKHttp](https://square.github.io/okhttp/)  
[H2 database](https://www.h2database.com/html/main.html)  
[Mybatis](https://mybatis.org/mybatis-3/zh/index.html)  
[Spring DataSource](https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

## 工具
[Git](https://git-scm.com/)  
[Visual Paradigm](https://www.visual-paradigm.com/cn/)  
[Flyway](https://flywaydb.org/documentation/)  
[Lombok](https://projectlombok.org/)  

## 脚本
```sql
create table COMMUNITY_USER
(
    ID           INTEGER auto_increment,
    ACCOUNT_ID   CHARACTER VARYING(100),
    NAME         CHARACTER VARYING(50),
    TOKEN        CHARACTER(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);

create unique index COMMUNITY_USER_ACCOUNT_ID_UINDEX
    on COMMUNITY_USER (ACCOUNT_ID);

alter table COMMUNITY_USER
    add bio varchar(256);
```

```bash
mvn flyway:migrate
```