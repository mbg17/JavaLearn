package com.example.bugs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.annocation.HasRole;
import com.example.bugs.common.Result;
import com.example.bugs.dao.ListMapper;
import com.example.bugs.domain.Lists;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@RestController
@HasRole(roles = "staff")
public class BugsController {
    @Resource
    private ListMapper listMapper;

    @PostMapping("/getAllBugs/{current}/{pageSize}")
    public Result getAllBugs(@PathVariable("current") Integer current, @PathVariable("pageSize") Integer pageSize, @RequestBody HashMap<String, String> hashMap) {
        if (current <= 0) {
            current = 1;
        }
        QueryWrapper<Lists> listsQueryWrapper = new QueryWrapper<>();
        if (hashMap.get("title") != null) {
            listsQueryWrapper.like("title", hashMap.get("title"));
        }
        if (hashMap.get("project") != null) {
            listsQueryWrapper.like("project", hashMap.get("project"));
        }
        return new Result(200, listMapper.selectPage(new Page<Lists>(current, pageSize), listsQueryWrapper), "获取缺陷信息成功");
    }

    @PostMapping("/addBug")
    public Result addBug(@RequestBody HashMap<String, String> hashMap) {
        listMapper.addBug(hashMap);
        return new Result(200, null, "bug提交成功");
    }

    @GetMapping("/getBugByid/{id}")
    public Result getBugByid(@PathVariable Integer id) {
        return new Result(200, listMapper.selectById(id), "bug提交成功");
    }

    @PostMapping("/modifyBug")
    public Result modifyBug(@RequestBody Lists lists) {
        listMapper.updateById(lists);
        return new Result(200, null, "修改成功");
    }

    @PostMapping("/searchBugs")
    public Result searchBugs(@RequestBody HashMap<String, String> hashMap) {
        QueryWrapper<Lists> listsQueryWrapper = new QueryWrapper<>();
        if (hashMap.get("title") != null) {
            listsQueryWrapper.like("title", hashMap.get("title"));
        }
        if (hashMap.get("project") != null) {
            listsQueryWrapper.like("project", hashMap.get("project"));
        }
        return new Result(200, listMapper.selectPage(new Page<Lists>(1, 10), listsQueryWrapper), "查找成功");
    }

    @DeleteMapping("/removeBug/{id}")
    public Result removeBug(@PathVariable("id") int id) {
        listMapper.deleteById(id);
        return new Result(200, null, "删除成功");
    }
}
