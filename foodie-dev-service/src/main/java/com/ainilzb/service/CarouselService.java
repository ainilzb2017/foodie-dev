package com.ainilzb.service;

import com.ainilzb.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    /*
    * 查询所有轮播图列表
    * */
    public List<Carousel> queryAll(Integer isShow);

}
