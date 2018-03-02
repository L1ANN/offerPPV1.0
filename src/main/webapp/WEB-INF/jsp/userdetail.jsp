<%--
  Created by IntelliJ IDEA.
  User: L1ANN
  Date: 2018/1/18
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>邮箱</td>
        <td>姓名</td>
        <td>电话</td>
        <td>年龄</td>
    </tr>
    <tr>
        <td>${user.userEmail}</td>
        <td>${user.userName}</td>
        <td>${user.userPhone}</td>
        <td>${user.userAge}</td>
    </tr>
</table>


</body>
</html>
