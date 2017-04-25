package com.zhangyingwei.treehole.install.controller;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangyingwei.treehole.common.Ajax;
import com.zhangyingwei.treehole.common.utils.DbUtils;
import com.zhangyingwei.treehole.common.utils.TreeHoleUtils;
import com.zhangyingwei.treehole.install.model.DbConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        try {
            logger.info("mark as install");
            TreeHoleUtils.markAsInstall();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "install";
    }

    @PostMapping("/db/{dbname}")
    @ResponseBody
    public Map checkDbInfo(@PathVariable("dbname") String dbName, @Valid DbConf dbConf) {
        if ("mysql".equals(dbName)) {
            Boolean valid = DbUtils.mysqlValid(dbConf.getUrl(), dbConf.getUsername(), dbConf.getPassword());
            if(valid){
                return Ajax.success("验证成功");
            }else{
                return Ajax.success("验证失败");
            }
        }else{
            return Ajax.success("不是MySQL数据库");
        }
    }
}
