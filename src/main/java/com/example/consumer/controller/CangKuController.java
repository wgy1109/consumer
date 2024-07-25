package com.example.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.consumer.service.ICangKuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wgy
 * @since 2024-07-24
 */
@Slf4j
@RestController
@RequestMapping("/consumer/cangKu")
public class CangKuController {

    @Autowired
    private ICangKuService cangKuService;

    @RequestMapping(value = "/getList")
    public JSONObject getList() {
        log.info("get cang ku list");
        
        return cangKuService.getList();

    }

    @RequestMapping(value = "/getListByPage")
    public JSONObject getListByPage() {
        log.info("page get cang ku list");

        return cangKuService.getListByPage();

    }

}
