package com.springboottest.Service;

import com.springboottest.Dao.UserDao;
import com.springboottest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user:lufei
 * DATE:2021/8/17
 **/
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public boolean isExist(String UserName){
        User user = userDao.findByUsername(UserName);
        return null!=user;
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }
}
