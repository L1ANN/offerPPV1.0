<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2018/2/16
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerCompany</title>
</head>
<body>
<div style="text-align:center">
    <form action="./companyRegister.action" method="post" >
        <table>
        <tr>
            <td>企业工商注册号</td>
            <td><input type="text" name="comNo" id="comNo"/></td>
        </tr>
        <tr>
            <td>公司名称</td>
            <td><input type="text" name="comName" id="comName"/></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="comEmail" id="comEmail"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="comPassword" id="comPassword"/></td>
        </tr>
        <tr>
            <td>所属行业</td>
            <td><input type="text" name="comIndustry" id="comIndustry"/></td>
        </tr>
        <tr>
            <td>地点</td>
            <td><input type="text" name="comLocation" id="comLocation"/></td>
        </tr>
        <tr>
            <td>规模</td>
            <td><input type="text" name="comSize" id="comSize"/></td>
        </tr>
        <tr>
            <td>法人姓名</td>
            <td><input type="text" name="comLegalperson" id="comLegalperson"/></td>
        </tr>
        <tr>
            <td>公司介绍</td>
            <td><input type="text" name="comIntro" id="comIntro"/></td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td><input type="text" name="comContact" id="comContact"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="提交"/></td>
        </tr>
        </table>
    </form>
</div>
</body>
</html>
