
var oDiv=document.getElementById("userlogin");

oDiv.onclick=function(){
    alert("dneg路");
    $.ajax({
        type: "post",
        url: "/login",
        data: {
            email: $('#useremail').val(),
            password: $('#userpassword').val()
        },
        dataType: "json",
         async:false,
        success :function (res){
            alert("testlogin");
            var obj = res.data;
            var infostr = JSON.stringify(obj);//转换json
            sessionStorage.obj = infostr;

        }


    });
};








