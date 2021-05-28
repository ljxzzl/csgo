window.onload =( function () {
    //DrawTable(null);
    $.ajax({
            type: "get",
            url: "/getReportList", //res.data.users[i].userId
            dataType: "json",
            success: function (res) {
                console.log(res);
                var list = res.data.reports;
                console.log("test" + list);
                for (var i = 0; i < list.length; i++) {
                    $('#allReport').append(
                         " <tr>\n" +
                        "\n" +
                        "    <td class=\"center\">"+list[i].classId+"</td>\n" +
                        "    <td class=\"center\">"+list[i].className+"</td>\n" +
                        "    <td width=\"300\">\n" +
                        "     <div style=\"width:400px;height:50px;overflow:scroll;overflow-x:hidden;\">\n" +
                        "      \n" +list[i].classDetial+
                        "     </div>\n" +
                        "    </td>\n" +
                        "    <td class=\"center\">\n" +
                        "     <a href=\"reply_message.html\" class=\"inline-block\" title=\"回复\"><img src=\"images/icon_title.gif\"/></a>\n" +
                        "     <a class=\"inline-block\" title=\"移除\"><img src=\"images/icon_drop.gif\"/></a>\n" +
                        "    </td>\n" +
                        "   </tr>"
                    )
                }
            }
        }
    )
});


