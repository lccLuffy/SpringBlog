<#import "../layout/app.ftl" as app>
<@app.app>
<form class="form-vertical" action="/post" method="post">
    <div class="form-group">
        <label for="title" class="col-sm-2 control-label">标题</label>
        <div class="col-sm-10">
            <input type="text" name="title" class="form-control" id="title" placeholder="标题">
        </div>
    </div>
    <div class="form-group">
        <label for="content" class="col-sm-2 control-label">内容</label>
        <div class="col-sm-10">
            <textarea type="text" name="content" class="form-control" id="content" rows="15"></textarea>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">发布</button>
        </div>
    </div>
</form>
</@app.app>