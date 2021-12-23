
function is_account(value){
    let judgment_account = $('#judgment_account')
    if (value.toString().length == 11){
        judgment_account.attr("src","/WebExperiment2_war_exploded/resources/image/login/勾.png")
        judgment_account.attr("alt","正确")
    }else {
        judgment_account.attr("src","/WebExperiment2_war_exploded/resources/image/login/错误.png")
        judgment_account.attr("alt","错误")
    }
}
function is_match(value){
    var img = $("#judgment_passwd")
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
    if (pPattern.test(value)){
        img.attr("src","/WebExperiment2_war_exploded/resources/image/login/勾.png")
        img.attr("alt","正确")
    }else {
        img.attr("src","/WebExperiment2_war_exploded/resources/image/login/错误.png")
        img.attr("alt","错误")
    }
}
function is_same(value){
    var img = $("#judgment_password")
    if ($("#password").val() == value){
        img.attr("src","/WebExperiment2_war_exploded/resources/image/login/勾.png")
        img.attr("alt","正确")
    }else if (value == ""){
        img.attr("src","")
        img.attr("alt","")
    }else {
        img.attr("src","/WebExperiment2_war_exploded/resources/image/login/错误.png")
        img.attr("alt","错误")
    }
}
function toSubmit(){
    var account = $("#judgment_account")
    var passwd = $("#judgment_passwd")
    var passwd_again = $("#judgment_password")
    if (account.attr("alt") == "错误"){
        layer.alert("账户格式错误",{ icon: 2, title: "警告", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if(account.attr("alt") == ""){
        layer.alert("账户为空",{ icon: 2, title: "警告", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }

    if (passwd.attr("alt") == "错误"){
        layer.alert("密码格式不正确",{ icon: 2, title: "警告", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if(passwd.attr("alt") == ""){
        layer.alert("密码为空",{ icon: 2, title: "警告", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }

    if (passwd_again.attr("alt") == "错误" || passwd_again.attr("alt") == ""){
        layer.alert("两次密码不相同",{ icon: 2, title: "警告", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }
}