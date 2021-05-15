window.onload =( function () {
    //DrawTable(null);
    console.log("device");
    $.ajax({
            type: "get",
            url: "/getIndentList", //res.data.users[i].userId
            dataType: "json",
            success: function (res) {
                console.log(res);
                var list = res.data.indent;
                console.log("test" + list);
                for (var i = 0; i < list.length; i++) {
                    $('#allIndent').append("   <tr>\n" +
                        "    <td>\n" +
                        "     <input type=\"checkbox\"/>\n" +
                        "     <span class=\"middle\">"+list[i].indentId+"</span>\n" +
                        "    </td>\n" +
                        "    <td class=\"center\">"+list[i].indentCreattime+"</td>\n" +
                        "    <td class=\"center\">"+list[i].indentOrnamentId+"</td>\n" +
                        "    <td class=\"center\">"+list[i].indentUser1Id+"</td>\n" +
                        "    <td class=\"center\">"+list[i].indentUser2Id+"</td>\n" +
                        "    <td class=\"center\">"+list[i].indentDetail+"</td>\n" +
                     "    <td class=\"center\">\n" +
                        "     <a href=\"order_detail.html\" class=\"inline-block\" title=\"查看订单\"><img src=\"images/icon_view.gif\"/></a>\n" +
                        "     <a class=\"inline-block\" title=\"删除订单\"><img src=\"images/icon_trash.gif\"/></a>"
                    )
                }
            }
        }
    )
});




