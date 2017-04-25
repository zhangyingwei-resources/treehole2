package com.zhangyingwei.treehole.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/4/24.
 */
public class PropertiesUtilsTest {
    @Test
    public void update() throws Exception {
        PropertiesUtils.update("config.properties", "key", "haha");
    }

    @Test
    public void createProperties() throws Exception {
        PropertiesUtils.createProperties("config.properties","");
    }

}