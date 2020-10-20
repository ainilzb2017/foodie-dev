package com.ainilzb.mapper;

import com.ainilzb.my.mapper.MyMapper;
import com.ainilzb.pojo.ItemsComments;
import com.ainilzb.pojo.vo.center.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {
    public void saveComment(Map<String,Object> map);
    public List<MyCommentVO> queryMyComments(@Param("paramsMap")Map<String,Object> map);
}