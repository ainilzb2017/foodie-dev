package com.ainilzb.mapper;

import com.ainilzb.my.mapper.MyMapper;
import com.ainilzb.pojo.Category;
import com.ainilzb.pojo.vo.CategoryVO;
import com.ainilzb.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom{

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);

}