package com.example.biz.dao.mapper;

import com.example.biz.dao.domain.SelfUserDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SelfUserDetailMapperTest extends BaseMapperTest {

    @Autowired
    private SelfUserDetailMapper selfUserDetailMapper;

    @Test
    void selectByPrimaryKey() {
        SelfUserDetail selfUserDetail = selfUserDetailMapper.selectByPrimaryKey(2);
        System.out.println(selfUserDetail);
        assertEquals("liuchang",selfUserDetail.getName(), "用户名称不匹配");
    }
}