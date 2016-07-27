<#import "layout/app.ftl" as app>
<@app.app>
<ul class="list-group">
    <#list posts.content as post>
        <li class="list-group-item">
            <h2><a href="post/${post.id}">${post.title}</a></h2>
            <h4>${post.content}</h4>
        </li>
    </#list>
</ul>
<nav>
    <nav>
        <ul class="pager">
            <li class="previous ${hasPrev?then("","disabled")}"><a href="?page=${prev}"><span
                    aria-hidden="true">&larr;</span> Newer</a>
            </li>
            <li class="next"><a href="?page=${next}">Older <span aria-hidden="true">&rarr;</span></a>
            </li>
        </ul>
    </nav>
</nav>
</@app.app>