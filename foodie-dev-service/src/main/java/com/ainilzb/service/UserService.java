package com.ainilzb.service;

import com.ainilzb.pojo.Users;
import com.ainilzb.pojo.bo.UserBo;

public interface UserService {
    /*
    * 判断用户名是否存在
    * */
    public boolean queryUsernameIsExist(String username);
    /*
    * 创建用户
    * */
    public Users createUser(UserBo userBo);

}
