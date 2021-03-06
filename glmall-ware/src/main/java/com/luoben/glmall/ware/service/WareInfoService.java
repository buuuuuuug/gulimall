package com.luoben.glmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoben.common.utils.PageUtils;
import com.luoben.glmall.ware.entity.WareInfoEntity;
import com.luoben.glmall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author luoben
 * @email luoben@gmail.com
 * @date 2020-05-19 16:54:50
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据用户的收货地址计算运费
     * @param addrId
     * @return
     */
    FareVo getFare(Long addrId);
}

