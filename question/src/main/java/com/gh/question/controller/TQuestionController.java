package com.gh.question.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gh.question.entity.ResponseResult;
import com.gh.question.entity.TAnser;
import com.gh.question.entity.TQuestion;
import com.gh.question.entity.TUser;
import com.gh.question.enums.ResultCode;
import com.gh.question.service.ITAnserService;
import com.gh.question.service.ITQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gh
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/t-question")
public class TQuestionController {
    @Autowired
    private ITQuestionService itQuestionService;
    @Autowired
    private ITAnserService itAnserService;

    @GetMapping("/getQuestion")
    public TQuestion getQuestion(){
        return itQuestionService.getById(1);
    }

    @GetMapping("/getQuestionList")
    public ResponseResult<List> getQuestionList(){
        IPage<TQuestion> page = new Page(2,3);
        List<TQuestion> list =itQuestionService.list();
        ResponseResult<List> responseResult = new ResponseResult<>();
        if(list.size()>0){
            responseResult.setMsg("查询成功");
            responseResult.setCode(ResultCode.SUCCESS);
            responseResult.setData(list);
        }else{
            responseResult.setMsg("查询失败");
            responseResult.setCode(ResultCode.FAIL);
            responseResult.setData(list);
        }
        return responseResult;
    }


    @PostMapping("/writeTQuestion")
    public ResponseResult<TQuestion> writeTQuestion(String question,String answer,int type){
        TQuestion tQuestion = new TQuestion();
        tQuestion.setQuestion(question);
        tQuestion.setTypeId(type);
        tQuestion.setUserid(0);
        tQuestion.setTimes(0);

        boolean b = itQuestionService.save(tQuestion);
        ResponseResult<TQuestion> responseResult = new ResponseResult<>();
        if(b){
            QueryWrapper<TQuestion> wrapper=new QueryWrapper<>();
            wrapper.eq("question",question);
            TQuestion question1 = itQuestionService.getOne(wrapper);
            TAnser anser = new TAnser();
            anser.setAnser(answer);
            anser.setQuesId(question1.getId());
            itAnserService.save(anser);
            responseResult.setMsg("录入成功");
            responseResult.setCode(ResultCode.SUCCESS);
            responseResult.setData(tQuestion);
        }else{
            responseResult.setMsg("录入失败");
            responseResult.setCode(ResultCode.FAIL);
            responseResult.setData(tQuestion);
        }
        return responseResult;
    }
}
