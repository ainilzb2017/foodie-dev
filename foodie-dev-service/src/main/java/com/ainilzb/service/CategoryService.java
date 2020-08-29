package com.ainilzb.service;

import com.ainilzb.pojo.Carousel;
import com.ainilzb.pojo.Category;
import com.ainilzb.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    /*
    * 查询所有一级分类
    * */
    public List<Category> queryAllRootLevelCat();

    /*
    * 根据一级分类id查询子分类信息
    * */
    public List<CategoryVO> getSubCatList(Integer rootCatId);

}
