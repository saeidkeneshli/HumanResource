<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Menu</title>
    <jsp:include page="/WEB-INF/head.jsp"/>
</head>

<body>
<jsp:include page="/WEB-INF/logedin-menu.jsp"/>

Hi ${sessionScope.user.username}
<br/>
employee>index
<br/>
<a href="/logout.do">EXIT</a>
</body>
</html>
