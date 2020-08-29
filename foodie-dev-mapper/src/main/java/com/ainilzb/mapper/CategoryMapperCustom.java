package com.ainilzb.mapper;

import com.ainilzb.my.mapper.MyMapper;
import com.ainilzb.pojo.Category;

import java.util.List;

public interface CategoryMapperCustom{

    public List getSubCatList(Integer rootCatId);
}