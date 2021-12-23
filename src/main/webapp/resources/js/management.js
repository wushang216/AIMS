var button1 = $("#article_content_user")
var button2 = $("#article_content_article")
$("#user_management").on("click", function (){
    document.getElementById("user_management").children[0].id = "article_content_button1"
    document.getElementById("article_management").children[0].id = "article_content_button2"
    button2.css("display","none")
    button1.css("display","")
})
$("#article_management").on("click", function (){
    document.getElementById("user_management").children[0].id = "article_content_button2"
    document.getElementById("article_management").children[0].id = "article_content_button1"
    button1.css("display","none")
    button2.css("display","")
})
$(".pending").on("click",function (){
    var value = $(this).val();
    layer.confirm('前往审核', {
        btn: ['是','否'] //按钮
    },function (){
        var url =  window.location.href
        url = url.substring(url.lastIndexOf("/"),-1)
        url = url + "/readArticle.jsp?article="+value+"&user=root"
        window.location.href = url
    });
})
$(".reReview").on("click",function (){
    var value = $(this).val();
    layer.confirm('是否重新审核', {
        btn: ['是','否'] //按钮
    },function (){
        var url =  window.location.href
        url = url.substring(url.lastIndexOf("/"),-1)
        url = url + "/readArticle.jsp?article="+value+"&user=root"
        window.location.href = url
    });
})