package com.example.consumer.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@Data
public class OutboundApplyNoteDTO  {

    /**
     * 主键id
     */
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

}
