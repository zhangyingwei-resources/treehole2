package com.zhangyingwei.treehole.common.utils;

import com.zhangyingwei.treehole.common.TreeHoleEnum;

import java.io.IOException;

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
}
