package com.springboottest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * user:lufei
 * DATE:2021/8/16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
