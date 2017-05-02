package com.zhangyingwei.treehole.install.service;

import com.zhangyingwei.treehole.common.exception.TreeHoleException;
import com.zhangyingwei.treehole.install.dao.AdminInitDao;
import com.zhangyingwei.treehole.install.model.AdminConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyw on 2017/4/26.
 */
@Service
public class AdminInitService {
    @Autowired
    private AdminInitDao adminInitDao;
    public void adminInti(AdminConf adminConf) throws TreeHoleException {
        try {
            adminInitDao.insertOne(adminConf);
        } catch (Exception e) {
            throw new TreeHoleException("初始化管理端信息错误",e);
        }
    }
}
