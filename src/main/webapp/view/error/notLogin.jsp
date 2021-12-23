<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/12/18
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面丢失</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error.css">
</head>
<body>
<div id="center">
    <div id="center_left">
        <div><p>你的账号丢失!</p></div>

        <div><p><label id="label_time">5</label>秒后返回登陆界面</p></div>
    </div>
    <div>
        <img src="${pageContext.request.contextPath}/resources/image/error/404.gif" alt="404">
    </div>
</div>
</body>
<script type="text/javascript">
    window.onload = function (){
        console.log(1)
        var i = 4
        var time = setInterval(function (){
            document.getElementById("label_time").textContent = i + ""
            if (i === 0){
                clearInterval(time)
            }
            i --
        },1000)
    }

</script>
</html>
