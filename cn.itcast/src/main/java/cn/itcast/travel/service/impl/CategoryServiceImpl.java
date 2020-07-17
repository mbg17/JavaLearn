package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;

import java.util.List;

/**
 * @author 陆远
 */
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao cd = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return cd.findAll();
    }
}
