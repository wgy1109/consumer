package com.example.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.consumer.entity.CangKu;
import com.example.consumer.mapper.CangKuMapper;
import com.example.consumer.service.ICangKuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wgy
 * @since 2024-07-24
 */
@Service
public class CangKuServiceImpl extends ServiceImpl<CangKuMapper, CangKu> implements ICangKuService {

    @Autowired
    private CangKuMapper cangKuMapper;

    @Override
    public JSONObject getList() {
        List<CangKu> data =  cangKuMapper.selectList(null);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "SUCCESS");
        jsonObject.put("data", data);
        return jsonObject;
    }

    @Override
    public JSONObject getListByPage() {
        IPage page = new Page();
        page.setSize(5);
        page.setCurrent(2);
        List<CangKu> data = cangKuMapper.selectList(page, null);
        page.setRecords(data);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "SUCCESS");
        jsonObject.put("data", page);
        return jsonObject;
    }
}
