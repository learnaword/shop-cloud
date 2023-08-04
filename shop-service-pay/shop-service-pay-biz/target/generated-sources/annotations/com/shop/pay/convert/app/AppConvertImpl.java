package com.shop.pay.convert.app;

import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.app.vo.PayAppPageRespVO;
import com.shop.pay.dal.dataobject.PayAppDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-04T22:38:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class AppConvertImpl implements AppConvert {

    @Override
    public PageResult<PayAppPageRespVO> convertPage(PageResult<PayAppDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayAppPageRespVO> pageResult = new PageResult<PayAppPageRespVO>();

        pageResult.setList( payAppDOListToPayAppPageRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected PayAppPageRespVO payAppDOToPayAppPageRespVO(PayAppDO payAppDO) {
        if ( payAppDO == null ) {
            return null;
        }

        PayAppPageRespVO payAppPageRespVO = new PayAppPageRespVO();

        payAppPageRespVO.setId( payAppDO.getId() );
        payAppPageRespVO.setName( payAppDO.getName() );
        payAppPageRespVO.setNotifyUrl( payAppDO.getNotifyUrl() );
        payAppPageRespVO.setNotifyRefundUrl( payAppDO.getNotifyRefundUrl() );
        payAppPageRespVO.setStatus( payAppDO.getStatus() );
        payAppPageRespVO.setRemark( payAppDO.getRemark() );

        return payAppPageRespVO;
    }

    protected List<PayAppPageRespVO> payAppDOListToPayAppPageRespVOList(List<PayAppDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayAppPageRespVO> list1 = new ArrayList<PayAppPageRespVO>( list.size() );
        for ( PayAppDO payAppDO : list ) {
            list1.add( payAppDOToPayAppPageRespVO( payAppDO ) );
        }

        return list1;
    }
}
