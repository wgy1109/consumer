package com.example.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RestController;
import com.example.consumer.entity.City;
import com.example.consumer.service.ICityService;
//import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wgy
 * @since 2024-07-18
 */
//@Log4j
@RestController
@RequestMapping(value = "/city")
public class CityController {

    Logger log = Logger.getLogger(CityController.class.getName());

    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "/getList")
    public JSONObject getList() {
        QueryWrapper<City> queryWrapper=new QueryWrapper<>();
        queryWrapper.lt("id", 10);
        List<City> data = cityService.list(queryWrapper);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "SUCCESS");
        jsonObject.put("data", data);
        return jsonObject;
    }

}
