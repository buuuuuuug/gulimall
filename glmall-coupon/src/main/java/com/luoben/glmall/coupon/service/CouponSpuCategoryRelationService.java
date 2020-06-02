package com.luoben.glmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoben.common.utils.PageUtils;
import com.luoben.glmall.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author luoben
 * @email luoben@gmail.com
 * @date 2020-05-19 16:00:55
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

