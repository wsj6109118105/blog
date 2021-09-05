package com.springboottest.Service;

import com.springboottest.Dao.JotterArticleDao;
import com.springboottest.Utils.CastUtils;
import com.springboottest.Utils.Mypage;
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
    @Autowired
    RedisService redisService;

    public Mypage list(int page, int size){
        Mypage<JotterArticle> articles;
        String key = "articlePage:"+page;
        Object articleCache = redisService.get(key);
        if(articleCache==null){
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Page<JotterArticle> articlesIndb = jotterArticleDAO.findAll(PageRequest.of(page,size,sort));
            articles = new Mypage<>(articlesIndb);
            redisService.set(key,articles);
        }else {
            articles = (Mypage<JotterArticle>) articleCache;
        }
        return articles;
    }

    public JotterArticle findById(int id) {
        JotterArticle article;
        String key = "article:"+id;
        Object articleCache = redisService.get(key);
        if(articleCache==null){
            article = jotterArticleDAO.findById(id);
            redisService.set(key,article);
        }else {
            article = (JotterArticle) articleCache;
        }
        return article;
    }

    public void addOrUpdate(JotterArticle article) {
        jotterArticleDAO.save(article);
        //删除当前文章和所有文章的缓存
        redisService.delete("article:"+article.getId());
        Set<String> keys = redisService.getKeysByPattern("articlePage*");
        redisService.delete(keys);
    }

    public void delete(int id) {
        jotterArticleDAO.deleteById(id);
        redisService.delete("article:"+id);
        Set<String> keys = redisService.getKeysByPattern("articlePage*");
        redisService.delete(keys);
    }
}
