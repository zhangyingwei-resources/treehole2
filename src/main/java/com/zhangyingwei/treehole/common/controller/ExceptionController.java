package com.zhangyingwei.treehole.common.controller;

import com.zhangyingwei.treehole.common.Ajax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by zhangyw on 2017/4/24.
 */

@Controller
@ControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Object bindExceptionHandler(BindingResult result){
        logger.info("hello exception");
        return Ajax.error(result.getFieldError().getDefaultMessage());
    }
}
