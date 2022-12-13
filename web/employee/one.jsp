<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/head.jsp"/>
    <title>Employee Menu</title>
</head>
<body>
<jsp:include page="/WEB-INF/logedin-menu.jsp"/>
Hi ${sessionScope.user.username}
<br/>
employee>one
<br/>
<a href="/logout.do">EXIT</a>
</body>
</html>
