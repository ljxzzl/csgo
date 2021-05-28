
$("#submit_1").click(function () {
    alert('封禁');
    $.ajax({
        type: "post",
        url: "/closeUser",
        data: {
             id: $('#id').val(),
            detail: $('#detail option:selected').val()

        },
        dataType: "json",
        success: function (res) {
            console.log(res.code==200);
            //alert(data);
            if (res.code == 200) {
                mdui.snackbar({
                    message: '注册成功！返回首页中...',
                    timeout: 3000,
                    onClosed: function () {
                        $(location).attr("href", "index.html");
                    }
                });
            } else {
                mdui.snackbar({
                    message: '注册失败！',
                    timeout: 3000,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            }
        }
    });




    });

