package com.example.springbootopenfeign.controller;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.domain.User;
import com.example.springbootopenfeign.domain.UserNew;
import com.example.springbootopenfeign.dto.UserInputDto;
import com.example.springbootopenfeign.dto.UserLoginDto;
import com.example.springbootopenfeign.service.UserNewService;
import com.example.springbootopenfeign.service.UserService;
import com.example.springbootopenfeign.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = {"用户接口"})
public class UserController {
    @Resource
    HttpSession httpSession;

    @Resource
    private UserService userService;
    @Resource
    private UserNewService userNewService;

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

    @ApiOperation(value = "登录用户（老师提供的）", notes = "登录用户（老师提供的）", httpMethod = "POST")
    @PostMapping("/login")
    public ResponseData login(@RequestBody UserLoginDto userLoginDto) {
        UserNew userNew = userNewService.login(userLoginDto);
        if (userNew != null) {
            httpSession.setAttribute("userId", userNew.getId());
            return ResponseUtil.success(true);
        }
        return ResponseUtil.fail();
    }

    @ApiOperation(value = "注册用户（老师提供的）", notes = "注册用户（老师提供的）", httpMethod = "POST")
    @PostMapping("/register")
    public ResponseData register(@RequestBody UserInputDto userInputDto) {
        return userNewService.register(userInputDto);
    }
}
