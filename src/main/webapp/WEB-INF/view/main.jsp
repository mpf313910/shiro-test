<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    主页面
    <a href="/logout">退出</a>
    
    <shiro:hasPermission name="emp:list">
        <a href="/employee/list">员工列表</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="dept:list">
        <a href="/department/list">部门列表</a>
    </shiro:hasPermission>
</body>
</html>
