package com.springdemo.jpademo;

import com.springdemo.jpademo.config.annotation.MyMethodAnnotation;
import com.springdemo.jpademo.model.User;
import com.springdemo.jpademo.repository.UserRepository;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    /**
     * curl -XPOST -H'content-type:application/json;charset=utf-8' 'http://localhost:8081/user/add' -d '{"username":"lihm01","sex":1,"password":"1","remark":"备注1"}'
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    public @ResponseBody
    User addUser(@RequestBody User form) {
        User n = new User();
        n.setUsername(form.getUsername());
        n.setSex(form.getSex());
        n.setPassword(form.getPassword());
        n.setIdcard(form.getIdcard());
        n.setEventTime(System.currentTimeMillis());
        User save = userRepository.save(n);
        return save;
    }


    /**
     * curl -XPOST -H'content-type:application/json;charset=utf-8' 'http://localhost:8081/user/add' -d '{"username":"lihm01","sex":1,"password":"1","remark":"备注1"}'
     * @param form
     * @return
     */
    @PostMapping("/update")
    public @ResponseBody
    User updateUser(@RequestBody User form) {
        User n = userRepository.findById(form.getId()).orElse(null);
        n.setUsername(form.getUsername());
        n.setPassword(form.getPassword());
        n.setSex(form.getSex());
        n.setIdcard(form.getIdcard());
        n.setEventTime(System.currentTimeMillis());
        User save = userRepository.save(n);
        return save;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    @MyMethodAnnotation
    public User getId(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
