package com.example.bugs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.annocation.HasRole;
import com.example.bugs.common.Result;
import com.example.bugs.dao.UserMapper;
import com.example.bugs.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private HttpSession httpSession;

    @Resource
    private UserMapper userMapper;

    @HasRole(roles = "admin")
    @GetMapping("/getUsers")
    public IPage<User> getUsers() {
        return userMapper.selectPage(new Page(1, 10), null);
    }

    public static String getMD5(String str, String salt) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update((str + salt).getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody User loginForm) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", loginForm.getUsername());
        userQueryWrapper.eq("password", getMD5(loginForm.getPassword(), loginForm.getUsername()));
        User findUser = userMapper.selectOne(userQueryWrapper);
        if (findUser == null) {
            return new Result(500, null, "登录失败");
        }
        httpSession.setAttribute("user", findUser);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("nickName", findUser.getNickname());
        stringObjectHashMap.put("userid", findUser.getId());
        stringObjectHashMap.put("auth", findUser.getRoles());
        return new Result(200, stringObjectHashMap, "登录成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody HashMap<String, String> registerForm) {
        if (registerForm.get("username") != null && registerForm.get("password") != null) {
            User user = new User();
            user.setUsername(registerForm.get("username"));
            user.setNickname(registerForm.get("username"));
            user.setPassword(getMD5(registerForm.get("password"), registerForm.get("username")));
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

    @HasRole(roles = "admin")
    @GetMapping("/getUsers/{current}/{pageSize}")
    public Result getUsers(@PathVariable("current") Integer current, @PathVariable("pageSize") Integer pageSize) {
        if (current <= 0) {
            current = 1;
        }
        return new Result(200, userMapper.selectPage(new Page<User>(current, pageSize), null), "获取用户信息成功");
    }

    @HasRole(roles = "admin")
    @DeleteMapping("/removeUser/{id}")
    public Result removeUser(@PathVariable("id") int id) {
        userMapper.deleteById(id);
        return new Result(200, null, "删除用户成功");
    }

    @HasRole(roles = "admin")
    @GetMapping("/getUserDetail/{id}")
    public Result getUserDetail(@PathVariable("id") int id) {
        User user = userMapper.selectById(id);
        return new Result(200, user, "获取用户信息成功");
    }

    @HasRole(roles = "admin")
    @PostMapping("/modifyUser")
    public Result modifyUser(@RequestBody User user) {
        userMapper.updateById(user);
        return new Result(200, null, "修改用户信息成功");
    }

    @HasRole(roles = "admin")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody HashMap<String, String> hashMap) {
        User user = new User();
        user.setPassword(getMD5(hashMap.get("password"), hashMap.get("username")));
        user.setUsername(hashMap.get("username"));
        user.setNickname(hashMap.get("username"));
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
