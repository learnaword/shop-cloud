package com.shop.pay.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.common.pojo.PageResult;
import com.shop.framework.mybatis.mapper.BaseMapperX;
import com.shop.pay.controller.app.vo.PayAppPageReqVO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface PayConfigMapper extends BaseMapperX<PayConfigDO> {
    default PageResult<PayConfigDO> selectPage(PayAppPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapper<PayConfigDO>()
                .orderByDesc(PayConfigDO::getId));
    }

    default List<PayConfigDO> selectListByAppIds(Collection<Long> appIds){
        return selectList(PayConfigDO::getPayAppid, appIds);
    }
}
