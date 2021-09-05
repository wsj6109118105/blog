package com.springboottest.Controller;

import com.springboottest.Result.Result;
import com.springboottest.Service.JotterArticleService;
import com.springboottest.Utils.Mypage;
import com.springboottest.pojo.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * user:lufei
 * DATE:2021/8/28
 **/
@RestController
public class ArticleController {
    @Autowired
    JotterArticleService jotterArticleService;

    @PostMapping("/article")
    public Result saveArticle(@RequestBody JotterArticle article) {
        /*System.out.println(article.getArticleCover());*/
        if (article.getArticleCover().equals("")){
            article.setArticleCover("http://localhost:8088/file/ajsikwwwjj.png");
        }
        jotterArticleService.addOrUpdate(article);
        return new Result(200);
    }

    @GetMapping("/article/{size}/{page}")
    public Mypage listArticles(@PathVariable("size") int size, @PathVariable("page") int page){
        return jotterArticleService.list(page-1,size);
    }

    @GetMapping("/articledetails/{id}")
    public JotterArticle findById(@PathVariable("id") int id){
        return jotterArticleService.findById(id);
    }

    @PostMapping("/articledetail/{id}")
    public void delete(@PathVariable("id") int id){
        jotterArticleService.delete(id);
    }
}
