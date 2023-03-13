<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

<div class="form-row">
    <form method="post" class="form-inline"  >
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="text" class="form-control " placeholder="Input text message" />
        <input type="text" name="tag" class="form-control ml-2" placeholder="Input tag">
        <button type="submit" class="btn btn-primary ml-2">Add</button>
    </form>
</div>
<div class="form-row mt-5 mb-5">

<form action="/main" method="action" class="form-inline" >
    <input type="text" name="filter" class="form-control" placeholder="Search by tag">
    <button type="submit" class="btn btn-primary ml-2">Search</button>
</form>
</div>
<h2>List of messages: </h2>
<#list messages as message>

    <div class="card-group">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${message.tag} by ${message.author.username}</h5>
            <p class="card-text">${message.text}</p>
<#--            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>-->
        </div>
    </div>
    </div>


<#else>
    No message
</#list>
</@c.page>