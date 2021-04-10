package com.heima.ssm.controller;

import com.heima.ssm.domain.Role;
import com.heima.ssm.domain.UserInfo;
import com.heima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> all = userService.findAll();
        modelAndView.addObject("userList",all);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String saveUser(UserInfo userInfo) throws Exception {
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo byId = userService.findById(id);
        modelAndView.addObject("user",byId);
        modelAndView.setViewName("user-show1");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userid) throws Exception {
        System.out.println(userid);
        ModelAndView modelAndView = new ModelAndView();
        UserInfo byId = userService.findById(userid);
        List<Role> list = userService.findOtherRoles(userid);
        modelAndView.addObject("user",byId);
        modelAndView.addObject("roleList",list);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userid,@RequestParam(name = "ids")  String[] ids) throws Exception {
        if(ids!=null && ids.length>0){
            userService.saveRoles(userid,ids);
        }
        return "redirect:findAll.do";
    }

}
