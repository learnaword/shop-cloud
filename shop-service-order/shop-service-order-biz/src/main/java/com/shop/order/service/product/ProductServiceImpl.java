package com.shop.order.service.product;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.dal.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shop.common.exception.util.ServiceExceptionUtil.*;

import static com.shop.common.exception.util.ServiceExceptionUtil.exception;
import static com.shop.enums.ErrorCodeConstants.PRODUCT_ID_NOT_NULL;


@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductDO> implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public ProductDO getById(Integer productId){
        return productMapper.selectById(productId);
    }

    //减少库存
    @Override
    public Boolean subStock(Integer productId, Integer num) {

        UpdateWrapper<ProductDO> updateWrapper = new UpdateWrapper<>();
        //从数据库获取到商品信息
        ProductDO productDO = productMapper.selectById(productId);
        updateWrapper.setSql(StrUtil.format("stock = stock - {}", num));
        updateWrapper.setSql(StrUtil.format("sales = sales + {}", num));
        // 扣减时加乐观锁保证库存不为负
        updateWrapper.last(StrUtil.format(" and (stock - {} >= 0)", num));

        updateWrapper.eq("id", productId);
        boolean update = update(updateWrapper);
        if (!update) {
            throw exception(PRODUCT_ID_NOT_NULL);
        }
        return update;
    }

    //恢复库存
    @Override
    public Boolean rollbackStock(Integer productId, int num) {
        UpdateWrapper<ProductDO> updateWrapper = new UpdateWrapper<>();
        //从数据库获取到商品信息
        ProductDO productDO = productMapper.selectById(productId);
        updateWrapper.setSql(StrUtil.format("stock = stock + {}", num));
        updateWrapper.setSql(StrUtil.format("sales = sales - {}", num));
        // 扣减时加乐观锁保证库存不为负
        updateWrapper.eq("id", productId);
        boolean update = update(updateWrapper);

        if (!update) {
            throw exception(PRODUCT_ID_NOT_NULL);
        }
        return update;
    }

    @Override
    public boolean save(ProductDO entity) {
        return super.save(entity);
    }
}
