package com.springboottest.Service;

import com.springboottest.Dao.CategoryDao;
import com.springboottest.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id){
        Category c = categoryDao.findById(id).orElse(null);
        return c;
    }
}
