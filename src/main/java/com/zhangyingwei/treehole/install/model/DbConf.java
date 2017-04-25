package com.zhangyingwei.treehole.install.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by zhangyw on 2017/4/24.
 * model of database info
 * url
 * username
 * password
 */

public class DbConf {
    @NotEmpty(message = "url不能为空")
    private String url;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
