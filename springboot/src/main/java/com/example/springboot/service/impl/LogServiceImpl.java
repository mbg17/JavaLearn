package com.example.springboot.service.impl;

import com.example.springboot.dao.LogDao;
import com.example.springboot.domain.Log;
import com.example.springboot.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    @Override
    public void createLog(Log log) {
        logDao.insert(log);
    }
}
