package com.shop.pay.dal.mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.common.pojo.PageResult;
import com.shop.fremework.mybatis.mapper.BaseMapperX;
import com.shop.pay.controller.order.vo.PayOrderPageReqVO;
import com.shop.pay.dal.dataobject.PayOrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayOrderMapper extends BaseMapperX<PayOrderDO> {
    default PageResult<PayOrderDO> selectPage(PayOrderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapper<PayOrderDO>()
                .orderByDesc(PayOrderDO::getId));
    }
}
