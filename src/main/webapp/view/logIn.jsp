<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/11/21
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--<link rel="prefetch" href="${pageContext.request.contextPath}/resources/video/Comp%201.avi.mp4" />--%>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1803712_190aham4mrt.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logIn.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/js/jQuery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/logIn.js"></script>
    <title>登录</title>
</head>
<body id="background_image">
<div class="form-wrapper">
    <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return toSubmit()">
        <div class="header">
            登录
        </div>
        <div class="input-wrapper">
            <div  class="border-wrapper">
                <p class="border-item">
                    <label for="account"><img src="${pageContext.request.contextPath}/resources/image/login/账号.png" alt="账户" style="padding-left: 12px"></label>
                    <!--oninput = "value=value.replace(/[^\d]/g,'')"设置只可以输入纯数字-->
                    <input type="search" name="account" id="account" placeholder="账户" maxlength="11"  oninput = "value=value.replace(/[^\d]/g,'')">
                </p>
            </div>
            <div class="border-wrapper">
                <p class="border-item">
                    <label for="password"><img src="${pageContext.request.contextPath}/resources/image/login/密码.png" alt="密码" style="padding-left: 12px"></label>
                    <input type="password" name="password" id="password" maxlength="18" placeholder="密码" >
                </p>
            </div>
            <div class="border-wrapper" style="width: 60%">
                <p class="border-item">
                    <label for="VCode"><img src="${pageContext.request.contextPath}/resources/image/login/验证码.png" alt="验证码" style="padding-left: 12px"></label>
                    <input type="text" name="VCode" id="VCode" maxlength="7" placeholder="验证码">
                </p>
            </div>
            <img src="${pageContext.request.contextPath}/VCode" id="VCode_img" alt="验证码">
            <em>看不清？单击图片换一张</em>
        </div>
        <div class="action">
            <input type="submit" class="btn" value="登录">
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/view/email_login.jsp" id="email_login">忘记密码了？邮箱登录</a>
            <a href="${pageContext.request.contextPath}/view/enroll.jsp" id="enroll">没有账户？注册</a>
        </div>
        <div class="icon-wrapper">
            <a href="https://wx.qq.com/" target="_blank"><i class="iconfont icon-weixin"></i></a>
            <a href="https://weibo.com/login.php/" target="_blank"><i class="iconfont icon-weibo"></i></a>
            <a href="https://github.com/" target="_blank"><i class="iconfont icon-github" ></i></a>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    <%if(request.getParameter("sealed") != null){
            if (request.getParameter("sealed").equals("true")){%>
        layer.alert("你的账号已被封禁", {icon: 2, title: "warning", offset: "auto", skin: 'layui-layer-molv'})
    <%}}%>
    <%if (session.getAttribute("error") != null){
        if (session.getAttribute("error").equals("-1")){
            %>layer.alert("账户或密码错误", {icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv'})<%
        }else if (session.getAttribute("error").equals("0"))
            %>layer.alert("账户不存在", {icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv'})<%
    %><%}session.removeAttribute("error");%>
    <%if (session.getAttribute("VCode_error") != null){
        if (session.getAttribute("VCode_error").equals("false"))%>
             layer.alert("验证码错误",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
    <%session.removeAttribute("VCode_error");}%>
    document.getElementById("VCode_img").onclick = function (){
        document.getElementById("VCode_img").src = "${pageContext.request.contextPath}/VCode?"+new Date().getTime();
    }
    document.getElementById("background_image").style.backgroundImage = "url('${pageContext.request.contextPath}/resources/image/background.jpeg')"
</script>
</html>
