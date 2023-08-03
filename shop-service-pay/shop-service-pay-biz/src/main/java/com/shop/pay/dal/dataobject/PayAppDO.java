package com.shop.pay.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 *
 * @TableName pay_app
 */
@TableName(value ="pay_app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppDO extends BaseDO {
    /**
     * 业务模块id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 业务昵称
     */
    private String name;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * 退款通知
     */
    private String notifyRefundUrl;

    /**
     * 是否开启
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
