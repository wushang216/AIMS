
function textInput(){
    var textarea = document.getElementById("article_content_text")
    console.log(textarea.value.length)
}
var i = 0
function click_label(dom){
    if (dom.checked === true){
       i++
    }else if (dom.checked === false){
        i--
    }
    if (i > 4 && dom.checked === true){
        i--
        dom.checked = false
        return ;
    }
}
// function onsubmit(){
//     var article = $(".article")
//     for (let i = 1 ;i <= article.length;i++){
//         if (article[i].value !== ""){
//             console.log("空")
//         }
//     }
//     return true
// }
$(document).ready(function (){
    $("#upload").change(function (){
        var file = this.files[0]
        var reader = new FileReader()
        var suffix = file.name.substring(file.name.lastIndexOf('.') + 1)
        if (suffix === "txt"){
            alert(suffix)
            reader.readAsText(file)
            reader.onload = function (ev){
                $("#upload_point").text("已收到")
                $("#article_content_text").val(ev.target.result)
            }
        }else if (suffix === "docx"){
            // const admZip = require('')
        }else {
            alert("文件格式不对")
        }
    })
})
