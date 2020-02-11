<%--
  Created by IntelliJ IDEA.
  User: Venus
  Date: 2020/2/1
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
id:${requestScope.user.userId}<br/>
email:${requestScope.user.email}<br/>
username:${requestScope.user.userName}<br/>
phone:${requestScope.user.phone}<br/>


<c:forEach items="userlist" var="c" varStatus="st">
    <tr>
        <td>${c.email}</td>
        <td>${c.phone}</td>
    <td>hello</td>
    </tr>
</c:forEach>
</body>
</html>
