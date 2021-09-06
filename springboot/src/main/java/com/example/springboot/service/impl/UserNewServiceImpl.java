package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.dao.UserNewDao;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.UserNew;
import com.example.springboot.dto.UserInputDto;
import com.example.springboot.dto.UserLoginDto;
import com.example.springboot.service.UserNewService;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserNewServiceImpl implements UserNewService {
    @Resource
    private UserNewDao userNewDao;

    @Override
    public UserNew login(UserLoginDto userLoginDto) {
        QueryWrapper<UserNew> userNewQueryWrapper = new QueryWrapper<>();
        userNewQueryWrapper.eq("username", userLoginDto.getUsername());
        userNewQueryWrapper.eq("password", userLoginDto.getPassword());
        return userNewDao.selectOne(userNewQueryWrapper);
    }

    @Override
    public ResponseData register(UserInputDto userInputDto) {
        UserNew userNew = new UserNew();
        BeanUtils.copyProperties(userInputDto, userNew);
        userNewDao.insert(userNew);
        return ResponseUtil.success("注册成功");
    }
}
