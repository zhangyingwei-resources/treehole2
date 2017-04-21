package com.zhangyingwei.treehole.install.controller;

import com.zhangyingwei.treehole.common.utils.TreeHoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zhangyw on 2017/4/21.
 */
@Controller
@RequestMapping("/install")
public class InstallController {
    private Logger logger = LoggerFactory.getLogger(InstallController.class);

    @RequestMapping
    public String install(Map<String,Object> model){
        Boolean installed = TreeHoleUtils.isInstalled();
        if(installed){
            return "redirect:index";
        }
        try {
            logger.info("mark as install");
            TreeHoleUtils.markAsInstall();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "install";
    }
}
