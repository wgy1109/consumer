package com.example.consumer.service.impl;

import com.example.consumer.entity.City;
import com.example.consumer.mapper.CityMapper;
import com.example.consumer.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wgy
 * @since 2024-07-18
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

}
