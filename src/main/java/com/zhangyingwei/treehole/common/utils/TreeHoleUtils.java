package com.zhangyingwei.treehole.common.utils;

import com.zhangyingwei.treehole.common.TreeHoleEnum;

import java.io.*;

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

    }

    /**
     * 根据注释读取sql语句
     * @param common
     * @return
     */
    private static String readSql(String common){
        String resultMsg = "";
        File sqlFile = new File("src/main/resuorces/" + TreeHoleEnum.CONF_INSTALL_SQL.getValue());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(sqlFile));
            String line = reader.readLine();
            while(line!=null){
                if(line.replaceAll("#","").trim().equals(common)){
                    resultMsg = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMsg;
    }

    public static void main(String[] args) {
        String sql = TreeHoleUtils.readSql("db create");
        System.out.println(sql);
    }
}
