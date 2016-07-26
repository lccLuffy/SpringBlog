<#import "layout/app.ftl" as app>
<@app.app>
<div class="row">
    <div class="col-lg-6">
        <form class="form-horizontal" action="/register" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" name="username" class="form-control" id="username" placeholder="用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="password">
                </div>
            </div>
            <div class="form-group">
                <label for="password_confirm" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-10">
                    <input type="password" name="password_confirm" class="form-control" id="password_confirm">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@app.app>