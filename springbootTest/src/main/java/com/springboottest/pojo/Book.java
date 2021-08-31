package com.springboottest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
}
