$("#submit_6").click(function () {
    alert('查询商品');
    $.ajax({
        type: "post",
        url: "/ornament_search",
        data: {
            test: $('#p2').val()
        },
        dataType: "json",
        success: function (res) {
            var list = res.data.oList;
            console.log("oornamenttest");
            $('#allOrnament').empty();
            for (var i = 0; i < list.length; i++) {
                $('#allOrnament').append("<tr>\n" +
                    "    <td>\n" +
                    "     <input type=\"checkbox\"/>\n" +
                    "     <span class=\"middle\">"+list[i].ornamentId+"</span>\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentName+"</td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentClass+"</td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentImage+"</td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentStatus+"</td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentCount+"</td>\n" +
                    "    <td class=\"center\">\n" +
                    "     <span>\n" +
                    "      <i>￥</i>\n" +
                    "      <b>"+list[i].ornamentPrice+"</b>\n" +
                    "     </span>\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">"+list[i].ornamentDetail+"</td>\n" +
                    "    <td class=\"center\">\n" +
                    "     <a href=\"edit_product.html\" class=\"inline-block\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>\n" +
                    "     <a href=\"account.html\" class=\"inline-block\" title=\"资金管理\"><img src=\"images/icon_account.gif\"/></a>\n" +
                    "     <a class=\"inline-block\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>\n" +
                    "    </td>\n" +
                    "   </tr>\n"
                )
            }
        }
    })});
