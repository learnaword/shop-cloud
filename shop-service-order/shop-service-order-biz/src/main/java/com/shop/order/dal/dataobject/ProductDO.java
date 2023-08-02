package com.shop.order.dal.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@TableName(value ="product")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@Data
public class ProductDO {

    //商品id
    @TableId(type = IdType.AUTO)
    private int id;

    //是否删除
    private Boolean isDel;

    //是否展示
    private Boolean isShow;

    //库存
    private int stock;

    //商品名字
    private String name;

    //商品描述
    private String remark;

    //商品价格
    private BigDecimal price;
}
