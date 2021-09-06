package com.example.springboot.service.impl;

import com.example.springboot.dao.BugDao;
import com.example.springboot.domain.Bug;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.dto.BugInputDto;
import com.example.springboot.service.BugService;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = {Exception.class})
public class BugServiceImpl implements BugService {
    @Resource
    private BugDao bugDao;

    @Override
    public ResponseData getBugs() {
        return ResponseUtil.success(bugDao.getAllBugs());
    }

    @Override
    public ResponseData addBug(BugInputDto bugInputDto) {
        Bug bug = new Bug();
        BeanUtils.copyProperties(bugInputDto, bug);
        bugDao.insert(bug);
        for (Integer version : bugInputDto.getVersions()) {
            bugDao.addBugVersions(bug.getId(), version);
        }
        return ResponseUtil.success(bugDao.getBugById(bug.getId()));
    }

    @Override
    public ResponseData getBugById(Integer id) {
        return ResponseUtil.success(bugDao.getBugById(id));
    }

    @Override
    public ResponseData deleteBug(Integer id) {
        bugDao.deleteById(id);
        bugDao.deleteVersions(id);
        return ResponseUtil.success(true);
    }

    @Override
    public ResponseData updateBug(BugInputDto bugInputDto) {
        Bug bug = new Bug();
        BeanUtils.copyProperties(bugInputDto, bug);
        bugDao.updateById(bug);
        bugDao.deleteVersions(bug.getId());
        for (Integer version : bugInputDto.getVersions()) {
            bugDao.addBugVersions(bug.getId(), version);
        }
        return getBugById(bug.getId());
    }
}
