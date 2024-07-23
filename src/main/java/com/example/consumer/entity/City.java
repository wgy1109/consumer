package com.example.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wgy
 * @since 2024-07-18
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class City implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField(value = "CountryCode")
    private String countryCode;

    private String district;

    private Integer population;

}
