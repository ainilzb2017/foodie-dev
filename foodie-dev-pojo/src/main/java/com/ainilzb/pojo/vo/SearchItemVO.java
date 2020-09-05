package com.ainilzb.pojo.vo;

import com.ainilzb.pojo.Items;
import com.ainilzb.pojo.ItemsImg;
import com.ainilzb.pojo.ItemsParam;
import com.ainilzb.pojo.ItemsSpec;

import java.util.List;

/*
* 用于展示商品搜索列表结果的VO
* */
public class SearchItemVO {
    private String itemId;
    private String itemName;
    private int sellCounts;
    private String imgUrl;
    private int price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(int sellCounts) {
        this.sellCounts = sellCounts;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
