package com.springboottest.Dao;

import com.springboottest.pojo.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user:lufei
 * DATE:2021/8/28
 **/
public interface JotterArticleDao extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
