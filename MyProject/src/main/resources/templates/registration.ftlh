<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

    <h1>${message}</h1>
    <@l.login "/registration" />
</@c.page>