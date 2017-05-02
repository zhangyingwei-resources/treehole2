package com.zhangyingwei.treehole.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/4/25.
 */
public class DbUtilsTest {
    @Test
    public void sqliteValid() throws Exception {
        String url = "jdbc:sqlite:treehole.db";
        Boolean valid = DbUtils.sqliteValid(url);
        System.out.println(valid);
    }

    @Test
    public void mysqlValid() throws Exception {
        String url = "jdbc:mysql://zhangyingwei.com:3306";
        String username = "root";
        String password = "723903129Bao";
        boolean valid = DbUtils.mysqlValid(url, username, password);
        System.out.println(valid);
    }

}