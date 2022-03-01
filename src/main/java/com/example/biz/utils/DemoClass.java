package com.example.biz.utils;

/**
 * @Classname DemoClass
 * @Description 测试类
 * @Date 2022/2/27 9:51 下午
 * @Created by liuchang
 */
public class DemoClass {

    /**
     * 返回正常字符串
     * @return
     */
    public String getS(){
        return "liuchang";
    }


    /**
     * 返回异常
     * @return
     */
    public String getI(){
       throw new RuntimeException();
    }

    public String getX(Object o){
        return "hello";
    }
}
