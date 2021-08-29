package com.example.springboot.service.impl;

import com.example.springboot.dao.GradeDao;
import com.example.springboot.domain.Grade;
import com.example.springboot.domain.ResponseData;
import com.example.springboot.dto.GradeInputDto;
import com.example.springboot.service.GradeService;
import com.example.springboot.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = {Exception.class})
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeDao gradeDao;
    @Override
    public ResponseData getGrades() {
        return ResponseUtil.success(gradeDao.selectList(null));
    }

    @Override
    public ResponseData getGradeById(Integer id) {
        return ResponseUtil.success(gradeDao.selectById(id));
    }

    @Override
    public ResponseData addGrade(GradeInputDto gradeInputDto) {
        Grade grade = new Grade();
        BeanUtils.copyProperties(gradeInputDto,grade);
        gradeDao.insert(grade);
        return ResponseUtil.success(grade);
    }

    @Override
    public ResponseData deleteGrade(Integer id) {
        return ResponseUtil.success(gradeDao.deleteById(id));
    }

    @Override
    public ResponseData updateGrade(GradeInputDto gradeInputDto) {
        Grade grade = new Grade();
        BeanUtils.copyProperties(gradeInputDto,grade);
        gradeDao.updateById(grade);
        return ResponseUtil.success(grade);
    }
}
