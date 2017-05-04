package com.zhangyingwei.treehole.install.service;

import com.zhangyingwei.treehole.common.exception.TreeHoleException;
import com.zhangyingwei.treehole.install.model.AdminConf;
import com.zhangyingwei.treehole.install.model.BlogConf;

/**
 * @author: zhangyw
 * @date: 2017/5/4
 * @time: 下午9:46
 * @desc:
 */
public interface IAdminInitService {
    void adminInti(AdminConf adminConf) throws TreeHoleException;
    void blogInfoInit(BlogConf blogConf) throws TreeHoleException;
}
