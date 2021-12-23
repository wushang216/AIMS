document.getElementById("article_content_text").style.height = document.getElementById("article_content_text").scrollHeight+"px"
$("#check_pass").on("click",function (){
    let url =  window.location.href
    url = url.substring(url.lastIndexOf("/"),-1)
    url = url.substring(url.lastIndexOf("/"),-1)
    $.get({
        url:url + "/check/check_article?article="+$("#check_pass").val()+"&pass=1",
        success:function (){
            alert("成功")
        }
    })
    window.location.replace(url+"/view/management.jsp");
})
$("#check_veto").on("click",function (){
    let url =  window.location.href
    url = url.substring(url.lastIndexOf("/"),-1)
    url = url.substring(url.lastIndexOf("/"),-1)
    $.get({
        url:url + "/check/check_article?article="+$("#check_veto").val()+"&pass=-1",
        success:function (){
            alert("成功")
        }
    })
    window.location.replace(url+"/view/management.jsp");
})
$("#rewrite").on("click",function (){
    let url =  window.location.href
    url = url.substring(url.lastIndexOf("/"),-1)
    url = url.substring(url.lastIndexOf("/"),-1)
    window.location.replace(url + "/view/write.jsp?article="+$("#rewrite").val()+"&rewrite=1");
})
