package com.zhangyingwei.treehole.install.controller;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangyingwei.treehole.common.Ajax;
import com.zhangyingwei.treehole.common.exception.TreeHoleException;
import com.zhangyingwei.treehole.common.utils.DbUtils;
import com.zhangyingwei.treehole.common.utils.TreeHoleUtils;
import com.zhangyingwei.treehole.install.model.AdminConf;
import com.zhangyingwei.treehole.install.model.BlogConf;
import com.zhangyingwei.treehole.install.model.DbConf;
import com.zhangyingwei.treehole.install.service.AdminInitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AdminInitService adminInitService;
    @RequestMapping
    public String page(Map<String,Object> model){
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
        logger.info("database.type:"+dbName);
        if ("mysql".equals(dbName)) {
            Boolean valid = DbUtils.mysqlValid(dbConf.getUrl(), dbConf.getUsername(), dbConf.getPassword());
            if(valid){
                return Ajax.success("验证成功");
            }else{
                return Ajax.success("验证失败");
            }
        }else if("sqlite".equals(dbName)){
            Boolean valid = DbUtils.sqliteValid(dbConf.getUrl());
            if(valid){
                return Ajax.success("验证成功");
            }else{
                return Ajax.success("验证失败");
            }
        }else{
            return Ajax.success("暂不支持此数据库");
        }
    }

    @PostMapping("/db/make")
    @ResponseBody
    public Map makeDatabase(@Valid DbConf dbConf) throws TreeHoleException {
        //创建数据库
        TreeHoleUtils.makeDatabase(dbConf);
        //创建数据库表
        TreeHoleUtils.makeTables(dbConf);
        return Ajax.success("数据库初始化成功");
    }

    @PostMapping("/blog/init")
    @ResponseBody
    public Map initBlog(@Valid BlogConf blogConf){
        return Ajax.success("success");
    }

    @PostMapping("/admin/init")
    @ResponseBody
    public Map initAdmin(@Valid AdminConf adminConf) throws TreeHoleException {
        try {
            this.adminInitService.adminInti(adminConf);
        } catch (TreeHoleException e) {
            e.printStackTrace();
            throw new TreeHoleException(e.getMessage());
        }
        return Ajax.success("初始化管理端成功");
    }
}
