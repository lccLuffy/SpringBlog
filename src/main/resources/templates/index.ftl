<#import "layout/app.ftl" as app>
<@app.app>
<h2>${io}</h2>
<ul>
    <#list posts.content as post>
        <li>
            <h2><a href="post/${post.id}">${post.title}</a></h2>
            <h4>${post.content}</h4>
        </li>
    </#list>
</ul>
</div>
</@app.app>