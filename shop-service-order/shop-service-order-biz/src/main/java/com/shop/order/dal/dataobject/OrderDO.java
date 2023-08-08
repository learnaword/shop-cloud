package com.shop.order.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@TableName(value ="shop_order")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@Data
public class OrderDO {

    //订单id
    @TableId(type = IdType.AUTO)
    private int id;

    //商品标题
    private String subject;

    //订单号
    private String orderNo;

    //支付总金额
    private BigDecimal totalAmount;

    //商品id
    private int productId;

    //商品状态
    private Integer status;

    //订单创建时间
    private LocalDateTime createTime;

    //订单更新时间
    private LocalDateTime updateTime;

    //是否删除
    private Integer isDel;

    //支付方式
    private String payType;

    //备注
    private String remark;

    //支付时间
    private LocalDateTime payTime;

    //购买商品数量
    private Integer payNum;


}
