<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2018/2/4
  Time: 下午2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>companydetails</title>
</head>
<body>
<table border="1">
    <tr>
        <th>pk_com_id</th>
        <th>com_no</th>
        <th>com_email</th>
        <th>com_password</th>
        <th>com_name</th>
        <th>com_industry</th>
        <th>com_location</th>
        <th>com_size</th>
        <th>com_legalperson</th>
        <th>com_intro</th>
        <th>com_contact</th>
        <th>com_postlimit</th>
    </tr>
    <tr>
        <td><c:out value="${company.pkComId}"/></td>
        <td><c:out value="${company.comNo}"/></td>
        <td><c:out value="${company.comEmail}"/></td>
        <td><c:out value="${company.comPassword}"/></td>
        <td><c:out value="${company.comName}"/></td>
        <td><c:out value="${company.comIndustry}"/> </td>
        <td><c:out value="${company.comLocation}"/> </td>
        <td><c:out value="${company.comSize}"/> </td>
        <td><c:out value="${company.comLegalperson}"/> </td>
        <td><c:out value="${company.comIntro}"/> </td>
        <td><c:out value="${company.comContact}"/> </td>
        <td><c:out value="${company.comPostlimit}"/> </td>
    </tr>
</table>

</body>
</html>
