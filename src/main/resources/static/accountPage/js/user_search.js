$("#submit_5").click(function () {
    alert('查询用户');
    $.ajax({
        type: "post",
        url: "/user_search",
        data: {
            parm: $('#parm_1').val()
        },
        dataType: "json",
        success: function (res) {
            var list = res.data.queryList;
            console.log("usertest");
            $('#allUser').empty();
            for (var i = 0; i < list.length; i++) {
                $('#allUser').append("   <tr>\n" +
                    "    <td>\n" +
                    "     <input type=\"checkbox\"/>\n" +
                    "     <span class=\"middle\">"+list[i].userId+"</span>\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">"+list[i].userName+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userPassword+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userIphone+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userUrl+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userEmail+"</td>\n" +
                    "    <td class=\"center\">\n" +
                    "     <span>\n" +
                    "      <i>￥</i>\n" +
                    "      <b>"+list[i].userAccount+"</b>\n" +
                    "     </span>\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">\n" +
                    "    </td>\n" +
                    "    <td class=\"center\">"+list[i].userDetail+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userSteamId+"</td>\n" +
                    "    <td class=\"center\">"+list[i].userSteamKey+"</td>\n" +
                    "    <td class=\"center\">\n" +
                    "<a  href=\"edit_user.html?id=" +list[i].userId+"class=\"inline-block\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>"+
                    "     <a href=\"account.html\" class=\"inline-block\" title=\"资金管理\"><img src=\"images/icon_account.gif\"/></a>\n" +
                    "     <a class=\"inline-block\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>\n" +
                    "    </td>\n" +
                    "   </tr>\n"
                )
            }

        }
    })});
