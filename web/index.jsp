<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/head.jsp"/>
</head>

<body>
<jsp:include page="/WEB-INF/no-login-menu.jsp"/>

<div class="container">
    <div class="row d-flex align-items-center justify-content-center h-50">
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
            <form action="/login.do">
                <div class="form-floating mb-2">
                    <input type="text" class="form-control" id="floatingusername" placeholder="Enter Username"
                           name="username"/>
                    <label for="floatingusername">Username</label>
                </div>

                <div class="form-floating mb-2">
                    <input type="password" class="form-control" id="floatingpassword" placeholder="Enter Password"
                           name="password"/>
                    <label for="floatingpassword">Password</label>
                </div>

                <input type="submit" class="btn btn-primary btn-block mb-4" value="LOGIN"/>
            </form>
        </div>
    </div>
</div>
</body>

</html>
