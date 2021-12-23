<%@ page import="com.chang.dao.operateUser" %>
<%@ page import="com.chang.entity.user" %>
<%@ page import="com.chang.entity.userDate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.chang.dao.operateArticle" %>
<%@ page import="com.chang.entity.articleDate" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/12/5
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error/notLogin.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/management.css">
    <script src="${pageContext.request.contextPath}/resources/js/jQuery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<%
    operateUser operateUser = new operateUser();
    operateArticle operateArticle = new operateArticle();
    List<articleDate> articles = operateArticle.GetArticle();
    user user = operateUser.GetUser((String) session.getAttribute("ID"));
    if (user.getAvatar().equals("")){
        user.setAvatar("/WebExperiment2_war_exploded/resources/image/头像.svg");
    }
    List<userDate> users = operateUser.getAllUser((String) session.getAttribute("ID"));
%>
<body id="body">
<div id="header">
    <header>
        <div id="nav_left">
            <img src="${pageContext.request.contextPath}/resources/image/logo.png" height="50" alt="logo">
            <ul class="layui-nav">
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/MasterPage.jsp?n=1">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/write.jsp">创作园子</a></li>
            </ul>
        </div>
        <form id="search" action="#" method="post">
            <input id="search_input" type="text" placeholder="搜索"  autocomplete="off">
            <button><img src="${pageContext.request.contextPath}/resources/image/search.svg" alt="搜索" ></button>
        </form>
        <div id="search_Result"  hidden>
            <ul>
            </ul>
        </div>
        <div id="nav_right" >
            <ul  class="layui-nav" lay-bar="disabled" style="background-color: rgba(0,0,0,0)">
                <%
                    String identity = (String) session.getAttribute("identity");
                    if (identity.equals("root")){%>
                <li>
                    <a href="${pageContext.request.contextPath}/view/management.jsp"><img class="img" src="${pageContext.request.contextPath}/resources/image/管理.svg" alt="管理"></a>
                </li>
                <%}%>
                <li>
                    <a href="${pageContext.request.contextPath}/view/write.jsp"><img class="img" src="${pageContext.request.contextPath}/resources/image/newpost.svg" alt="随笔"></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/view/home.jsp?id=${sessionScope.ID}&n=1"><img class="img" src="${pageContext.request.contextPath}/resources/image/myblog.svg" alt="博客"></a>
                </li>
                <li>
                    <a href="#"><img  class="layui-nav-item" src="${pageContext.request.contextPath}/resources/image/message.svg" alt="消息"></a>
                    <span class="layui-badge layui-bg-gray"><label>5</label></span>
                </li>
            </ul>
        </div>
    </header>
</div>
<aside id="aside_left">
    <div  id="aside_left_avatar">
        <a href="#" class="layui-font-blue"><img src="<%=user.getAvatar()%>" alt="头像"></a>
        <div>
            <p><samp><%=user.getUser_name()%></samp></p>
        </div>
    </div>
    <div id="aside_left_nav">
        <small>导航</small>
    </div>
    <div id="aside_left_composition">
        <small>组成</small>
        <ul id="aside_left_composition_nav">
            <li>
                <a><p><img src="${pageContext.request.contextPath}/resources/image/分类.svg" alt="">分类</p></a>
                <dl class="nav_dl">
                    <dd><a href="">大数据</a></dd>
                    <dd><a href="">区块链</a></dd>
                    <dd><a href="">人工智能</a></dd>
                    <dd><a href="">网络安全</a></dd>
                    <dd><a href="">架构设计</a></dd>
                    <dd><a href="">算法与数据设计</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div id="aside_left_board" onclick="">
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/设置.svg" alt="设置"><br>设置</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/评论.svg" alt="设置"><br>评论</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/点赞.svg" alt="设置"><br>点赞</p></a>
    </div>
</aside>
<div id="center">
    <article id="article">
        <div id="article_header">
            <span id="article_header_span">管理员</span>
        </div>
        <div id="article_content">
            <div id="article_content_header">
                <p>
                    <button id="user_management"><label id="article_content_button1" >用户</label></button>
                    <button id="article_management"><label id="article_content_button2">文章</label></button>
                </p>
            </div>
            <div id="article_content_user">
                <table>
                    <thead>
                    <tr style="text-align: center">
                        <th>用户名</th>
                        <th>用户id</th>
                        <th>创建时间</th>
                        <th>是否冻结</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="allUser" items="<%=users%>">
                        <tr class="userDate">
                            <td>${allUser.user_name}</td>
                            <td><a href="${pageContext.request.contextPath}/view/home.jsp?id=${allUser.user_id}&n=1">${allUser.user_id}</a></td>
                            <td><fmt:formatDate value="${allUser.date}" pattern="yyyy年MM月dd日"/></td>
                        </tr>
                    </c:forEach>
                    <script type="text/javascript">
                        <%
                        int i = 0;
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                        for(userDate userDate : users){
                            if (userDate.seal.getTime() < date.getTime()){
                                %>
                        var unsealed = document.createElement(`td`)
                        unsealed.textContent = "正常"
                        document.getElementsByClassName("userDate")[<%=i%>].appendChild(unsealed)
                        document.getElementsByClassName("userDate").item(<%=i%>).getElementsByTagName("td").item(3).onclick = function (){
                            layer.confirm('该账号目前状况正常，是否封号', {
                                btn: ['是','否'] //按钮
                            }, function(){
                                layer.msg('准备对该账号冻结', {
                                    time: 20000, //20s后自动关闭
                                    btn: ['该账户将会封号30天']
                                },function (){
                                    $.get({
                                        url:"${pageContext.request.contextPath}/freeze/unsealed?id="+"<%=userDate.getUser_id()%>",
                                        date:{"id":"<%=userDate.getUser_id()%>"},
                                        success:function (){
                                            alert("已冻结")
                                            window.location.replace("${pageContext.request.contextPath}/view/management.jsp");
                                        },
                                        error:function (err,status){
                                            console.log(err+"+"+status)
                                        }
                                    })
                                });
                            });
                        }
                        <%
                            }else {
                                %>
                        var sealed = document.createElement(`td`)
                        sealed.textContent = "封号"
                        document.getElementsByClassName("userDate")[<%=i%>].appendChild(sealed)
                        document.getElementsByClassName("userDate").item(<%=i%>).getElementsByTagName("td").item(3).onclick = function (){
                            layer.confirm('该账号目前已被冻结，是否解封', {
                                btn: ['是','否'] //按钮
                            }, function(){
                                layer.msg('准备解封', {
                                    time: 20000, //20s后自动关闭
                                    btn: ['解封']
                                },function (){
                                    $.get({
                                        url:"${pageContext.request.contextPath}/freeze/sealed?id="+"<%=userDate.getUser_id()%>",
                                        date:{"user_id":"<%=userDate.getUser_id()%>"},
                                        success:function (){
                                            alert("已解封")
                                            window.location.replace("${pageContext.request.contextPath}/view/management.jsp");
                                        }
                                    })
                                });
                            });
                        }
                        <%
                            }
                            i++;
                        }
                        %>
                    </script>
                    </tbody>
                </table>
            </div>
            <div id="article_content_article" style="display: none">
                <table>
                    <thead>
                    <tr>
                        <th>用户id</th>
                        <th>文章id</th>
                        <th>文章名</th>
                        <th>创建时间</th>
                        <th>是否过审</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="article" items="<%=articles%>">
                        <tr>
                            <td>${article.user_id}</td>
                            <td>${article.article_id}</td>
                            <td>${article.article_name}</td>
                            <td>${article.date}</td>
                            <c:choose>
                                <c:when test="${article.audit == 1}">
                                    <td><button class="reReview" value="${article.article_id}">已过审</button></td>
                                </c:when>
                                <c:when test="${article.audit == 0}">
                                    <td><button class="pending" value="${article.article_id}"><strong style="color: red">待审合</strong></button></td>
                                </c:when>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </article>
    <aside id="aside_right">
        <div id="aside_right_leaderboard">
            <a href="#" class="aside_right_leaderboard_img"><p><img src="${pageContext.request.contextPath}/resources/image/关注.svg" alt="关注"></p></a>
            <a href="#" class="aside_right_leaderboard_img"><p><img src="${pageContext.request.contextPath}/resources/image/评论.svg" alt="评论"></p></a>
            <a href="#" class="aside_right_leaderboard_img"><p><img src="${pageContext.request.contextPath}/resources/image/点赞.svg" alt="点赞"></p></a>
        </div>
    </aside>
</div>
<footer>
    <div>
        &copy;<label id="year"></label> &nbsp;Copyright
    </div>
    <div style="
    position: relative;
    left: 380Px;"><a href="${pageContext.request.contextPath}/view/logIn.jsp" target="_blank" onclick="window.close()">退出登录</a></div>

</footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/management.js"></script>
<script type="text/javascript">
    document.getElementById("body").style.backgroundImage = "url('${pageContext.request.contextPath}/resources/image/background.jpeg')";
</script>
</html>
