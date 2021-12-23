<%--
  Created by IntelliJ IDEA.
  User: 吴殇
  Date: 2021/12/14
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error/notLogin.jsp"  %>
<%@ page import="com.chang.dao.operateArticle" %>
<%@ page import="com.chang.dao.operateUser" %>
<%@ page import="com.chang.entity.user" %>
<%@ page import="com.chang.entity.article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%
    operateArticle operateArticle = new operateArticle();
    operateUser operateUser = new operateUser();
    user user = operateUser.GetUser(request.getParameter("id"));
    int num = operateArticle.GetArticleNumByUser(request.getParameter("id"));
    List<article> articles = operateArticle.GetArticleByUser(request.getParameter("id"), Integer.parseInt(request.getParameter("n")));
    if (user.getAvatar().equals("")){
        user.setAvatar("/WebExperiment2_war_exploded/resources/image/头像.svg");
    }
%>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    <script src="${pageContext.request.contextPath}/resources/js/jQuery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
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
        <a class="this" href="${pageContext.request.contextPath}/view/home.jsp?id=${sessionScope.ID}&n=1"><p><img src="${pageContext.request.contextPath}/resources/image/博客.svg" alt="">我的博客</p></a>
        <a href="${pageContext.request.contextPath}/view/write.jsp"><p><img src="${pageContext.request.contextPath}/resources/image/创作天地.svg" alt="">创作天地</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/历史记录.svg" alt="">浏览历史</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/关注.svg" alt="">我的关注</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/粉丝.svg" alt="">我的友人</p></a>
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
    <div id="aside_left_board">
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/设置.svg" alt="设置"><br>设置</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/评论.svg" alt="设置"><br>评论</p></a>
        <a href=""><p><img src="${pageContext.request.contextPath}/resources/image/点赞.svg" alt="设置"><br>点赞</p></a>
    </div>
</aside>
<div id="center">
    <article id="article">
        <div id="article_header">
            <span><%=user.getUser_name()%></span></br>
            <small>温柔正确的人总是难以生存，因为这世界既不温柔，也不正确</small>
        </div>
        <div id="article_content">
            <c:forEach var="article" items="<%=articles%>">
                <div class="content" style="background-color: rgb(<%=new Random().nextInt(300)%>,<%=new Random().nextInt(300)%> ,<%=new Random().nextInt(300)%> )">
                    <a href="${pageContext.request.contextPath}/view/readArticle.jsp?article=${article.article_id}">
                        <label>${article.article_name}</label>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div id="article_footer">0
            <ul id="pagination">
                <li><a href="#">«</a></li>
                <%for (int i = 0; i < num/6 + 1 ; i++) {%>
                <li><a href="" class="pagination_num"><%=i+1%></a></li>
                <%}%>
                <li><a href="#">»</a></li>
            </ul>
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
<script>
    document.getElementById("body").style.backgroundImage = "url('${pageContext.request.contextPath}/resources/image/background.jpeg')"
    $(".pagination_num").click(function (){
        var thisURL = document.location.href;
        thisURL = changeURLArg(thisURL,"n",$(".pagination_num").index(this)+1)
        window.location.href = thisURL
        return false
    })
</script>
</html>
