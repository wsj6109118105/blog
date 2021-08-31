package com.springboottest.Dao;

import com.springboottest.pojo.Book;
import com.springboottest.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
