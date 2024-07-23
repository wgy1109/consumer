package com.example.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.consumer.entity.Employee;
import com.example.consumer.mapper.EmployeeMapper;
import com.example.consumer.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
