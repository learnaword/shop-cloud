package com.shop.pay.convert.config;

import com.shop.pay.controller.config.vo.CreatePayConfigReqVO;
import com.shop.pay.controller.config.vo.UpdatePayConfigReqVO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-04T01:36:38+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class PayConfigConvertImpl implements PayConfigConvert {

    @Override
    public PayConfigDO convert(UpdatePayConfigReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayConfigDO payConfigDO = new PayConfigDO();

        payConfigDO.setId( bean.getId() );
        payConfigDO.setCode( bean.getCode() );
        payConfigDO.setStatus( bean.getStatus() );
        payConfigDO.setPayAppid( bean.getPayAppid() );
        payConfigDO.setRemark( bean.getRemark() );

        return payConfigDO;
    }

    @Override
    public PayConfigDO convert(CreatePayConfigReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayConfigDO payConfigDO = new PayConfigDO();

        payConfigDO.setCode( bean.getCode() );
        payConfigDO.setStatus( bean.getStatus() );
        payConfigDO.setPayAppid( bean.getPayAppid() );
        payConfigDO.setRemark( bean.getRemark() );

        return payConfigDO;
    }
}
