package com.example.demo;

import com.example.biz.service.UserServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @Classname SpyMock
 * @Description 测试spy
 * @Date 2022/2/28 11:23 下午
 * @Created by liuchang
 */
public class SpyMock {

    @Spy
    private ArrayList<String> list;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(UserServiceTest.class);
    }

    @Test
    public void should_get_real_mock_value(){
        //构建值
        list.add("liuchang");

        //打桩
        when(list.isEmpty()).thenReturn(true);

        //验证
        Assert.assertEquals("liuchang",list.get(0));
    }
}
