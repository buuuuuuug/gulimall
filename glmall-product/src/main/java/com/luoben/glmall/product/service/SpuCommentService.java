package com.luoben.glmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoben.common.utils.PageUtils;
import com.luoben.glmall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author luoben
 * @email luoben@gmail.com
 * @date 2020-05-19 14:48:18
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

