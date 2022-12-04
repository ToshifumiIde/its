package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * MyBatisの@Mapperアノテーションを追加
 * このアノテーションを追加することで、MMyBatisを通してDB接続できるようになる。
 */
@Mapper
public interface IssueRepository {

    /**
     * @Selectアノテーション：メソッドが実行された際にアノテーション内のSQLが実行される
     * @return @SelectアノテーションのSQLを実行し、issuesのEntityを返却します
     */
    @Select("select * from issues")
    public List<IssueEntity> findAll();

    /**
     * @Insertアノテーション：メソッドが実行された時にアノテーション内のSQLが実行される
     * メソッドの引数で渡ってきた値をinsert文に渡すには、MyBatisの記法で#{値}で渡すことが可能
     * @param summary 課題のサマリー
     * @param description 課題の説明
     */
    @Insert("insert into issues (summary , description)values(#{summary} , #{description})")
    public void insert(String summary , String description);
}
