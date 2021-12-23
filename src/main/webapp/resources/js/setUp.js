
var img_road ;
var url =  window.location.href
url = url.substring(url.lastIndexOf("/"),-1)
url = url.substring(url.lastIndexOf("/"),-1)
$(document).ready(function (){
    $("#avatar").change( function () {
        var file = this.files[0]
        var reader = new FileReader()
        var suffix = file.name.substring(file.name.lastIndexOf('.') + 1)
        if (suffix === "png"){
            $(".avatar").remove()
            reader.readAsDataURL(file)
            reader.onload = function (ev){
                var img = document.createElement("img")
                img.src = ev.target.result.toString()
                document.getElementById("avatar_label").appendChild(img)
                img.style.height = "75px"
                img.className = "avatar"
                img_road = img.src
            }
        }else {
            console.log("文件格式不对")
            $("#avatar").remove()
            var input = document.createElement("input")
            input.id = "头像"
            input.type = "file"
            input.name = "avatar"
            input.accept=".png,.jpg"
            input.hidden = true
            document.getElementById("avatar_td").appendChild(input)
        }
    })
})