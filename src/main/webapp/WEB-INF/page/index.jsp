<%--
  Created by IntelliJ IDEA.
  User: 姚文
  Date: 2020/2/7
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="align-content: center">
        <h1>登录成功 ${requestScope.msg}!</h1>
        <h1>hello ${sessionScope.user.userName}!<h1>
    </div>
</body>
</html>
