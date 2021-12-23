<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/11/23
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logIn.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/enroll.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/js/jQuery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/enroll.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <title>注册</title>
</head>
<body id="background_image">
<div class="form-wrapper">
    <form action="${pageContext.request.contextPath}/enroll" method="post" onsubmit="return toSubmit()">
        <div class="header">
            注册${sessionScope.success}
        </div>
        <div class="input-wrapper">
            <p><small>输入账号(11位的数字)</small></p>
            <div  class="border-wrapper">
                <p class="border-item">
                    <label for="account"><img src="${pageContext.request.contextPath}/resources/image/login/账号.png" alt="账户" style="padding-left: 12px"></label>
                    <!--oninput = "value=value.replace(/[^\d]/g,'')"设置只可以输入纯数字-->
                    <input type="search" name="account" id="account" placeholder="账户" maxlength="11"  oninput = "is_account(value);value=value.replace(/[^\d]/g,'')" autocomplete="off">
                    <img class="judgment" src="" alt="" id="judgment_account">

                </p>
            </div>
            <p><small>输入密码(最少6位，包括至少1个大写字母，<br>1个小写字母，1个数字，1个特殊字符)</small></p>
            <div  class="border-wrapper">
                <p class="border-item">
                    <label for="password"><img src="${pageContext.request.contextPath}/resources/image/login/账号.png" alt="账户" style="padding-left: 12px"></label>
                    <!--oninput = "value=value.replace(/[^\d]/g,'')"设置只可以输入纯数字-->
                    <input type="password" name="password" id="password" placeholder="密码" maxlength="11" oninput="is_match(value)">
                    <img class="judgment" src="" alt="" id="judgment_passwd">
                </p>
            </div>
                <p><small>再次输入</small></p>
            <div class="border-wrapper">
                <p class="border-item">
                    <label for="password_again"><img src="${pageContext.request.contextPath}/resources/image/login/密码.png" alt="密码" style="padding-left: 12px"></label>
                    <input type="password" name="password_again" id="password_again" maxlength="18" placeholder="再次输入" oninput="is_same(value)">
                    <img class="judgment" src="" alt="" id="judgment_password">
                </p>
            </div>
            <div class="border-wrapper" style="width: 60%">
                <p class="border-item">
                    <label for="VCode"><img src="${pageContext.request.contextPath}/resources/image/login/验证码.png" alt="验证码" style="padding-left: 12px"></label>
                    <input type="text" name="VCode" id="VCode" maxlength="7" placeholder="验证码" onchange="is_VCode(value)">
                </p>
            </div>
            <img src="${pageContext.request.contextPath}/VCode" id="VCode_img" alt="验证码">
            <em id="VCode_change">看不清？单击图片换一张</em>
        </div>
        <div class="action">
            <input type="submit" class="btn" value="完成">
        </div>
    </form>
    <div class="icon-wrapper">
        <a href="${pageContext.request.contextPath}/view/logIn.jsp" id="a_login">——————已有账号</a>
    </div>
</div>
</body>
<script type="text/javascript">
    window.onload = function (){
        <%if (session.getAttribute("success") != null){
            if (session.getAttribute("success").toString().equals("true")){%>
                layer.alert("注册成功",{ icon: 1, title: "注册成功", offset: "auto", skin: 'layui-layer-molv' })
        <%      session.removeAttribute("user");}else if (session.getAttribute("success").toString().equals("false")){%>
                layer.alert("注册失败，账号已存在",{ icon: 2, title: "注册失败", offset: "auto", skin: 'layui-layer-molv' })
        <%      }
            session.removeAttribute("success");}%>
    }
    function is_VCode(value){
        if (value.length < 7){
            layer.alert("验证码错误",{ icon: 1, title: "正确", offset: "auto", skin: 'layui-layer-molv' })
            document.getElementById("password").value = ""
        }
    }
    document.getElementById("VCode_img").onclick = function (){
        document.getElementById("VCode_img").src = "${pageContext.request.contextPath}/VCode?"+new Date().getTime();
    }
    document.getElementById("background_image").style.backgroundImage = "url('${pageContext.request.contextPath}/resources/image/background.jpeg')"

</script>
</html>