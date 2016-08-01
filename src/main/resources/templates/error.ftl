<#import "layout/app.ftl" as app>
<@app.app>
    <#if message??>
    <h2>${message}</h2>
    </#if>
</@app.app>