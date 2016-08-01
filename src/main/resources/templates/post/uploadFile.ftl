<#import "../layout/app.ftl" as app>
<@app.app>

<form class="form-horizontal" action="/uploadFile" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="file" class="col-sm-2 control-label">文件</label>
        <div class="col-sm-10">
            <input type="file" name="file" class="form-control" id="file">
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-default" value="上传">
        </div>
    </div>
</form>
</@app.app>