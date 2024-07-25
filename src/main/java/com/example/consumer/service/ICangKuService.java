package com.example.consumer.service;

import com.alibaba.fastjson.JSONObject;
import com.example.consumer.entity.CangKu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wgy
 * @since 2024-07-24
 */
public interface ICangKuService extends IService<CangKu> {

    JSONObject getList();

    JSONObject getListByPage();

}
