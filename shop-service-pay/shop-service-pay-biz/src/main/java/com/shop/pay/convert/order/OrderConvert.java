package com.shop.pay.convert.order;

import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.order.vo.PayOrderPageRespVO;
import com.shop.pay.dal.dataobject.PayOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 支付应用信息 Convert
 *
 */
@Mapper
public interface OrderConvert {

    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    PageResult<PayOrderPageRespVO> convertPage(PageResult<PayOrderDO> page);


}
