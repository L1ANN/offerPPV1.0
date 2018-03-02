<%--
  Created by IntelliJ IDEA.
  User: L1ANN
  Date: 2018/2/28
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>找回密码 | offer++</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/zzhsj.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/login_register.css"/>" rel="stylesheet">
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
        <form class="col-xs-12 col-md-6 col-md-offset-3" action="${pageContext.request.contextPath}/user/forgetEmail.action" method="post">
            <h1>找回密码</h1>
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
                <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                <c:if test="${error!=null}">
                    ${error}
                </c:if>
            </div>
            <button class="fr btn btn-primary" type="button" onclick="sendEmail()">发送验证码</button>
            <div class="form-group">
                <label for="inputValidator">验证码</label>
                <input type="number" class="form-control" id="inputValidator" name="inputCode" placeholder="请填写邮件中的验证码">
                <c:if test="${codeError!=null}">
                    ${codeError}
                </c:if>
            </div>

            <button type="submit" class="btn btn-primary btn-block">确定</button>
        </form>
    </div>
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

<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.js"/>"></script>
<script type="text/javascript">
    function sendEmail() {
        var email = $("#email").val();
        $.ajax({
            url: "sendEmail.action?email="+email+"&request=forgetemail",
            type: "post",
            data: {
            },
            success: function (data) {
                if(data.result=="emailFalse"){
                    alert("邮箱输入错误，请重新输入！");

                }
            },
            error:function(){
                alert("发送验证码失败！");
            }
        });
    }
</script>
</body>
</html>
