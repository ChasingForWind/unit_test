package com.example.biz.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: zhiyang
 * @description: uuid生成
 * @create: 2022-01-10 15:39
 **/

@Component
public class IdGenerator {

    /**
     *  获取uuid
     * @return Long 类型uuid
     */
    public Long getUUID(){
        return Long.valueOf(UUID.randomUUID().toString());
    }
}
