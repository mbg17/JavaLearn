package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "userOld", url = "localhost:8000")
public interface UserService {

    @GetMapping("/lists")
    List<User> query();

    @GetMapping("/findById/{id}")
    User findUserById(@PathVariable("id") Integer id);

    @DeleteMapping("/deleteUser/{id}")
    void deleteUserById(@PathVariable("id") Integer id);

    @PostMapping("/addUser")
    void addUser(@RequestBody User user);

    @PutMapping("/updateUser")
    void updateUser(@RequestBody User user);
}
