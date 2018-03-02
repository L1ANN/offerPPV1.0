<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2018/2/26
  Time: 上午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公司密码</title>
</head>
<body>
    <form action="./updateCompany.action" method="post">
        <tr>
            <td>旧密码</td>
            <td><input type="text" name="oldpass"/></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" name="newpass"/></td>
        </tr>
        <tr>
            <td>再次验证新密码</td>
            <td><input type="password" name="newpassComfirm"/></td>
        </tr>
    </form>
</body>
</html>
