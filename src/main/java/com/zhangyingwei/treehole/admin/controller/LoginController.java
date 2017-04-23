package com.zhangyingwei.treehole.admin.controller;

import com.zhangyingwei.treehole.common.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: zhangyw
 * @date: 2017/4/23
 * @time: 上午10:23
 * @desc: 登录
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public String login(Map<String,Object> model, HttpSession session){
        logger.info(model.toString());
        logger.info(session+"");
        return Pages.ADMIN;
    }
}
