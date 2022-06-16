package com.huangzilin.mycommunity.mapper;

import com.huangzilin.mycommunity.po.CommunityUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into community_user (account_id, name, token, gmt_create, gmt_modified) values (" +
            "#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insertUser(CommunityUser user);
}
