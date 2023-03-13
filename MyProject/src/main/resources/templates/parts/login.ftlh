<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group mt-5 ">
            <label for="username"> User Name </label>
            <input type="text" id="username" name="username" class="form-control"/>

        <div class="form-group">
            <label>Password </label>
            <input type="password" name="password" class="form-control"/>
        </div>
        <div class="form-group">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
        <div class="form-group mb-3"><button type="submit" class="btn btn-primary" />Sign In</div>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mb-3"><button type="submit" class="btn btn-primary btn-sm" />Sign Out</div>
    </form>
</#macro>