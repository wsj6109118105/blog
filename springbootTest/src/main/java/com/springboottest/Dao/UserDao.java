package com.springboottest.Dao;

import com.springboottest.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user:lufei
 * DATE:2021/8/17
 **/
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String Username);

    User getByUsernameAndPassword(String Username,String Password);
}
