package com.zhangyingwei.treehole.install.dao;

import com.zhangyingwei.treehole.install.model.AdminConf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangyw on 2017/4/26.
 */

@Mapper
public interface AdminInitDao {
    @Insert("insert into treehole.admin (username,password) values (amdin.username,admin.password)")
    public void insertOne(@Param("admin")AdminConf adminConf);
}
