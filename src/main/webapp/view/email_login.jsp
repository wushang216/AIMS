<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/11/25
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logIn.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/email_login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/email_login.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jQuery-3.6.0.js"></script>
    <title>邮箱登录</title>
</head>
<body id="background_image">
<div class="form-wrapper">
    <form action="${pageContext.request.contextPath}/email_login" method="post" onsubmit="return toSubmit()">
        <div class="header">
            邮箱登录
        </div>
        <h1 style="align-content: center"></h1>
        <div class="input-wrapper">
            <div  class="border-wrapper">
                <p class="border-item">
                    <label for="email_input"><img src="${pageContext.request.contextPath}/resources/image/login/邮箱.png" alt="邮箱" style="padding-left: 12px"></label>
                    <!--oninput = "value=value.replace(/[^\d]/g,'')"设置只可以输入纯数字-->
                    <input type="search" name="email" id="email_input" placeholder="邮箱" maxlength="30" oninput="send_email(value)">
                    <span id="send"><label  id="label_time" class="0"></label></span>
                </p>
            </div>
            <div class="border-wrapper">
                <p class="border-item">
                    <label for="code"><img src="${pageContext.request.contextPath}/resources/image/login/密码.png" alt="密码" style="padding-left: 12px"></label>
                    <input type="text" name="code" id="code" maxlength="7" placeholder="验证码" >
                </p>
            </div>
        </div>
        <div class="action">
            <input type="submit" id="btn" class="btn" value="登录">
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/view/logIn.jsp" id="enroll">————使用密码登录</a>
        </div>
    </form>
</div>
</body>
<script>
    var button = document.createElement("input")
    button.id="email_send"
    button.type="image"
    button.alt="发送"
    button.name="send_email"
    button.src="${pageContext.request.contextPath}/resources/image/login/发送.png"
    button.onclick=sendEmail
    function timing() {
        if (sessionStorage.getItem("wait") != "") {
            time.textContent = sessionStorage.getItem("wait")
            time.textContent = "" + parseInt(time.textContent) - 1
            sessionStorage.setItem("wait", time.textContent)
        } else {
            time.textContent = "" + parseInt(time.textContent) - 1
            sessionStorage.setItem("wait", time.textContent)
        }
        document.getElementById("label_time").className = time.textContent
        if (time.textContent == "0") {
            var email = document.getElementById("email_input")
            sessionStorage.removeItem("wait")
            var send = document.getElementById("send")
            send.removeChild(time)
            email.readOnly = false
            clearTimeout(myTime)
        }
    }
    function sendEmail(){
        $.post({
            url:"${pageContext.request.contextPath}/Email/logInEmail",
            data:{"email":$("#email_input").val()},
            dataType:'json',
            success:function (data){
                console.log(data)
                if (data == true){
                    var send = document.getElementById("send")
                    var email = document.getElementById("email_input")
                    layer.alert("我们已经将邮件发至邮箱："+email.value+"请注意查收",{ icon: 1, title: "已发送", offset: "auto", skin: 'layui-layer-molv' })
                    email.style.top="0"
                    send.removeChild(button)
                    send.appendChild(time)
                    sessionStorage.setItem("email",email.value)
                    email.readOnly = true
                    if (sessionStorage.getItem("wait") != null){
                        time.textContent = sessionStorage.getItem("wait")
                    }else {
                        time.textContent = "60"
                        sessionStorage.setItem("wait",time.textContent)
                    }
                    myTime = setInterval("timing()",1000)
                }else {
                    layer.alert("该邮箱未绑定账号",{ icon: 2, title: "发送失败", offset: "auto", skin: 'layui-layer-molv' })
                }
            },
            error:function (){
                console.log("失败")
            }
        })
        return false;
    }
    document.getElementById("background_image").style.backgroundImage = "url('${pageContext.request.contextPath}/resources/image/background.jpeg')"

</script>
</html>