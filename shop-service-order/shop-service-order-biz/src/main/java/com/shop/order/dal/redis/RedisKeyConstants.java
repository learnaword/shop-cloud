package com.shop.order.dal.redis;

import cn.iocoder.yudao.framework.redis.core.RedisKeyDefine;

public interface RedisKeyConstants {
    RedisKeyDefine ORDER_AUTO_CANCEL = new RedisKeyDefine("订单自动取消队列",
            "order_auto_cancel", // 参数来自 DefaultLockKeyBuilder 类
            RedisKeyDefine.KeyTypeEnum.LIST, Integer.class , RedisKeyDefine.TimeoutTypeEnum.DYNAMIC);
}
