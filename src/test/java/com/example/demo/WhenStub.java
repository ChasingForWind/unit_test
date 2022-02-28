package com.example.demo;

import org.junit.Before;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.instanceOf;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @Classname WhenStub
 * @Description 简单stub测试
 * @Date 2022/2/27 8:35 下午
 * @Created by liuchang
 */
public class WhenStub {
    private List<String> list;

    @Before
    public void init(){
        this.list = mock(ArrayList.class);
    }

    @Test
    public void how_to_use_stubbing(){
        //打桩
        when(list.get(0)).thenReturn("liuchang");

        //验证
        assertThat(list.get(0)).isEqualTo("liuchang");
    }

    @Test
    public void how_to_use_stubbing_throw_exception(){
        //打桩
        when(list.get(anyInt())).thenThrow(RuntimeException.class);

        //验证
        try {
            list.get(0);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
    }

    @Test
    public void should_donothing(){
        //打桩
        doNothing().when(list).clear();
        list.clear();

        //验证
        verify(list,times(1)).clear();
    }

    @Test
    public void should_throw_exception(){
        //打桩
        doThrow(RuntimeException.class).when(list).clear();

        //验证
        try {
            list.clear();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }

    }



}
