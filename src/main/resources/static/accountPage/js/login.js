
var oDiv=document.getElementById("logintest");
var admin;
oDiv.onclick=function(){
    alert("开始");
    $.ajax({
        type: "post",
        url: "/admin_login",
        data: {
            account: $('#account').val(),
            password: $('#password').val()
        },
        dataType: "json",
        async:false,
        success :function (res){
         console.log("res.code"+res.code);
            if(res.code==200)
            {
                 admin=res.data.admin.adminAccount;
                window.location.href = "http://localhost:8080/accountPage/index.html";
                window.onload=( function (){document.getElementById('root_1').innerText="span的文本";});
            }

             if ((res.status==500))
            {
                alert("账号密码错误");
                window.location.reload();
            }
        }


    });
};

