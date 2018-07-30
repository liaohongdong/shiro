<%--
  Created by IntelliJ IDEA.
  User: Liao Hongdong
  Date: 2018/7/24
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello <shiro:principal></shiro:principal>
<a href="/admin/logout">logout</a>
<shiro:hasRole name="admin">
    <a href="/admin/admin">admin</a>
</shiro:hasRole>
<shiro:hasRole name="user">
    <a href="/admin/user">user</a>
</shiro:hasRole>
    <a href="/admin/getTime">getTime</a>
</body>
</html>
