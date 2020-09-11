package com.ainilzb.mapper;

import com.ainilzb.pojo.vo.ItemCommentVO;
import com.ainilzb.pojo.vo.SearchItemVO;
import com.ainilzb.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom{

    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
    public List<SearchItemVO> searchItems(@Param("paramsMap") Map<String, Object> map);
    public List<SearchItemVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);
    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);



}