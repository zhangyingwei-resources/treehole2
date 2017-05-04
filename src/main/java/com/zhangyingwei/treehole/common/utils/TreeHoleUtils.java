package com.zhangyingwei.treehole.common.utils;

import com.zhangyingwei.treehole.common.TreeHoleEnum;
import com.zhangyingwei.treehole.common.exception.TreeHoleException;
import com.zhangyingwei.treehole.install.model.DbConf;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2017/4/21.
 */
public class TreeHoleUtils {

    /**
     * 判断是否已经安装
     * @return
     */
    public static boolean isInstalled(){
        return FileUtils.exists(TreeHoleEnum.INSTALL_LOCK.getValue());
    }
    public static void markAsInstall() throws IOException {
        FileUtils.newFile(TreeHoleEnum.INSTALL_LOCK.getValue());
    }

    /**
     * 创建数据库
     * @param dbConf
     */
    public static void makeDatabase(DbConf dbConf) throws TreeHoleException {
        try {
            List<String> sqls = readSql(TreeHoleEnum.SQL_CREATE_DB.getValue());
            if (sqls != null && sqls.size() > 0) {
                Connection connection = DbUtils.getConnection(dbConf);
                DbUtils.execute(connection, sqls.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new TreeHoleException("创建数据库错误", e);
        }
    }

    /**
     * 创建数据库
     * @param dbConf
     */
    public static void makeTables(DbConf dbConf) throws TreeHoleException {
        List<String> sqls = null;
        try {
            sqls = readSql(TreeHoleEnum.SQL_CREATE_TABLE.getValue());
            if(sqls!=null && sqls.size()>0){
                Connection connection = DbUtils.getConnection(dbConf);
                for (String sql : sqls) {
                    DbUtils.execute(connection,sql);
                }
            }
        } catch (TreeHoleException e) {
            e.printStackTrace();
            throw new TreeHoleException("初始化数据表错误", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TreeHoleException(e);
        }
    }

    /**
     * 根据注释读取sql语句
     * @param common
     * @return
     */
    private static List<String> readSql(String common) throws TreeHoleException {
        List<String> sqlList = new ArrayList<String>();
        File sqlFile = new File("src/main/resources/" + TreeHoleEnum.CONF_INSTALL_SQL.getValue());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(sqlFile));
            String line = reader.readLine();
            while(line!=null){
                if(line.replaceAll("#","").trim().equals(common)){
                    while ((line = reader.readLine()) != null && (!line.trim().startsWith("#"))) {
                        if(StringUtils.isNotEmpty(line)){
                            sqlList.add(line);
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new TreeHoleException("未找到数据库脚本文件", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new TreeHoleException("打开数据库脚本文件错误", e);
        }
        return sqlList;
    }

    public static void main(String[] args) throws TreeHoleException {
        List sql = TreeHoleUtils.readSql(TreeHoleEnum.SQL_CREATE_TABLE.getValue());
        System.out.println(sql);
    }

}
