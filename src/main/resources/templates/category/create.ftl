<#import "../layout/app.ftl" as app>
<@app.app>
<form class="form-vertical" action="/category" method="post">
    <div class="form-group">
        <div class="col-sm-10">
            <input type="text" name="name" class="form-control" id="name" placeholder="名字">
        </div>
    </div>
    <div class="form-group">
        <textarea type="text" name="description" class="form-control" id="description" rows="2"></textarea>
    </div>
<#--<input type="hidden" name="${_csrf.parameterName}"
       value="${_csrf.token}"/>-->
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">发布</button>
        </div>
    </div>
</form>
</@app.app>