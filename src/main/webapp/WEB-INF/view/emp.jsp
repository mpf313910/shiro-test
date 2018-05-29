<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>员工</title>
</head>
<body>
    <shiro:hasPermission name="emp:save">
        <a href="/employee/save">增加员工</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="emp:delete">
        <a href="/employee/delete">删除员工</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="emp:update">
        <a href="/employee/update">修改员工</a>
    </shiro:hasPermission>
</body>
</html>
