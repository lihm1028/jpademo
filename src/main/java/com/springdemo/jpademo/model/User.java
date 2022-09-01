package com.springdemo.jpademo.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    private Date createTime;

    private Long eventTime = System.currentTimeMillis();

    private String name;

    private String email;

    private String idcard;

    private Date updateTime = new Date();

}
