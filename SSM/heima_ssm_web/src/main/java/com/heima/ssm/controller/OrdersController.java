package com.heima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.heima.ssm.domain.Orders;
import com.heima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(required = true,name = "page",defaultValue = "1")int page,@RequestParam(required = true,name = "size",defaultValue = "5")int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> all = ordersService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(all);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping(path = "/detail.do")
    public ModelAndView detail(@RequestParam(required = true,name = "id")String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders byId = ordersService.findById(id);
        System.out.println(byId);
        modelAndView.addObject("orders",byId);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
