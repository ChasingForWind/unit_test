package com.example.demo;

import com.example.biz.service.UserServiceTest;
import com.example.biz.utils.DemoClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * @Classname MockAndReal
 * @Description 测试是真实值还是使用mock值
 * @Date 2022/2/27 9:54 下午
 * @Created by liuchang
 */
public class MockAndReal {

    @Mock
    private DemoClass demoClass;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(UserServiceTest.class);
    }

    @Test
    public void should_have_real_and_mock(){
        //打桩

        //期望mock值
        when(demoClass.getI()).thenReturn("mock");
        //期望真实值
        when(demoClass.getS()).thenCallRealMethod();

        //验证
        Assert.assertEquals("mock",demoClass.getI());
        Assert.assertEquals("liuchang",demoClass.getS());
    }

}
