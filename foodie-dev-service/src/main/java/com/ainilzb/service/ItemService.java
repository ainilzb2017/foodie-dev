package com.ainilzb.service;

import com.ainilzb.pojo.Items;
import com.ainilzb.pojo.ItemsImg;
import com.ainilzb.pojo.ItemsParam;
import com.ainilzb.pojo.ItemsSpec;
import com.ainilzb.pojo.vo.CommentLevelCountsVO;
import com.ainilzb.pojo.vo.ItemCommentVO;
import com.ainilzb.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    /*
    * 根据商品id查询详情
    * */
    public Items queryItemById(String itemId);

    /*
    * 根据商品id查询商品图片列表
    * */
    public List<ItemsImg> queryItemImgList(String itemId);

    /*
     * 根据商品id查询商品规格列表
     * */
    public List<ItemsSpec> queryItemSpecList(String itemId);


    /*
     * 根据商品id查询参数
     * */
    public ItemsParam queryItemParam(String itemId);

    /*
     * 根据商品id查询商品评价等级
     * */
    public CommentLevelCountsVO queryCommentCount(String itemId);

    /*
    * 这是根据商品id查询商品的评价（带分页）
    * */
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);



}
