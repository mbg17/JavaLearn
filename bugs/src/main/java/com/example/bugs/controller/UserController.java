package com.example.bugs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.common.Result;
import com.example.bugs.dao.UserMapper;
import com.example.bugs.domain.User;
import com.example.bugs.domain.Version;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/getUsers")
    public IPage<User> getUsers() {
        return userMapper.selectPage(new Page(1, 10), null);
    }

    @PostMapping("/login")
    public Result login(@RequestBody HashMap<String, Object> loginForm) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        User user = new User();
        List<User> findUser = userMapper.selectByMap(loginForm);
        if (findUser.size() == 0) {
            return new Result(500, null, "登录失败");
        }
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("nickName", findUser.get(0).getNickname());
        stringObjectHashMap.put("userid", findUser.get(0).getId());
        return new Result(200, stringObjectHashMap, "登录成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody HashMap<String, String> registerForm) {
        if (registerForm.get("username") != null && registerForm.get("password") != null) {
            User user = new User();
            user.setUsername(registerForm.get("username"));
            user.setNickname(registerForm.get("username"));
            user.setPassword(registerForm.get("password"));
            user.setCreateBy("system");
            user.setModifyBy("system");
            try {
                userMapper.insert(user);
                return new Result(200, null, "注册成功");
            } catch (Exception e) {
                System.out.println(e);
                return new Result(500, null, "已存在该账户");
            }
        }
        return new Result(500, null, "信息不完整注册失败");
    }


    @GetMapping("/getUsers/{current}/{pageSize}")
    public Result getUsers(@PathVariable("current") Integer current, @PathVariable("pageSize") Integer pageSize) {
        if (current <= 0) {
            current = 1;
        }
        return new Result(200, userMapper.selectPage(new Page<User>(current, pageSize), null), "获取用户信息成功");
    }

    @DeleteMapping("/removeUser/{id}")
    public Result removeUser(@PathVariable("id") int id) {
        userMapper.deleteById(id);
        return new Result(200, null, "删除用户成功");
    }

    @GetMapping("/getUserDetail/{id}")
    public Result getUserDetail(@PathVariable("id") int id) {
        User user = userMapper.selectById(id);
        return new Result(200, user, "获取用户信息成功");
    }

    @PostMapping("/modifyUser")
    public Result modifyUser(@RequestBody HashMap<String, Object> hashMap) {
        userMapper.modifyVersion(hashMap);
        return new Result(200, null, "修改用户信息成功");
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody HashMap<String, String> hashMap) {
        System.out.println(hashMap);
        User user = new User();
        user.setPassword(hashMap.get("username"));
        user.setUsername(hashMap.get("password"));
        user.setNickname(hashMap.get("password"));
        user.setCreateBy(hashMap.get("nickname"));
        user.setModifyBy(hashMap.get("nickname"));
        userMapper.insert(user);
        return new Result(200, null, "添加用户成功");
    }

    @GetMapping("/getAllUser")
    public Result getAllUser() {
        return new Result(200, userMapper.selectList(null), "获取用户信息成功");
    }
}
