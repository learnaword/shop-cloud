package com.shop.pay.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.pay.enums.OrderStatusEnum;
import lombok.*;
import lombok.experimental.Accessors;

@TableName("pay_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayOrderDO extends BaseDO{
    //商品id
    @TableId(value="id",type= IdType.AUTO)
    private Long id;

    //app_id，订单来源
    private Long payAppid;

    //商品标题
    private String subject;

    //订单编号
    private String orderNo;

    //订单金额
    private Integer totalAmount;

    //商品描述
    private String description;

    /**
     * 订单状态
     *
     * 枚举{@link OrderStatusEnum}
     */
    private Integer status;

}
