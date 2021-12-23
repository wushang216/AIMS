var time = document.createElement("label")
var myTime ;
time.onclick=function (){
    layer.alert("邮件已经发出，请耐心等待",{ icon: 1, title: "已发送", offset: "auto", skin: 'layui-layer-molv' })
}
time.style.color="#565e60"
time.textContent = "0"


window.onload = function (){

    if (!(sessionStorage.getItem("wait") == null)){
        var email = document.getElementById("email_input")
        email.value = sessionStorage.getItem("email")
        time.textContent = sessionStorage.getItem("wait")
        myTime = setInterval("timing()",1000)
        if (document.getElementById("send").childNodes[0].nodeName == "LABEL"){
            email.readOnly = true
        }
        document.getElementById("send").appendChild(time)
    }
}

//提交前的验证
function toSubmit(){
    var email = $("#email_input")
    var code = document.getElementById("code")
    if (email.value == ""){
        layer.alert("请先填写邮箱",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }else if(code.value == ""){
        layer.alert("请填写验证码",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }
    if(code.value.length < 7){
        layer.alert("验证码错误",{ icon: 2, title: "error", offset: "auto", skin: 'layui-layer-molv' })
        return false;
    }
    return true;
}

//发送邮箱按钮的出现
function send_email(value){
    var send = document.getElementById("send")
    var email = document.getElementById("email_input")
    var ePattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (sessionStorage.getItem("wait") == null){
        if (ePattern.test(value)){
           if (time.textContent == "0"){
               send.appendChild(button)
               email.style.top="-3px"
           }
        }else if (!ePattern.test(value) && send.children.namedItem("send_email")){
            if (time.textContent == "0"){
                send.removeChild(button)
                email.style.top="0"
            }
        }
    }else {
        time.textContent = sessionStorage.getItem("wait")
        myTime = setInterval("timing()",1000)
        send.appendChild(time)
    }

}


