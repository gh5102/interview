package com.gh.question.service;

/**
 * @author guohao
 */
public interface UserService {
    /**
     * 注册
     * @param id
     * @param pwd
     * @return
     */
    boolean register(String id, String pwd);

    /**
     * 登陆
     * @param id
     * @param pwd
     * @return
     */
    boolean login(String id, String pwd);

    /**
     * 登陆次数
     * @param id
     * @return
     */
    boolean loginAddTimes(String id);
}
