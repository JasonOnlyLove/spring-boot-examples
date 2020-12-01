package com.neo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author:
 * Datetime: 2020/10/20 19:07
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);//底层实现原理采用改写语句  将下面的方法中的sql语句获取到然后做个拼接 limit
        List<UserEntity> userEntityList = userMapper.getAll();
        PageInfo pageInfoSpecialSelect = new PageInfo(userEntityList);
        return pageInfoSpecialSelect;
    }

}
