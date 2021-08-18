package com.example.springboot.service;

import com.example.springboot.domain.Log;

import java.util.List;

public interface LogService {

    void createLog(Log log);

    List<Log> logs();
}
