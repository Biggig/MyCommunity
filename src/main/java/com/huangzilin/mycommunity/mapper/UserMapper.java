package com.huangzilin.mycommunity.mapper;

import com.huangzilin.mycommunity.po.CommunityUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into community_user (account_id, name, token, gmt_create, gmt_modified) values (" +
            "#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insertUser(CommunityUser user);
    @Select("select * from community_user where account_id = #{accountId}")
    CommunityUser findUserByAccountId(@Param("accountId") String accountId);

    @Select("select * from community_user where token = #{token}")
    CommunityUser findUserByToken(@Param("token") String token);

    @Update("update community_user set token = #{token}, gmt_modified = #{gmtModified} where account_id = #{accountId}")
    void updateUserByAccountId(@Param("accountId") String accountId,
                               @Param("token") String token,
                               @Param("gmtModified") Long gmtModified);
}
