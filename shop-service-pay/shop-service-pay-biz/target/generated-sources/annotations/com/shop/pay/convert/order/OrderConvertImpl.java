package com.shop.pay.convert.order;

import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.order.vo.PayOrderPageRespVO;
import com.shop.pay.dal.dataobject.PayOrderDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-04T01:36:38+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class OrderConvertImpl implements OrderConvert {

    @Override
    public PageResult<PayOrderPageRespVO> convertPage(PageResult<PayOrderDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayOrderPageRespVO> pageResult = new PageResult<PayOrderPageRespVO>();

        pageResult.setList( payOrderDOListToPayOrderPageRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected PayOrderPageRespVO payOrderDOToPayOrderPageRespVO(PayOrderDO payOrderDO) {
        if ( payOrderDO == null ) {
            return null;
        }

        PayOrderPageRespVO payOrderPageRespVO = new PayOrderPageRespVO();

        payOrderPageRespVO.setId( payOrderDO.getId() );
        payOrderPageRespVO.setSubject( payOrderDO.getSubject() );
        payOrderPageRespVO.setPayAppid( payOrderDO.getPayAppid() );
        payOrderPageRespVO.setOrderNo( payOrderDO.getOrderNo() );
        payOrderPageRespVO.setTotalAmount( payOrderDO.getTotalAmount() );
        payOrderPageRespVO.setDescription( payOrderDO.getDescription() );
        payOrderPageRespVO.setStatus( payOrderDO.getStatus() );
        payOrderPageRespVO.setCreateTime( payOrderDO.getCreateTime() );
        payOrderPageRespVO.setUpdateTime( payOrderDO.getUpdateTime() );

        return payOrderPageRespVO;
    }

    protected List<PayOrderPageRespVO> payOrderDOListToPayOrderPageRespVOList(List<PayOrderDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayOrderPageRespVO> list1 = new ArrayList<PayOrderPageRespVO>( list.size() );
        for ( PayOrderDO payOrderDO : list ) {
            list1.add( payOrderDOToPayOrderPageRespVO( payOrderDO ) );
        }

        return list1;
    }
}
