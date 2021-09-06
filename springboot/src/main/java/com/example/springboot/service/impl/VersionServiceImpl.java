package com.example.springboot.service.impl;

import com.example.springboot.dao.VersionDao;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.Version;
import com.example.springboot.dto.VersionDto;
import com.example.springboot.service.VersionService;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Set;


@Service
@Transactional(rollbackFor = {Exception.class})
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionDao versionDao;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ResponseData getList() {
        ResponseData version_all = (ResponseData) redisTemplate.opsForValue().get("version_all::getList");
        if (version_all != null) {
            return version_all;
        }
        ResponseData success = ResponseUtil.success(versionDao.selectList(null));
        redisTemplate.opsForValue().set("version_all::getList", success, Duration.ofMinutes(1));
        return success;
    }

    @Override
    public ResponseData addVersion(VersionDto versionDto) {
        Version version = new Version();
        BeanUtils.copyProperties(versionDto, version);
        versionDao.insert(version);
        Set<String> keys = redisTemplate.keys("version_all:" + "*");
        redisTemplate.delete(keys);
        return ResponseUtil.success(version);
    }

    @Override
    public ResponseData updateVersion(VersionDto versionDto) {
        Version version = new Version();
        BeanUtils.copyProperties(versionDto, version);
        versionDao.updateById(version);
        Set<String> keys = redisTemplate.keys("version_all:" + "*");
        redisTemplate.delete(keys);
        return ResponseUtil.success(version);
    }

    @Override
    public ResponseData deleteVersion(Integer id) {
        Set<String> keys = redisTemplate.keys("version_all:" + "*");
        redisTemplate.delete(keys);
        return ResponseUtil.success(versionDao.deleteById(id));
    }

    @Override
    public ResponseData getVersionById(Integer id) {
        ResponseData version_all = (ResponseData) redisTemplate.opsForValue().get("version_all::" + id);
        if (version_all != null) {
            return version_all;
        }
        ResponseData success = ResponseUtil.success(versionDao.selectById(id));
        redisTemplate.opsForValue().set("version_all::" + id, success, Duration.ofMinutes(1));
        return success;
    }
}
