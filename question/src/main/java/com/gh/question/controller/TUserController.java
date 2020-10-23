package com.gh.question.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gh.question.entity.ResponseResult;
import com.gh.question.entity.TUser;
import com.gh.question.enums.ResultCode;
import com.gh.question.service.ITUserService;
import org.apache.catalina.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gh
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/t-user")
public class TUserController {

    @Autowired
    private ITUserService itUserService;

    @PostMapping("/register")
    public ResponseResult<TUser> register(String name, String password){
        TUser user = new TUser();
        user.setUserName(name);
        user.setId(name);
        user.setPassword(password);
        user.setSalt("aw");
        user.setLastLoginTime(LocalDateTime.now());
        user.setLoginTimes(0);
        boolean flag = itUserService.save(user);
        ResponseResult<TUser> responseResult = new ResponseResult<>();
        if(flag){
            responseResult.setMsg("注册成功");
            responseResult.setCode(ResultCode.SUCCESS);
            responseResult.setData(user);
        }else{
            responseResult.setMsg("注册失败");
            responseResult.setCode(ResultCode.FAIL);
            responseResult.setData(user);
        }
        return responseResult;
    }

    @GetMapping("/login")
    public ResponseResult<TUser> login(String name,String password){
        TUser user = new TUser();
        user.setUserName(name);
        user.setPassword(password);
        QueryWrapper<TUser> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",name).eq("password",password);
        user = itUserService.getOne(wrapper);
        ResponseResult<TUser> responseResult = new ResponseResult<>();
        if(responseResult != null){
            responseResult.setMsg("登陆成功");
            responseResult.setCode(ResultCode.SUCCESS);
            responseResult.setData(user);
        }else{
            responseResult.setMsg("登陆失败");
            responseResult.setCode(ResultCode.FAIL);
            responseResult.setData(user);
        }
        return responseResult;
    }

}
