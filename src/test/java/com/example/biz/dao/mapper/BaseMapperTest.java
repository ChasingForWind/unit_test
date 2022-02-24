package com.example.biz.dao.mapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: zhiyang
 * @description: 数据测试基类
 * @create: 2022-01-18 10:12
 **/


@RunWith(SpringRunner.class)
@ActiveProfiles(value="test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BaseMapperTest {
}
