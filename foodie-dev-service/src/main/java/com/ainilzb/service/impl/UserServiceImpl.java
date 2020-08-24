package com.ainilzb.service.impl;

import com.ainilzb.enums.Sex;
import com.ainilzb.mapper.StuMapper;
import com.ainilzb.mapper.UsersMapper;
import com.ainilzb.pojo.Stu;
import com.ainilzb.pojo.Users;
import com.ainilzb.pojo.bo.UserBo;
import com.ainilzb.service.StuService;
import com.ainilzb.service.UserService;
import com.ainilzb.utils.DateUtil;
import com.ainilzb.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userExampleCriteria =  userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false:true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBo userBo) {
        Users user = new Users();
        user.setUsername(userBo.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称，同用户名
        user.setNickname(userBo.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        //默认性别为保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        return null;
    }


}
