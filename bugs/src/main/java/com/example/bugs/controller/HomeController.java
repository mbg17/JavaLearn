package com.example.bugs.controller;

import com.example.bugs.annocation.HasRole;
import com.example.bugs.common.Result;
import com.example.bugs.dao.ListMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@HasRole(roles = "staff")
public class HomeController {
    @Resource
    private ListMapper listMapper;

    @GetMapping("/getBugDetail")
    public Result getBugDetail() {
        return new Result(200, listMapper.getBugDetail(), "获取BUG信息成功");
    }

    @GetMapping("/submitBugs")
    public Result submitBugs() {
        return new Result(200, listMapper.submitBugs(), "获取BUG信息成功");
    }

    @GetMapping("/createBugs")
    public Result createBugs() {
        return new Result(200, listMapper.createBugs(), "获取BUG信息成功");
    }

    @GetMapping("/hasVersion")
    public Result hasVersion() {
        List<String> strings = listMapper.hasVersion();
        HashMap<String, Integer> stringObjectHashMap = new HashMap<>();
        for (String string : strings) {
            String[] split = string.split(",");
            for (String s : split) {
                stringObjectHashMap.put(s, stringObjectHashMap.getOrDefault(s, 0) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(stringObjectHashMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        List<HashMap<Object, Object>> hashMapHashMap = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            HashMap<Object, Object> stringIntegerHashMap = new HashMap<>();
            stringIntegerHashMap.put("value", entry.getValue());
            stringIntegerHashMap.put("name", entry.getKey());
            hashMapHashMap.add(stringIntegerHashMap);
        }
        return new Result(200, hashMapHashMap, "获取BUG信息成功");
    }
}
