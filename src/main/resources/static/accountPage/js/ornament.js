var oDiv=document.getElementById("ornament");

                    window.onload=( function () {
                        //DrawTable(null);
                        console.log("device");
                        $.ajax({
                            type: "get",
                            url: "/getOrnamentList", //res.data.users[i].userId
                            dataType: "json",
                            success: function (res) {
                                console.log(res);
                                var list = res.data.ornaments;
                                console.log("test" + list);
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
                        "    <td class=\"center\">"+list[i].ornamentDetail+"</td>\n" +
                        "    <td class=\"center\">\n" +
                        "     <a href=\"edit_product.html\" class=\"inline-block\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>\n" +
                        "     <a href=\"account.html\" class=\"inline-block\" title=\"资金管理\"><img src=\"images/icon_account.gif\"/></a>\n" +
                        "    </td>\n" +
                        "   </tr>\n"
                    )
                }
            }
        }
    )
});

