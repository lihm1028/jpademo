package com.springdemo.jpademo.model;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
//@Where(clause = " create_time>'2021-01-01' ")
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


    private Integer age;

    private Date updateTime = new Date();

}
