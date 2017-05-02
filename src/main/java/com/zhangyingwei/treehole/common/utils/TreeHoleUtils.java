package com.zhangyingwei.treehole.common.utils;

import com.zhangyingwei.treehole.common.TreeHoleEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
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
     */
    public static void makeDatabase() {
        List<String> sqls = readSql(TreeHoleEnum.SQL_CREATE_DB.getValue());
        DbUtils.execute(sqls.get(0));
    }

    /**
     * 创建数据库
     */
    public static void makeTables() {

    }

    /**
     * 根据注释读取sql语句
     * @param common
     * @return
     */
    private static List<String> readSql(String common){
        List<String> sqlList = new ArrayList<String>();
        File sqlFile = new File("src/main/resources/" + TreeHoleEnum.CONF_INSTALL_SQL.getValue());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(sqlFile));
            String line = reader.readLine();
            while(line!=null){
                if(line.replaceAll("#","").trim().equals(common)){
                    while (line != null && (!(line = reader.readLine()).trim().startsWith("#"))) {
                        if(StringUtils.isNotEmpty(line)){
                            sqlList.add(line);
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlList;
    }

    public static void main(String[] args) {
        List sql = TreeHoleUtils.readSql(TreeHoleEnum.SQL_CREATE_TABLE.getValue());
        System.out.println(sql);
    }

}
