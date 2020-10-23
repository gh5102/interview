package com.gh.question.service.impl;

import com.gh.question.entity.TQuestion;
import com.gh.question.mapper.TQuestionMapper;
import com.gh.question.service.ITQuestionService;
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
public class TQuestionServiceImpl extends ServiceImpl<TQuestionMapper, TQuestion> implements ITQuestionService {

}
