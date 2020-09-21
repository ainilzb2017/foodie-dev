package com.ainilzb.service;

import com.ainilzb.pojo.UserAddress;
import com.ainilzb.pojo.bo.AddressBO;
import com.sun.media.sound.FFT;

import java.util.List;

public interface AddressService {
    /*
    * 根据用户id搜索收获地址列表
    * */
    public List<UserAddress> queryAll(String userId);
    /*
    * 用户新增收货地址
    * */
    public void addNewUserAddress(AddressBO addressBO);
    /*
     * 用户修改地址
     * */
    public void updateUserAddress(AddressBO addressBO);

    /*
    * 根据用户id和地址id，删除对应的用户地址信息
    * */
    public void deleteUserAddress(String userId,String addressId);
    /*
     * 修改默认地址
     * */
    public void updateUserAddressToBeDefault(String userId,String addressId);
    /*
     * 根据用户id和地址id，查询具体的用户地址对象信息
     * */
    public UserAddress queryUserAddress(String userId,String addressId);

}
