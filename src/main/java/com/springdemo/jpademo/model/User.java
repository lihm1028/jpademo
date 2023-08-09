package com.springdemo.jpademo.model;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
//@Where(clause = " create_time>'2021-01-01' ")
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    private Date createTime=new Date();

    private Long eventTime = System.currentTimeMillis();

    private String username;

    private String password;

    private String idcard;

    private Integer age;

    private Integer sex;

    private String remark;

    private Date updateTime = new Date();

}
