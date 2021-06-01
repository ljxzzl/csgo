
var oDiv=document.getElementById("logintest");
var admin;
oDiv.onclick=function(){
    alert("开始");
    $.ajax({
        success :function (res){
            console.log("res.code"+res.code);


                admin=res.data.admin.adminAccount;
                window.location.href = "http://localhost:8080/accountPage/index.html";
                window.onload=( function (){document.getElementById('root_1').innerText="span的文本";});


        }


    });
};

