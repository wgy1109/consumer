package com.example.consumer.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.consumer.entity.EmployeeVal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmployeeDTO {

    private Long empId;
    private String name;
    private String empGender;
    private Integer age;
    private String email;

    private List<EmployeeVal> employeeValList;

}
