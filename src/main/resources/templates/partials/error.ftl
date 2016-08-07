<#if message??>
    <#assign messageType="warning"/>
<div class="alert alert-${messageType} alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
            aria-hidden="true">&times;</span></button>
${message}
</div>
</#if>