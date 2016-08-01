<#import "layout/app.ftl" as app>
<@app.app>
<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>标题</th>
        <th>时间</th>
        <th>动作</th>
    </tr>
    </thead>
    <tbody>
        <#list posts as post>
        <tr>
            <td>${post.title}</td>
            <td>${post.createdAt}</td>
            <td>
                <form action="post/${post.id}" method="post">
                    <input name="_method" type="hidden" value="delete"/>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <input type="submit" value="删除" class="btn">
                </form>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</@app.app>