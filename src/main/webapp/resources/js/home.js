    var search_input = $("#search_input");
    var search_Result = $("#search_Result")
    window.onload = function (){
        window.history.replaceState(null, null, window.location.href);
        document.getElementById("year").textContent = new Date().getFullYear().toString()
    }
// 修改URL中指定参数的值
    function changeURLArg(url,arg,arg_val){
        var pattern=arg+'=([^&]*)';
        var replaceText=arg+'='+arg_val;
        if(url.match(pattern)){
            var tmp='/('+ arg+'=)([^&]*)/gi';
            tmp=url.replace(eval(tmp),replaceText);
            return tmp;
        }else{
            if(url.match('[\?]')){
                return url+'&'+replaceText;
            }else{
                return url+'?'+replaceText;
            }
        }
    }
    search_input.focus(function (){
        search_Result.removeAttr("hidden");
    })
    search_input.blur(function (){
        search_Result.mouseover(function (){
            search_Result.removeAttr("hidden");
        })
        search_Result.mouseout(function (){
            search_Result.prop("hidden", "hidden");
        })
    })
    $(".pagination_num").click(function (){
        var thisURL = document.location.href;
        thisURL = changeURLArg(thisURL,"n",$(".pagination_num").index(this)+1)
        window.location.href = thisURL
        return false
    })
