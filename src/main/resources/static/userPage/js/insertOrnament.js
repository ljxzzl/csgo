$("#checkstock").click(function (){
    var infostr = sessionStorage.obj;
    var obj = JSON.parse(infostr);

    $.ajax({
        type: "post",
        url: "/stock_ornament",
        data: {
            userid: obj.user.userId
        },
        dataType: "json",
        async:false,
        success :function (res){
           alert("已经入库");
        }});


})