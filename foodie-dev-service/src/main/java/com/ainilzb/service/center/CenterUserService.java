package com.ainilzb.service.center;

import com.ainilzb.pojo.Users;
import com.ainilzb.pojo.bo.UserBo;
import com.ainilzb.pojo.bo.center.CenterUserBO;

public interface CenterUserService {
    /*
     * 根据用户id查询用户信息
     * */
    public Users queryUserInfo(String userId);

    /*
     * 修改用户信息
     * */
    public Users updateUserInfo(String userId, CenterUserBO centerUserBO);

}
