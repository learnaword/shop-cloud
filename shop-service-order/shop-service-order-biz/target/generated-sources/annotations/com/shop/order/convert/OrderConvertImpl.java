package com.shop.order.convert;

import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dto.OrderRespDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-06T19:42:02+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class OrderConvertImpl implements OrderConvert {

    @Override
    public OrderRespDTO convert(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        OrderRespDTO orderRespDTO = new OrderRespDTO();

        orderRespDTO.setId( orderDO.getId() );
        orderRespDTO.setSubject( orderDO.getSubject() );
        orderRespDTO.setOrderNo( orderDO.getOrderNo() );
        orderRespDTO.setTotalAmount( orderDO.getTotalAmount() );
        orderRespDTO.setProductId( orderDO.getProductId() );
        orderRespDTO.setStatus( orderDO.getStatus() );
        orderRespDTO.setCreateTime( orderDO.getCreateTime() );
        orderRespDTO.setUpdateTime( orderDO.getUpdateTime() );
        orderRespDTO.setIsDel( orderDO.getIsDel() );
        orderRespDTO.setPayType( orderDO.getPayType() );
        orderRespDTO.setRemark( orderDO.getRemark() );
        orderRespDTO.setPayTime( orderDO.getPayTime() );

        return orderRespDTO;
    }
}
