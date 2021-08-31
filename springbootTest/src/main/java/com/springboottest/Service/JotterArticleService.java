package com.springboottest.Service;

import com.springboottest.Dao.JotterArticleDao;
import com.springboottest.pojo.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * user:lufei
 * DATE:2021/8/28
 **/
@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDao jotterArticleDAO;

    public Page list(int page,int size){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return jotterArticleDAO.findAll(PageRequest.of(page,size,sort));
    }

    public JotterArticle findById(int id) {
        JotterArticle article;
        article = jotterArticleDAO.findById(id);
        return article;
    }

    public void addOrUpdate(JotterArticle article) {
        jotterArticleDAO.save(article);
    }

    public void delete(int id) {
        jotterArticleDAO.deleteById(id);
    }
}
