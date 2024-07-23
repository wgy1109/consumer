package com.example.consumer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
// 当表名跟实体类类名不一致时，要使用@TableName注解进行映射
//@TableName(value = "tb_employee")
public class Employee {

    // 使用数据库自增策略


    // @Table(type=IdType.AUTO)
    // 默认使用雪花算法生成数字
    @TableId
    private Long empId;
    // 当表中的列与实体类属性不一致时，使用TableField指定数据库中的列名
    // @TableField(value = "emp_name")
    private String name;
    private String empGender;
    private Integer age;
    private String email;

    // 当表中没有 remark时，忽略字段
    @TableField(exist = false)
    private String remark;

}
