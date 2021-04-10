package com.heima.ssm.controller;


import com.heima.ssm.domain.SysLog;
import com.heima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> all = sysLogService.findAll();
        modelAndView.addObject("sysLogs",all);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
