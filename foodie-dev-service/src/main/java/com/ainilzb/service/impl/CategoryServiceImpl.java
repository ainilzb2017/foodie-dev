package com.ainilzb.service.impl;

import com.ainilzb.mapper.CarouselMapper;
import com.ainilzb.mapper.CategoryMapper;
import com.ainilzb.pojo.Carousel;
import com.ainilzb.pojo.Category;
import com.ainilzb.pojo.vo.CategoryVO;
import com.ainilzb.service.CarouselService;
import com.ainilzb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Executable;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        //查询分类为1的大分类，可以写成枚举
        criteria.andEqualTo("type",1);
        List<Category> result = categoryMapper.selectByExample(example);
        return result;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return null;
    }


}
