package com.shop.pay.dal.mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.common.pojo.PageResult;
import com.shop.fremework.mybatis.mapper.BaseMapperX;
import com.shop.pay.controller.app.vo.PayAppPageReqVO;
import com.shop.pay.dal.dataobject.PayAppDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayAppMapper extends BaseMapperX<PayAppDO> {
    default PageResult<PayAppDO> selectPage(PayAppPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapper<PayAppDO>()
                .orderByDesc(PayAppDO::getId));
    }
}
