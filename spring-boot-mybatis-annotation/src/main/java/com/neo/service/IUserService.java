package com.neo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.neo.entity.UserEntity;

import java.util.List;

public interface IUserService {

    PageInfo getAll(int pageNum, int pageSize);
}
