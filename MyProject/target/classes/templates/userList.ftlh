<#import "parts/common.ftlh" as c>
<@c.page>
<h1>List of users</h1>

<table class="table mt-5">
    <thread>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Role</th>
            <th scope="col">Edit</th>
        </tr>
    </thread>
    <tbody>
    <#list users as user>
        <tr scope="row">
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>