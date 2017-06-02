/**
 * Created by Administrator on 2017/5/20.
 */
// 来源
if (source_content == undefined){
    source_content = new Array();
    $.ajax({
        url: "/v1/other/getalltype?type=10",
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].enumname;
                    c = new Object();
                    c[b]= b;
                    source_content.push(c)
                }
            }
        }
    });
}
// 美客部门
if (mobilesalesdepname_content == undefined){
    mobilesalesdepname_content = new Array();
    $.ajax({
        url: '/v1/other/getorgdepdeatil?pid=40',
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                mobilesalesdepname_data = d.data;
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].org_name;
                    c = new Object();
                    c[b]= b;
                    mobilesalesdepname_content.push(c)
                }
            }
        }
    });
}
// 美客
if (mobilesales_content == undefined){
    mobilesales_content = new Array();
    $.ajax({
        url: '/v1/user/getdepcode_userlist?code=001002010',
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].flower_name;
                    c = new Object();
                    c[b]= b;
                    mobilesales_content.push(c)
                }
            }
        }
    });
}
// 销售部门
if (custsalesdepname_content == undefined){
    custsalesdepname_content = new Array();
    $.ajax({
        url: '/v1/other/getorgdepdeatil?pid=37',
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                custsalesdepname_data = d.data
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].org_name;
                    c = new Object();
                    c[b]= b;
                    custsalesdepname_content.push(c)
                }
            }
        }
    });
}
// 客户经理
if (custsales_content == undefined){
    custsales_content = new Array();
    $.ajax({
        url: '/v1/user/getdepcode_userlist?code=001002007',
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].flower_name;
                    c = new Object();
                    c[b]= b;
                    custsales_content.push(c)
                }
            }
        }
    });
}
// 设计师
if (designers_content == undefined){
    designers_content = new Array();
    $.ajax({
        url: '/v1/user/designer_distribution?depcode=001002007',
        dataType: 'json',
        async: false,
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function (d) {
            if (d.state == 200){
                var c
                for (var i = 0 ; i < d.data.length; i ++){
                    var b = d.data[i].flower_name;
                    c = new Object();
                    c[b]= b;
                    designers_content.push(c)
                }
            }
        }
    });
}