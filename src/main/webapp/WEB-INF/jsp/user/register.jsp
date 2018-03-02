<%--
  Created by IntelliJ IDEA.
  User: L1ANN
  Date: 2018/2/26
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册 | offer++</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/zzhsj.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/login_register.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->

</head>
<body>
<nav class="navbar navbar-default" style="height: 30px">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">
                <b style="font-size: 25px;float: left;margin-top:1px;color: #4682b4">Offer++&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;</b>
            </div>
        </div>

        <p class="navbar-text" style="font-size:23px;padding-left: 375px;color:black;font-family:arial;margin-top:8px;">
            <b> 职位天地，人才家园 </b></p>

        <a href="#" class="navbar-btn btn btn-default navbar-right btn-in-nav" style="margin-right: 30px">注册</a>
        <a href="#" class="navbar-btn btn btn-default navbar-right btn-in-nav" style="margin-right: 20px">登录</a>
    </div>
</nav>

<div class="container">
    <div class="row">
        <form class="col-xs-12 col-md-6 col-md-offset-3" action="${pageContext.request.contextPath}/user/register.action" method="post" >

            <h1>注册</h1>

            <div class="type_choose">
                <div class="fl user_type_box">
                    <div class="radio">
                        <label><input type="radio" name="user_type" checked="checked"/> 我是候选人</label>
                    </div>
                </div>
                <div class="fr user_type_box">
                    <div class="radio">
                        <label><input type="radio" name="user_type"/> 我是HR</label>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" id="email" placeholder="邮箱" name="userEmail" value="${user.userEmail}">
                <%--返回重复注册的错误信息--%>
                <c:if test="${repeatEmail!=null}">
                    ${repeatEmail}
                </c:if>
                <%--返回邮箱校验的错误信息--%>
                <c:forEach items="${errors}" var="error">
                    <c:if test="${error.defaultMessage=='邮箱不能为空'}">
                        ${error.defaultMessage}
                    </c:if>
                    <c:if test="${error.defaultMessage=='邮箱格式不正确'}">
                        ${error.defaultMessage}
                    </c:if>
                </c:forEach>
            </div>
            <button class="fr btn btn-primary" type="button" onclick="sendEmail()">发送验证码</button>
            <div class="form-group">
                <label for="inputCode">验证码</label>
                <input type="number" class="form-control" id="inputCode" name="inputCode" placeholder="请填写邮件中的验证码" value="${inputCode}">
                <%--返回验证码错误的错误信息--%>
                <c:if test="${codeError!=null}">
                    ${codeError}
                </c:if>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="userPassword" placeholder="密码" value="${user.userPassword}">
                <%--返回密码校验的错误信息--%>
                <c:forEach items="${errors}" var="error">
                    <c:if test="${error.defaultMessage=='密码不能为空'}">
                        ${error.defaultMessage}
                    </c:if>
                    <c:if test="${error.defaultMessage=='密码长度必须在6-16之间'}">
                        ${error.defaultMessage}
                    </c:if>
                </c:forEach>
            </div>
            <div class="form-group">
                <label for="confirmPassword">确认密码</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"placeholder="确认密码" value="${user.userPassword}">
                <%--返回确认密码的错误信息--%>
                <c:if test="${confirmError!=null}">
                    ${confirmError}
                </c:if>
            </div>

            <button type="submit" class="btn btn-primary btn-block">确定</button>
        </form>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6 left_block">
                <img src="<c:url value="/img/footer_logo.png"/>"/>
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

<section>

</section>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.js"/>"></script>

<script type="text/javascript">

    function sendEmail() {
        var email = $("#email").val();
        $.ajax({
            url: "sendEmail.action?email="+email,
            type: "post",
            data: {
            },
            success: function (data) {

            },
            error:function(){
                alert("发送验证码失败！");
            }
        });
    }
</script>
</body>
</html>
