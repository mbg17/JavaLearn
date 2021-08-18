package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.annocation.NotAop;
import com.example.springboot.dao.LogDao;
import com.example.springboot.domain.Log;
import com.example.springboot.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@NotAop
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    @Override
    public void createLog(Log log) {
        logDao.insert(log);
    }

    @Override
    public List<Log> logs() {
        QueryWrapper<Log> logQueryWrapper = new QueryWrapper<>();
        logQueryWrapper.orderByDesc("operation");
        return logDao.selectList(logQueryWrapper);
    }
}
