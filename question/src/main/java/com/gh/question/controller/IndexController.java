package com.gh.question.controller;

import com.gh.question.entity.ResponseResult;
import com.gh.question.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "用户接口")
@Controller
@RequestMapping("back")
public class IndexController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "上传页面地址跳转")
    @GetMapping("index")
    public String index(){
        return "upload.html";
    }

    /**
     * 登陆
     * @return
     */
    @GetMapping("login")
    @ResponseBody
    public ResponseResult<Boolean> login(String id, String pwd){
        ResponseResult<Boolean> responseResult = new ResponseResult();
        boolean b = userService.login(id,pwd);
        responseResult.setData(b);
        return responseResult;
    }

    /**
     * 注册
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public ResponseResult<Boolean> register(String id, String pwd){
        ResponseResult<Boolean> responseResult = new ResponseResult();
        boolean b = false;

        try{
            b = userService.register(id,pwd);
            responseResult.setData(b);
        }catch (Exception e){

        }finally {
            responseResult.setData(false);
            responseResult.setMsg("已注册");
        }
        return responseResult;
    }
}
