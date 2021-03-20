<%--
  Created by IntelliJ IDEA.
  User: MSI-PC
  Date: 2021/3/17
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>${error}</div>
    邮箱：<input type="text" name="email"><br>
    密码：<input type="text" name="psw"><br>
    <input type="submit" name="登录">
</form>
</body>
</html>
