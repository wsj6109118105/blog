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
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
