package com.example.consumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 货位表
 * </p>
 *
 * @author wgy
 * @since 2024-07-30
 */
@TableName("wms_outbound_apply_note")
public class OutboundApplyNote implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 库id
     */
    private Integer storageId;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 库存占用策略(0: 不占用，1：按单占用，2：按项次(sku)占用)
     */
    private Byte inventoryOccupyType;

    /**
     * 原始单据id
     */
    private Long originalNoteId;

    /**
     * 原始单据json
     */
    private String originalNoteJson;

    /**
     * 单据类型（出库类型）
     */
    private Byte noteType;

    /**
     * 状态（-1:删除， 0：禁用，1：正常）
     */
    private Byte status;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createOn;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Byte getInventoryOccupyType() {
        return inventoryOccupyType;
    }

    public void setInventoryOccupyType(Byte inventoryOccupyType) {
        this.inventoryOccupyType = inventoryOccupyType;
    }

    public Long getOriginalNoteId() {
        return originalNoteId;
    }

    public void setOriginalNoteId(Long originalNoteId) {
        this.originalNoteId = originalNoteId;
    }

    public String getOriginalNoteJson() {
        return originalNoteJson;
    }

    public void setOriginalNoteJson(String originalNoteJson) {
        this.originalNoteJson = originalNoteJson;
    }

    public Byte getNoteType() {
        return noteType;
    }

    public void setNoteType(Byte noteType) {
        this.noteType = noteType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(LocalDateTime updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "OutboundApplyNote{" +
            "id = " + id +
            ", storageId = " + storageId +
            ", customerId = " + customerId +
            ", orderTime = " + orderTime +
            ", inventoryOccupyType = " + inventoryOccupyType +
            ", originalNoteId = " + originalNoteId +
            ", originalNoteJson = " + originalNoteJson +
            ", noteType = " + noteType +
            ", status = " + status +
            ", createBy = " + createBy +
            ", createOn = " + createOn +
            ", updateBy = " + updateBy +
            ", updateOn = " + updateOn +
        "}";
    }
}
