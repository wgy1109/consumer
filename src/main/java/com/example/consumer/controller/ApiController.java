package com.example.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class ApiController {

//    Logger log = Logger.getLogger(ApiController.class.getName());

    @RequestMapping(value = "/getTime")
    public JSONObject getTime() {
        Long time = System.currentTimeMillis();
        log.info("time is " + time);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "SUCCESS");
        jsonObject.put("data", time);
        return jsonObject;
    }

}
