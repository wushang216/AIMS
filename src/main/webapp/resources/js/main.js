$(document).ready(function (){
    var img = $(".aside_right_leaderboard_img")
    var nav =  $("#aside_left_composition_nav")
    var content  = $(".content")
    var url =  window.location.href
    url = url.substring(url.lastIndexOf("/"),-1)
    url = url.substring(url.lastIndexOf("/"),-1)
    var count_nav = 0
    img.mouseover(function (e) {
            $(this).animate({
                height: '40px'
            })
            $(this).animate({
                height: '30px'
            })

        }
    )
    img.click(function (){
        switch ($(this).index()) {
            case 0 :
                $("#aside_right_attention").css("display","")
                $("#aside_right_comment").css("display","none")
                $("#aside_right_like").css("display","none")
                break;
            case 1 :
                $("#aside_right_attention").css("display","none")
                $("#aside_right_comment").css("display","")
                $("#aside_right_like").css("display","none")
                break;
            case 2:
                $("#aside_right_attention").css("display","none")
                $("#aside_right_comment").css("display","none")
                $("#aside_right_like").css("display","")
                break;
            default :
                break;
        }
    })
    content.mouseover(function (){
        var label = $(".content_label")
        $(this).find(label).fadeIn()
        $(this).find(label).css("filter" ,"brightness(170%)")
        $(this).find($(".content_name")).css("filter" ,"brightness(170%)")
    })
    content.mouseout(function (){
        $(this).find($(".content_label")).fadeOut()
        $(this).find($(".content_name")).removeAttr("filter")
        // $(this).children($(".content_label")).fadeOut()
    })
    nav.click(function (){
        count_nav ++
        if (count_nav%2 == 0){
            $("#aside_left_composition_nav .nav_dl").slideDown()
        }
        if (count_nav%2 == 1){
            $("#aside_left_composition_nav .nav_dl").slideUp()
        }
    })
    for (var i = 0;i < content.length;i++){
        document.getElementsByClassName("content").item(i).style.backgroundImage = "url('"+url+"/resources/image/homePicture/"+getRndInteger(1,6)+".jpg')"
    }
    function getRndInteger(min, max) {
        return Math.floor(Math.random() * (max - min) ) + min;
    }
})
search_input.on("input",function (){
    var search_Result = $("#search_Result");
    search_Result.empty()
    var labels = {
        "1":"?????????",
        "2":"?????????",
        "3":"????????????",
        "4":"????????????",
        "5":"????????????",
        "6":"?????????????????????",
    }
    $.post({
        url:"/WebExperiment2_war_exploded/GetSearchKeyword/SearchKeyword",
        data:{"Key":search_input.val()},
        dataType:"json",
        success:function (date){
            for ( var i = 0 ; i < date.length ; i++){
                with (date[i]){
                    L = ""
                    for (var j = 0 ; j < article_label.length ;j++){
                        L = L +" "+ labels[article_label[j]].toString()
                    }
                    console.log(L)
                    search_Result.append("<li><a href='/WebExperiment2_war_exploded/view/readArticle.jsp?article="+article_id+"'>"+article_name+"</a>"+"<span><small>"+L+"</small></span>"+"</li>")
                }
            }
        }
    })
})