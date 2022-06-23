package com.huangzilin.mycommunity.mapper;

import static com.huangzilin.mycommunity.mapper.QuestionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.huangzilin.mycommunity.po.Question;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface QuestionMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Question>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, gmtCreate, gmtModified, creator, commentCount, viewCount, likeCount, tag, description);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.421+08:00", comments="Source Table: QUESTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="QuestionResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_MODIFIED", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATOR", property="creator", jdbcType=JdbcType.INTEGER),
        @Result(column="COMMENT_COUNT", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="VIEW_COUNT", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="LIKE_COUNT", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TAG", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.CLOB)
    })
    List<Question> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.421+08:00", comments="Source Table: QUESTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("QuestionResult")
    Optional<Question> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.421+08:00", comments="Source Table: QUESTION")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default int insert(Question row) {
        return MyBatis3Utils.insert(this::insert, row, question, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
            .map(creator).toProperty("creator")
            .map(commentCount).toProperty("commentCount")
            .map(viewCount).toProperty("viewCount")
            .map(likeCount).toProperty("likeCount")
            .map(tag).toProperty("tag")
            .map(description).toProperty("description")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default int insertMultiple(Collection<Question> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, question, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
            .map(creator).toProperty("creator")
            .map(commentCount).toProperty("commentCount")
            .map(viewCount).toProperty("viewCount")
            .map(likeCount).toProperty("likeCount")
            .map(tag).toProperty("tag")
            .map(description).toProperty("description")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default int insertSelective(Question row) {
        return MyBatis3Utils.insert(this::insert, row, question, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(title).toPropertyWhenPresent("title", row::getTitle)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", row::getGmtCreate)
            .map(gmtModified).toPropertyWhenPresent("gmtModified", row::getGmtModified)
            .map(creator).toPropertyWhenPresent("creator", row::getCreator)
            .map(commentCount).toPropertyWhenPresent("commentCount", row::getCommentCount)
            .map(viewCount).toPropertyWhenPresent("viewCount", row::getViewCount)
            .map(likeCount).toPropertyWhenPresent("likeCount", row::getLikeCount)
            .map(tag).toPropertyWhenPresent("tag", row::getTag)
            .map(description).toPropertyWhenPresent("description", row::getDescription)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default Optional<Question> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default List<Question> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default List<Question> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.422+08:00", comments="Source Table: QUESTION")
    default Optional<Question> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.423+08:00", comments="Source Table: QUESTION")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.423+08:00", comments="Source Table: QUESTION")
    static UpdateDSL<UpdateModel> updateAllColumns(Question row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(title).equalTo(row::getTitle)
                .set(gmtCreate).equalTo(row::getGmtCreate)
                .set(gmtModified).equalTo(row::getGmtModified)
                .set(creator).equalTo(row::getCreator)
                .set(commentCount).equalTo(row::getCommentCount)
                .set(viewCount).equalTo(row::getViewCount)
                .set(likeCount).equalTo(row::getLikeCount)
                .set(tag).equalTo(row::getTag)
                .set(description).equalTo(row::getDescription);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.423+08:00", comments="Source Table: QUESTION")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Question row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(title).equalToWhenPresent(row::getTitle)
                .set(gmtCreate).equalToWhenPresent(row::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(row::getGmtModified)
                .set(creator).equalToWhenPresent(row::getCreator)
                .set(commentCount).equalToWhenPresent(row::getCommentCount)
                .set(viewCount).equalToWhenPresent(row::getViewCount)
                .set(likeCount).equalToWhenPresent(row::getLikeCount)
                .set(tag).equalToWhenPresent(row::getTag)
                .set(description).equalToWhenPresent(row::getDescription);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.423+08:00", comments="Source Table: QUESTION")
    default int updateByPrimaryKey(Question row) {
        return update(c ->
            c.set(title).equalTo(row::getTitle)
            .set(gmtCreate).equalTo(row::getGmtCreate)
            .set(gmtModified).equalTo(row::getGmtModified)
            .set(creator).equalTo(row::getCreator)
            .set(commentCount).equalTo(row::getCommentCount)
            .set(viewCount).equalTo(row::getViewCount)
            .set(likeCount).equalTo(row::getLikeCount)
            .set(tag).equalTo(row::getTag)
            .set(description).equalTo(row::getDescription)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-23T17:28:08.423+08:00", comments="Source Table: QUESTION")
    default int updateByPrimaryKeySelective(Question row) {
        return update(c ->
            c.set(title).equalToWhenPresent(row::getTitle)
            .set(gmtCreate).equalToWhenPresent(row::getGmtCreate)
            .set(gmtModified).equalToWhenPresent(row::getGmtModified)
            .set(creator).equalToWhenPresent(row::getCreator)
            .set(commentCount).equalToWhenPresent(row::getCommentCount)
            .set(viewCount).equalToWhenPresent(row::getViewCount)
            .set(likeCount).equalToWhenPresent(row::getLikeCount)
            .set(tag).equalToWhenPresent(row::getTag)
            .set(description).equalToWhenPresent(row::getDescription)
            .where(id, isEqualTo(row::getId))
        );
    }
}