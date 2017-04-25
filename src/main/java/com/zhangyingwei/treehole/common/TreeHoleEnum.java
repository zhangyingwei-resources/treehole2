package com.zhangyingwei.treehole.common;

/**
 * Created by zhangyw on 2017/4/21.
 * 系统公用枚举参数
 */
public enum TreeHoleEnum {
    INSTALL_LOCK("install.lock"),//安装检测文件
    DB_MYSQL_CLASS("com.mysql.jdbc.Driver")
    ;

    private String value;

    TreeHoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
