package com.example.springboot.service.impl;

import com.example.springboot.dao.VersionDao;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.Version;
import com.example.springboot.dto.VersionDto;
import com.example.springboot.service.VersionService;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = {Exception.class})
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionDao versionDao;

    @Override
    public ResponseData getList() {
        return ResponseUtil.success(versionDao.selectList(null));
    }

    @Override
    public ResponseData addVersion(VersionDto versionDto) {
        Version version = new Version();
        BeanUtils.copyProperties(versionDto,version);
        versionDao.insert(version);
        return ResponseUtil.success(version);
    }

    @Override
    public ResponseData updateVersion(VersionDto versionDto) {
        Version version = new Version();
        BeanUtils.copyProperties(versionDto,version);
        versionDao.updateById(version);
        return ResponseUtil.success(version);
    }

    @Override
    public ResponseData deleteVersion(Integer id) {
        return ResponseUtil.success(versionDao.deleteById(id));
    }

    @Override
    public ResponseData getVersionById(Integer id) {
        return ResponseUtil.success(versionDao.selectById(id));
    }
}
