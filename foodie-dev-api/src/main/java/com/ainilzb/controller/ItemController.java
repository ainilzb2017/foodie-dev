package com.ainilzb.controller;

import com.ainilzb.pojo.Items;
import com.ainilzb.pojo.ItemsImg;
import com.ainilzb.pojo.ItemsParam;
import com.ainilzb.pojo.ItemsSpec;
import com.ainilzb.pojo.vo.CommentLevelCountsVO;
import com.ainilzb.pojo.vo.ItemInfoVO;
import com.ainilzb.service.ItemService;
import com.ainilzb.utils.IMOOCJSONResult;
import com.ainilzb.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商品接口",tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("/items")
public class ItemController  extends BaseController{

    @Autowired
    private ItemService itemService;


    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(
            @ApiParam(name = "itemId", value = "商品id",required = true)
            @PathVariable String itemId){
        if(StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }
        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemSpecList =  itemService.queryItemSpecList(itemId);
        ItemsParam itemParam =  itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemSpecList);
        itemInfoVO.setItemParams(itemParam);
        return IMOOCJSONResult.ok(itemInfoVO);
    }


    @ApiOperation(value = "查询商品评价等级",notes = "查询商品评价等级",httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id",required = true)
            @RequestParam String itemId){
        if(StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }
        CommentLevelCountsVO countsVO = itemService.queryCommentCount(itemId);

        return IMOOCJSONResult.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评论",notes = "查询商品评论",httpMethod = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult comments(@ApiParam(name = "itemId", value = "商品id",required = true) @RequestParam String itemId,
                                    @ApiParam(name = "level", value = "评价等级",required = false) @RequestParam Integer level,
                                    @ApiParam(name = "page", value = "查询下一页的第几页",required = false) @RequestParam Integer page,
                                    @ApiParam(name = "pageSize", value = "分页的每一页显示的条数",required = false) @RequestParam Integer pageSize){
        if(StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }
        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = COMMON_PAGE_SIZE;
        }
        PagedGridResult grid = itemService.queryPagedComments(itemId,level,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }









}