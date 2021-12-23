function toSubmit(){
    var account = document.getElementById("account").value
    var passwd = document.getElementById("password").value
    var VCode = document.getElementById("VCode").value;
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
    if (account == "" && passwd == ""){
        layer.alert("请输入账户和密码",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if (account == ""){
        layer.alert("请输入账户",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if (passwd == ""){
        layer.alert("请输入密码",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if (VCode == ""){
        layer.alert("请输入验证码",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        passwd.value = ""
        return false;
    }else if (VCode.length < 7){
        layer.alert("验证码错误",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        passwd.value = ""
        return false;
    }else if (!pPattern.test(passwd) || account.toString().length != 11){
        layer.alert("账户或密码错误", {icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv'})
        return false;
    }
}