package com.example.biz.service;

import com.example.biz.dao.domain.SelfUserDetail;
import com.example.biz.dao.mapper.SelfUserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhiyang
 * @description: 自定义查询数据库服务
 * @create: 2022-01-17 11:16
 **/


@Service
public class SelfUserService {
    @Autowired
    SelfUserDetailMapper selfUserDAO;

    public SelfUserDetail getUserById(Integer id){
        return selfUserDAO.selectByPrimaryKey(id);
    }
}
