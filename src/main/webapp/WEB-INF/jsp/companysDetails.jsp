<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2018/2/16
  Time: 上午11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>companysDetails</title>
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
        <th>com_pass</th>
    </tr>

        <c:forEach var="company" items="${companyList}">
            <tr>
                <td>${company.pkComId}</td>
                <td>${company.comNo}</td>
                <td>${company.comEmail}</td>
                <td>${company.comPassword}</td>
                <td>${company.comName}</td>
                <td>${company.comIndustry}</td>
                <td>${company.comLocation}</td>
                <td>${company.comSize}</td>
                <td>${company.comLegalperson}</td>
                <td>${company.comIntro}</td>
                <td>${company.comContact}</td>
                <td>${company.comPostlimit}</td>
                <td>${company.comPass}</td>
            </tr>
        </c:forEach>

</table>

</body>
</html>
