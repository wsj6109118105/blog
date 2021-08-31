package com.springboottest.Dao;

import com.springboottest.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
public interface CategoryDao extends JpaRepository<Category,Integer> {

}
