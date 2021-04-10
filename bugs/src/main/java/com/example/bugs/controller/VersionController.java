package com.example.bugs.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.common.Result;
import com.example.bugs.dao.VersionMapper;
import com.example.bugs.domain.Version;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VersionController {

    @Resource
    private VersionMapper versionMapper;

    @GetMapping("/getVersions/{currentPage}/{pages}")
    public Result getVersions(@PathVariable("currentPage") Integer currentPage, @PathVariable("pages") Integer pages) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        IPage<Version> versionPage = versionMapper.selectPage(new Page<>(currentPage, pages), null);
        return new Result(200, versionPage, "获取版本信息成功");
    }

    @GetMapping("/getAllVersions")
    public Result getAllVersions() {
        return new Result(200, versionMapper.selectList(null), "获取版本信息成功");
    }

    @GetMapping("/getVersionDetail/{id}")
    public Result getVersionDetail(@PathVariable("id") int id) {
        Version version = versionMapper.selectById(id);
        return new Result(200, version, "获取版本信息成功");
    }

    @PostMapping("/modifyVersion")
    public Result modifyVersion(@RequestBody HashMap<String, Object> hashMap) {
        versionMapper.modifyVersion(hashMap);
        return new Result(200, null, "修改版本信息成功");
    }

    @DeleteMapping("/removeVersion/{id}")
    public Result modifyVersion(@PathVariable("id") int id) {
        versionMapper.deleteById(id);
        return new Result(200, null, "删除版本信息成功");
    }

    @PostMapping("/addVersions")
    public Result addVersions(@RequestBody HashMap<String, String> hashMap) {
        System.out.println(hashMap);
        Version version = new Version();
        version.setVersion(hashMap.get("version"));
        version.setDetail(hashMap.get("detail"));
        version.setCreateBy(hashMap.get("username"));
        version.setModifyBy(hashMap.get("username"));
        versionMapper.insert(version);
        return new Result(200, null, "添加版本成功");
    }

    @GetMapping("/findAllVersion")
    public Result findAllVersion() {
        return new Result(200, versionMapper.findAllVersion(), "添加版本成功");
    }
}
