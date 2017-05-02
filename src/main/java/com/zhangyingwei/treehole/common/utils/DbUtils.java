package com.zhangyingwei.treehole.common.utils;

import com.zhangyingwei.treehole.common.TreeHoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhangyw on 2017/4/25.
 * database utils
 */
public class DbUtils {
    private static Logger logger = LoggerFactory.getLogger(DbUtils.class);

    /**
     * check whether the database is available mysql
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static boolean mysqlValid(String url, String username, String password) {
        Connection connection = null;
        try {
            Class.forName(TreeHoleEnum.DB_MYSQL_CLASS.getValue());
            connection = DriverManager.getConnection(url, username, password);
            return connection != null && connection.isValid(1000);
        } catch (ClassNotFoundException e) {
            logger.error(e.getLocalizedMessage());
            return false;
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
            return false;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * check whether the database is avaliable sqlite
     * @param url
     * @return
     */
    public static Boolean sqliteValid(String url) {
        Connection connection = null;
        try {
            Class.forName(TreeHoleEnum.DB_SQLITE_CLASS.getValue());
            connection = DriverManager.getConnection(url);
            return connection != null && connection.isValid(1000);
        } catch (ClassNotFoundException e) {
            logger.error(e.getLocalizedMessage());
            return false;
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
            return false;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
