package com.heima.ssm.service;

import com.heima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogService {

    List<SysLog> findAll() throws Exception;

    void save(SysLog sysLog) throws Exception;
}
