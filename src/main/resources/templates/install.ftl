<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/dist/zui/css/zui.min.css">
    <link rel="stylesheet" type="text/css" href="/css/steps.css" >
    <script src="http://util.zhangyingwei.com/js/jquery.min.js" ></script>
    <script src="/dist/zui/js/zui.min.js"></script>
    <script src="/dist/is/is.min.js" ></script>
    <script src="/dist/layer/layer.js" ></script>
    <script src="/dist/des/js/des.js" ></script>
    <script src="/js/install.js" ></script>
    <title>steps</title>
</head>
<body>
<div class="center-block text-center"><h3>TreeHole[树洞博客] 安装引导</h3></div>
<div class="container-fixed-xs center-block">
    <div class="panel">
        <header id="step-tip" class="panel-heading"></header>
        <div class="steps panel-body" >
            <div class="step">
                <span class="hidden info">database</span>
                <span class="hidden msg">MySql数据库信息配置</span>
                <div>
                    <div class="input-group">
                        <span class="input-group-addon">数据库地址</span>
                        <input type="text" name="dburl" class="form-control not-empty" placeholder="数据库地址">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">用户名</span>
                        <input type="text" name="dbusername" class="form-control not-empty" placeholder="用户名">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">密码</span>
                        <input type="text" name="dbpassword" class="form-control not-empty" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="step">
                <span class="hidden msg">博客信息配置</span>
                <div>
                    <div class="input-group">
                        <span class="input-group-addon">博客名称</span>
                        <input type="text" name="blogname" class="form-control not-empty" placeholder="博客名称">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">绑定网址</span>
                        <input type="text" name="blogurl" class="form-control" placeholder="网址">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">博客简介</span>
                        <textarea name="blogdesc" class="form-control" rows="3" placeholder="简介"></textarea>
                    </div>
                </div>
            </div>
            <div class="step">
                <span class="hidden msg">管理端登录信息配置</span>
                <div>
                    <div class="input-group">
                        <span class="input-group-addon">用户名</span>
                        <input type="text" name="adminusername" class="form-control not-empty" placeholder="用户名">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">密码</span>
                        <input type="password" name="adminpassword" id="passwd" class="form-control not-empty" placeholder="密码">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">确认密码</span>
                        <input type="password" id="qrpasswd" class="form-control not-empty" placeholder="确认密码">
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-footer" id="buttons">
            <button id="prew" class="btn btn-info" type="button" >上一步</button>
            <button id="next" class="btn btn-info" type="button" >下一步</button>
            <button id="submit" class="btn btn-success hidden" type="button">完成</button>
        </div>
    </div>
</div>
</body>
</html>