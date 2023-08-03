package com.shop.pay.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.shop.pay.core.client.PayClientConfig;
import lombok.*;
import lombok.experimental.Accessors;

/**
 *
 * @TableName pay_config
 */
@TableName(value ="pay_config", autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayConfigDO extends BaseDO {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 支付类型
     */
    private String code;

    /**
     * 是否开启
     */
    private Integer status;

    /**
     * 与pay_app进行关联
     */
    private Long payAppid;

    /**
     * 描述
     */
    private String remark;

    /**
     * 配置数据
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private PayClientConfig config;
}
