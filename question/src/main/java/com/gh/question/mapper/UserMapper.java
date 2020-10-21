package com.gh.question.mapper;

import com.gh.question.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 数据映射存储
 * @author guohao
 */
@Repository
public interface UserMapper {
   int register(User user);
   User getUser(String id);
   int updateTimes(String id);
}
