package com.huangzilin.mycommunity.mapper;

import com.huangzilin.mycommunity.po.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_create, gmt_modified, creator, tag)" +
            "values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    public void insertQuestion(Question question);

    @Select("select * from question limit #{size} offset #{offset}")
    List<Question> findList(@Param("offset") Integer offset, @Param("size") Integer size);

    /*查询问题总数*/
    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator = #{creator}")
    Integer countByCreator(@Param("creator")Integer creator);

    @Select("select * from question where creator = #{creator} limit #{size} offset #{offset}")
    List<Question> findListByCreator(@Param("creator") Integer creator,
                                     @Param("offset") Integer offset,
                                     @Param("size") Integer size);
}
