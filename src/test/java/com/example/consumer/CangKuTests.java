package com.example.consumer;

//import com.example.consumer.service.ICangKuService;
//import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import cn.hutool.core.convert.ConverterRegistry;
import com.example.consumer.config.CustomConverter;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.when;
//import com.alibaba.fastjson.JSONObject;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.JSONObject;

import com.example.consumer.controller.CangKuController;
import com.example.consumer.service.ICangKuService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CangKuTests {

    @InjectMocks
    private CangKuController controller;

    @Mock
    private ICangKuService cangKuService;




    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetListByPage() {
        // 测试正常情况
        when(cangKuService.getListByPage()).thenReturn(new JSONObject());
        JSONObject result = controller.getListByPage();
        assertNotNull(result);

        // 测试服务层返回null的情况
        when(cangKuService.getListByPage()).thenReturn(null);
        result = controller.getListByPage();
        assertNull(result);
    }





}
