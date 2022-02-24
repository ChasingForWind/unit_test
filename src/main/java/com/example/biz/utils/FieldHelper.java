package com.example.biz.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author: zhiyang
 * @description: 利用反射设置静态常量
 * @create: 2022-01-11 14:24
 **/


public final class FieldHelper {

    public static void setStaticFinalField(Class<?> clazz, String fieldName, Object fieldValue) throws NoSuchFieldException, IllegalAccessException {

        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        //去除final修饰符的影响，将字段设为可修改
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, fieldValue);
    }


}
