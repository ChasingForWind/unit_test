package com.example.demo;

import com.example.biz.service.UserServiceTest;
import com.example.biz.utils.DemoClass;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

/**
 * @Classname ArgumentMatchers
 * @Description 测试语法
 * @Date 2022/2/28 11:42 下午
 * @Created by liuchang
 */
public class ArgumentMatchers {

    @Mock
    private DemoClass demoClass;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(UserServiceTest.class);
    }

    @Test
    public void should_return_hi_when_input_some_class(){
        //打桩
        when(demoClass.getX(Mockito.isA(String.class))).thenReturn("hi");

        //验证
        Assert.assertEquals("hi",demoClass.getX("1111"));
    }

    @Test
    public void should_return_hi_no_matter_input(){
        //打桩
        when(demoClass.getX(Mockito.any())).thenReturn("hi");

        //验证
        Assert.assertEquals("hi",demoClass.getX(1));
    }

    @Test
    public void should_return_hi_when_input_0(){
        //打桩
        when(demoClass.getX(Mockito.eq(0))).thenReturn("hi");

        //验证
        Assert.assertEquals("hi",demoClass.getX(0));
        Assert.assertEquals("hello",demoClass.getX(1));
    }


}
