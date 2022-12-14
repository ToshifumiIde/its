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
     * issueテーブルから課題を全件検索します
     * @Selectアノテーション：メソッドが実行された際にアノテーション内のSQLが実行される
     * @return @SelectアノテーションのSQLを実行し、issuesのEntityを返却します
     */
    @Select("select * from issues")
    public List<IssueEntity> findAll();

    /**
     * issueテーブルに課題のレコードを1件挿入します
     * @Insertアノテーション：メソッドが実行された時にアノテーション内のSQLが実行される
     * メソッドの引数で渡ってきた値をinsert文に渡すには、MyBatisの記法で#{値}で渡すことが可能
     * @param summary 課題のサマリー
     * @param description 課題の説明
     */
    @Insert("insert into issues (summary , description)values(#{summary} , #{description})")
    public void insert(String summary , String description);

    /**
     * issueテーブルから、課題IDを指定して1件レコードを取得します
     * @param issueId 課題ID
     * @return IssueEntity 課題IDで検索した課題のエンティティ
     */
    @Select("select * from issues where id = #{issueId}")
    public IssueEntity findById(long issueId);
}
