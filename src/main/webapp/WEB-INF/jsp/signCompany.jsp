<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2018/2/4
  Time: 下午5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>companySign</title>
</head>
<body>
<div style="text-align:center">
    <form action="./companySignIn.action" method="post" align="">
        <table>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit"/></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
