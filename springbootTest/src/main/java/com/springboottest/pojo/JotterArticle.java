package com.springboottest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * user:lufei
 * DATE:2021/8/28
 **/
@Data
@Entity
@Table(name = "jotter_article")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class JotterArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@NotNull(message = "id 不能为 null")
    private int id;

    @NotEmpty(message = "文章标题不能为空")
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    //private Date articleDate;
}
