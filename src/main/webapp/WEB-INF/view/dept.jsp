<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>部门</title>
</head>
<body>

    <shiro:hasPermission name="dept:save">
            <a href="/department/save">增加部门</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="dept:delete">
            <a href="/department/delete">删除部门</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="dept:update">
            <a href="/department/update">修改部门</a>
    </shiro:hasPermission>

</body>
</html>
