package com.example.biz.service;

import com.alibaba.fastjson.JSON;
import com.example.biz.dao.domain.UserDO;
import com.example.biz.mock.UserDAO;
import com.example.biz.service.vo.UserVO;
import com.example.biz.utils.IdGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mule.util.IOUtils;
import org.powermock.reflect.Whitebox;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


/**
 * 用户服务测试类
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {
    /** 模拟依赖对象 */
    /**
     * 用户DAO
     */
    @Mock
    private UserDAO userDAO;
    /**
     * 标识生成器
     */
    @Mock
    private IdGenerator idGenerator;

    /** 定义被测对象 */
    /**
     * 用户服务
     */
    @InjectMocks
    private UserService userService;

    /**
     * 在测试之前
     */
    @Before
    public void beforeTest() {
        // 注入依赖对象
        Whitebox.setInternalState(userService, "canModify", Boolean.TRUE);
    }

    /**
     * 测试: 创建用户-新
     */
    @Test
    public void testCreateUserWithNew() throws IOException {
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(UserServiceTest.class);
        // 模拟依赖方法
        Mockito.doReturn(null).when(userDAO).getIdByName(Mockito.anyString());
        // 模拟依赖方法: idGenerator.next
        Long userId = 2L;
        Mockito.doReturn(userId).when(idGenerator).getUUID();

        // 调用被测方法
        String text = IOUtils.getResourceAsString("test/userCreateVO.json", UserServiceTest.class);
        UserVO userCreate = JSON.parseObject(text, UserVO.class);
        Assert.assertEquals("用户标识不一致", userId, userService.createUser(userCreate));

        // 验证依赖方法
        // 验证依赖方法: userDAO.getByName
        Mockito.verify(userDAO).getIdByName(userCreate.getName());
        // 验证依赖方法: idGenerator.getUUID
        Mockito.verify(idGenerator).getUUID();
        // 验证依赖方法: userDAO.create
        ArgumentCaptor<UserDO> userCreateCaptor = ArgumentCaptor.forClass(UserDO.class);
        Mockito.verify(userDAO).create(userCreateCaptor.capture());
        text = IOUtils.getResourceAsString("test/userModifyDO.json", UserServiceTest.class);
        Assert.assertEquals("用户创建不一致", text, JSON.toJSONString(userCreateCaptor.getValue()));

        // 验证依赖对象
        Mockito.verifyNoMoreInteractions(idGenerator, userDAO);
    }

    /**
     * 测试: 创建用户-旧
     */
//    @Test
//    public void testCreateUserWithOld() throws IOException {
//        // 模拟依赖方法
//        // 模拟依赖方法: userDAO.getByName
//        Long userId = 1L;
//        Mockito.doReturn(userId).when(userDAO).getIdByName(Mockito.anyString());
//
//        // 调用被测方法
//        String text = IOUtils.getResourceAsString("userCreateVO.json", UserServiceTest.class);
//        UserVO userCreate = JSON.parseObject(text, UserVO.class);
//        Assert.assertEquals("用户标识不一致", userId, userService.createUser(userCreate));
//
//        // 验证依赖方法
//        // 验证依赖方法: userDAO.getByName
//        Mockito.verify(userDAO).getIdByName(userCreate.getName());
//        // 验证依赖方法: userDAO.modify
//        ArgumentCaptor<UserDO> userModifyCaptor = ArgumentCaptor.forClass(UserDO.class);
//        Mockito.verify(userDAO).modify(userModifyCaptor.capture());
//        text = IOUtils.getResourceAsString("userModifyDO.json", UserServiceTest.class);
//        Assert.assertEquals("用户修改不一致", text, JSON.toJSONString(userModifyCaptor.getValue()));
//
//        // 验证依赖对象
//        Mockito.verifyNoInteractions(idGenerator);
//        Mockito.verifyNoMoreInteractions(userDAO);
//    }

    /**
     * 测试: 创建用户-异常
     */
//    @Test
//    public void testCreateUserWithException() throws IOException {
//        // 注入依赖对象
//        Whitebox.setInternalState(userService, "canModify", Boolean.FALSE);
//
//        // 模拟依赖方法
//        // 模拟依赖方法: userDAO.getByName
//        Long userId = 1L;
//        Mockito.doReturn(userId).when(userDAO).getIdByName(Mockito.anyString());
//
//        // 调用被测方法
//        String text = IOUtils.getResourceAsString("userCreateVO.json", UserServiceTest.class);
//        UserVO userCreate = JSON.parseObject(text, UserVO.class);
//        UnsupportedOperationException exception = Assert.assertThrows("返回异常不一致",
//                UnsupportedOperationException.class, () -> userService.createUser(userCreate));
//        Assert.assertEquals("异常消息不一致", "不支持修改", exception.getMessage());
//    }
}