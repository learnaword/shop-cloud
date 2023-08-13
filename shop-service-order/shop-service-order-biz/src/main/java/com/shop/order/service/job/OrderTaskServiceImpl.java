package com.shop.order.service.job;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dal.redis.RedisKeyConstants;
import com.shop.order.enums.OrderStatusEnum;
import com.shop.order.service.order.OrderService;
import com.shop.order.service.product.ProductService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class OrderTaskServiceImpl implements OrderTaskService{

    @Resource
    private final RedisTemplate redisTemplate;

    @Resource
    OrderService orderService;

    @Resource
    ProductService productService;

    @Override
    public void autoCancelOrder() {
        String key = RedisKeyConstants.ORDER_AUTO_CANCEL.formatKey();
        //从redis里获取到自动取消的订单信息
        Long size = redisTemplate.opsForList().size(key);
        if(size < 0){
            return;
        }
        for (int i = 0; i < size; i++) {
            Integer orderId = (Integer) redisTemplate.opsForList().rightPop(RedisKeyConstants.ORDER_AUTO_CANCEL.formatKey());
            //通过id获取到订单信息
            OrderDO orderDO = orderService.getOrderById(orderId);
            //订单是否支付
            if(orderDO.getStatus().equals(OrderStatusEnum.SUCCESS.getStatus())){
                continue;
            }
            //获取获取过期时间
            LocalDateTime cancelTime;
            cancelTime = orderDO.getCreateTime().plus(10, ChronoUnit.MINUTES);
            LocalDateTime now = LocalDateTime.now();
            if(now.isAfter(cancelTime)){
                //修改订单的状态
                orderDO.setStatus(OrderStatusEnum.CANCEL.getStatus());
                orderService.update(orderDO);
            }else{
                //没有过期，将key重新插入到队列中
                redisTemplate.opsForList().leftPush(key,orderId);
            }
            //回滚库存
            productService.rollbackStock(orderId,orderDO.getPayNum());
        }

    }
}
