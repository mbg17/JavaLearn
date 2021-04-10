package com.heima.ssm.controller;

import com.heima.ssm.domain.Product;
import com.heima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;

    }

    //保存产品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查看详情
    @RequestMapping("/detail.do")
    public ModelAndView detail(@RequestParam( required = true,name = "id" ,defaultValue = "1") String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.addObject("productDetail", product);
        modelAndView.setViewName("product-detail");
        return modelAndView;
    }

    @RequestMapping("/alter.do")
    public ModelAndView alter(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        String id = request.getParameter("id");
        Product product = productService.findById(id);
        modelAndView.addObject("alterDetail", product);
        modelAndView.setViewName("product-alter");
        return modelAndView;
    }

    // 更新操作
    @RequestMapping("/modify.do")
    public String modify(Product product) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        productService.updateProduct(product);
        return "redirect:findAll.do";
    }
}
