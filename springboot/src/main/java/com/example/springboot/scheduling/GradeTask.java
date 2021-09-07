package com.example.springboot.scheduling;

import com.example.springboot.dao.GradeDao;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Set;

@Component
public class GradeTask {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private GradeDao gradeDao;

    @Scheduled(cron = "0 0 0/8 * * ? ")
    public void execute() {
        Set<String> keys = redisTemplate.keys("grade_all:*");
        redisTemplate.delete(keys);
        ResponseData success = ResponseUtil.success(gradeDao.selectList(null));
        redisTemplate.opsForValue().set("grade_all::getGrades", success, Duration.ofMinutes(1));
    }
}
