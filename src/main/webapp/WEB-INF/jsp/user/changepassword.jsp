<%--
  Created by IntelliJ IDEA.
  User: L1ANN
  Date: 2018/3/1
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改密码 |offer++</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/selfstyle_changepassword.css"/>">
    <link href="<c:url value="/css/zzhsj.css"/>" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <div class="navbar-brand">
            <b style="font-size: 25px;float: left;margin-top:1px;color: #4682b4">Offer++&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;</b>
        </div>
    </div>

    <ul class="nav navbar-nav navtop">
        <li><a href="index.html">首页</a></li>
        <li><a href="jobsearch.html">职位搜索</a></li>
        <li class="dropdown">
            <a href="#" data-toggle="dropdown">我的投递
                <span class="caret">
        </span>
            </a>

            <ul class="dropdown-menu">
                <li><a href="#">新的投递</a></li>
                <li><a href="#">已被查阅</a></li>
                <li><a href="#">等待面试</a></li>

            </ul>
        </li>

        <li><a href="#">简历管理</a></li>

        <li class="dropdown navbar-right" style="padding-right:65px;margin-left: 400px;">
            <a href="#" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span>
                <span>用户名</span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#">我的收藏</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出登录</a></li>

            </ul>
        </li>

    </ul>

</nav>


<div class="container">
    <div class="row">

        <form action="${pageContext.request.contextPath}/user/changePassword.action" method="post">
            <h1>修改密码</h1>

            <div class="form-group">
                <label for="oldPassword">旧密码</label>
                <input type="password" name="oldPassword" id="oldPassword" placeholder="请输入旧密码" class="form-control" value="${data.oldPassword}">
                <c:if test="${oldError!=null}">
                    ${oldError}
                </c:if>
            </div>


            <div class="form-group">

                <label for="newPassword">新密码</label>
                <input type="password" name="userPassword" id="newPassword" placeholder="请输入新的密码" class="form-control" value="${data.newPassword}">
                <c:forEach items="${errors}" var="error">
                    ${error.defaultMessage}<br/>
                </c:forEach>
            </div>

            <div class="form-group">

                <label for="confirmNewPassword">确认新密码</label>
                <input type="password" name="confirmNewPassword" id="confirmNewPassword" placeholder="请再次输入新的密码" value="${data.confirmNewPassword}"
                       class="form-control">
                <c:if test="${confirmError!=null}">
                    ${confirmError}
                </c:if>

            </div>

            <button class="btn btn-default yes" type="submit">提交</button>
        </form>

    </div>
</div>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6 left_block">
                <img src="img/footer_logo.png"/>
                <p>华中科技大学软件学院2017届学生实训作品, 由软酷网老师指导完成</p>
                <p>欢迎大家使用!</p>
            </div>

            <div class="col-md-2">
                <h4>看机会</h4>
                <ul>
                    <li><a href="#">看机会</a></li>
                    <li><a href="#">使用攻略</a></li>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#">邀请朋友</a></li>
                    <li><a href="#">移动版</a></li>
                </ul>
            </div>
            <div class="col-md-2">
                <h4>博客</h4>
                <ul>
                    <li><a href="#">文章</a></li>
                    <li><a href="#">活动</a></li>
                </ul>
            </div>
            <div class="col-md-2">
                <h4>offer++</h4>
                <ul>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">加入我们</a></li>
                    <li><a href="#">法律条款</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
       if(${result!=null}){
           alert("密码修改成功");
       }
    });
</script>
</body>
</html>
