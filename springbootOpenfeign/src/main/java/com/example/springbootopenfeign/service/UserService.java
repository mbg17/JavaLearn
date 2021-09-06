package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "userOld",url = "localhost:8000")
public interface UserService {

    @GetMapping("/lists")
    List<User> query();

    @GetMapping("/findById/{id}")
    User findUserById(Integer id);

    @DeleteMapping("/deleteUser/{id}")
    void deleteUserById(Integer id);

    @PostMapping("/addUser")
    void addUser(User user);

    @PutMapping("/updateUser")
    void updateUser(User user);
}
