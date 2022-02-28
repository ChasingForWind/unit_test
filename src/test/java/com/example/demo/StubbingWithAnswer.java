package com.example.demo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Classname StubbingWithAnswer
 * @Description 处理测试入参
 * @Date 2022/2/27 9:08 下午
 * @Created by liuchang
 */
public class StubbingWithAnswer {
    private List<String> list;

    @Before
    public void init(){
        this.list = mock(ArrayList.class);
    }

    /**
     * 打桩时处理一些逻辑问题
     */
    @Test
    public void should_return_ten_times(){
       //打桩
        when(list.get(anyInt())).thenAnswer(i->{
            //获取入参 invocationOnMock
            Integer index =  i.getArgument(0,Integer.class);

            //入参变为string类型
            return String.valueOf(index);
        });

        //验证
        assertThat(list.get(0)).isEqualTo("0");
    }
}
