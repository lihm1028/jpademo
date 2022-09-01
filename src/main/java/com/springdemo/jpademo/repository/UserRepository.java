package com.springdemo.jpademo.repository;

import com.springdemo.jpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
