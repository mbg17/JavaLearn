package com.example.springboot.controller;

import com.example.springboot.domain.User;
import com.example.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"用户接口"})
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "用户列表", notes = "获取所有用户", httpMethod = "GET")
    @GetMapping("/lists")
    public List<User> lists() {
        return userService.query();
    }

    @ApiOperation(value = "获取指定用户", notes = "获取指定用户", httpMethod = "GET")
    @GetMapping("/findById/{id}")
    public User lists(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户啊", httpMethod = "POST")
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user) {
        userService.addUser(user);
        return true;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户", httpMethod = "PUT")
    @PutMapping("/updateUser")
    public boolean updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return true;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户", httpMethod = "DELETE")
    @DeleteMapping("/deleteUser/{id}")
    public boolean updateUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return true;
    }

}
