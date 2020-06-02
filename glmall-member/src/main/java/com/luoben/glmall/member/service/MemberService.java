package com.luoben.glmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoben.common.utils.PageUtils;
import com.luoben.glmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author luoben
 * @email luoben@gmail.com
 * @date 2020-05-19 16:33:53
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

