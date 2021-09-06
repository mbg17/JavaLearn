package com.example.springboot.scheduling;

import com.example.springboot.dao.VersionDao;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Set;

@Component
public class VersionTask {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private VersionDao versionDao;

    @Scheduled(cron = "0 0 1 * * ?")
    public void execute() {
        Set<String> keys = redisTemplate.keys("version_all:*");
        redisTemplate.delete(keys);
        ResponseData success = ResponseUtil.success(versionDao.selectList(null));
        redisTemplate.opsForValue().set("version_all::getList", success, Duration.ofMinutes(1));
    }
}
