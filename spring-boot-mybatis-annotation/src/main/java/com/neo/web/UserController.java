package com.neo.web;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    //在参数里接受当前是第几页 pageNum,以及每页显示多少条数据 pageSize.默认值分别是1和10
    @GetMapping("/list")
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize, Model model) {

//        pageInfo.getPageNum():当前页
//        pageInfo.getPageSize():每页条数
//        pageInfo.getPages():总页数
//        pageInfo.getTotal():总条数
//        pageInfo.getList():数据
//        pageInfo.getPrePage():上一页
//        pageInfo.getNextPage():下一页
//        pageInfo.isIsFirstPage():是否第一页
//        pageInfo.isIsLastPage():是否最后一页
//        pageInfo.getNavigateFirstPage():展示的第一个页面
//        pageInfo..getNavigateLastPage():展示的最后一个页码

        PageInfo pageInfoUsersSelect = userService.getAll(pageNum, pageSize);
        //pageInfoUsersSelect.getNavigatepageNums();
        model.addAttribute("pageInfo", pageInfoUsersSelect);
        return "userlist";

    }
}