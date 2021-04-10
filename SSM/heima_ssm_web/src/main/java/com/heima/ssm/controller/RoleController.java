package com.heima.ssm.controller;

import com.heima.ssm.domain.Orders;
import com.heima.ssm.domain.Permission;
import com.heima.ssm.domain.Role;
import com.heima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> all = roleService.findAll();
        modelAndView.addObject("roleList",all);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role byId = roleService.findById(id);
        modelAndView.addObject("role",byId);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }
    @RequestMapping("/delRole.do")
    public String delRole(String id) throws Exception {
        roleService.delRole(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role byId = roleService.findById(id);
        List<Permission> list = roleService.findOtherPermission(id);
        System.out.println(list);
        modelAndView.addObject("role",byId);
        modelAndView.addObject("permissionList",list);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleid, @RequestParam(name = "ids",required = false)  String[] ids) throws Exception {
        if(ids!=null && ids.length>0){
            roleService.savePermission(roleid,ids);
        }
        return "redirect:findAll.do";
    }
}
