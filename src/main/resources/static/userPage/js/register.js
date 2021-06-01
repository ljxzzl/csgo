
var oDiv=document.getElementById("userregist");
alert("kaishi");
oDiv.onclick=function(){
    $.ajax({
        type: "post",
        url: "/register",
        data: {
           email: $('#email').val(),
            name: $('#name').val(),
            password:$('#password').val(),
             iphone:$('#iphone').val()
        },
        dataType: "json",
        async:false,
        success :function (res){
            console.log("res.code"+res.code);
            if(res.code==200)
            {


            }

            if ((res.status==500))
            {
                alert("账号密码错误");
                window.location.reload();
            }
        }


    });
};
