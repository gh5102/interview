package com.gh.question.service.impl;

import com.gh.question.entity.User;
import com.gh.question.mapper.UserMapper;
import com.gh.question.service.UserService;
import com.gh.question.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<Object,  Object> redisTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String id, String pwd) {
        User user = new User();
        user.setId(id);
        user.setUserName(id);
        user.setPassword(MD5Util.MD5(pwd));
        user.setSalt("weq");
        user.setLastLoginTime(new Date());
        user.setLoginTimes(0);
        userMapper.register(user);
        return false;
    }

    @Override
    public boolean login(String id, String pwd) {
        User user = null;
        if(!redisTemplate.hasKey(id)){
           user = (User) redisTemplate.opsForValue().get(id);
        }else{
            user = userMapper.getUser(id);
            redisTemplate.opsForValue().set(id,user, Duration.ofSeconds(300));
        }
        if(user.getPassword().equals(MD5Util.MD5(pwd))){
            //loginAddTimes(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginAddTimes(String id) {
        userMapper.updateTimes(id);
        return false;
    }


}
