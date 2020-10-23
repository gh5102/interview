package com.gh.question.service.impl;

import com.gh.question.entity.TUser;
import com.gh.question.mapper.TUserMapper;
import com.gh.question.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gh
 * @since 2020-10-22
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
