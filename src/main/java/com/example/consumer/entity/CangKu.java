package com.example.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wgy
 * @since 2024-07-24
 */
@TableName("cang_ku")
public class CangKu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓名称
     */
    private String cangName;

    /**
     * 仓排序
     */
    private String cangOrder;

    /**
     * 库名称 
     */
    private String kuName;

    /**
     * 库编号
     */
    private String kuNumber;

    /**
     * 创建时间
     */
    private LocalDateTime beginTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean del;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCangName() {
        return cangName;
    }

    public void setCangName(String cangName) {
        this.cangName = cangName;
    }

    public String getCangOrder() {
        return cangOrder;
    }

    public void setCangOrder(String cangOrder) {
        this.cangOrder = cangOrder;
    }

    public String getKuName() {
        return kuName;
    }

    public void setKuName(String kuName) {
        this.kuName = kuName;
    }

    public String getKuNumber() {
        return kuNumber;
    }

    public void setKuNumber(String kuNumber) {
        this.kuNumber = kuNumber;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CangKu{" +
            "id = " + id +
            ", cangName = " + cangName +
            ", cangOrder = " + cangOrder +
            ", kuName = " + kuName +
            ", kuNumber = " + kuNumber +
            ", beginTime = " + beginTime +
            ", updateTime = " + updateTime +
            ", del = " + del +
            ", remark = " + remark +
        "}";
    }
}
