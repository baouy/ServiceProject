/**
 * Created by DavidWang on 2017/8/26.
 */
var dialog_src
function timetrans(date){
    var date = new Date(date);//如果date为13位不需要乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
    return Y+M+D+h+m+s;
}

function show_dialog(name,url,w,h) {
    $(this).dialog({
        title: name,
        url: url,
        width: w,
        height: h,
        mask: true
    });
}

function loading_s(n,v) {
    var content = 'bjui.ajaxStart'
    if (!v){
        content = 'bjui.ajaxStop'
    }
    n.trigger(content)
}

var gen_dic_java = [{'String':'String'},{'Long':'Long'},{'Integer':'Integer'},{'Double':'Double'},{'java.util.Date':'Date'},{'This':'ThisObj'},{'Custom':'Custom'}]

var gen_dic_select = [{'=':'='},{'!=':'!='},{'&gt;':'>'},{'&gt;=':'>='},{'&lt;':'<'},{'&lt;=':'<='},{'between':'between'},{'like':'like'},{'left_like':'left_like'},{'right_like':'right_like'}]

var gen_dic_string = [{'input':'单行文本'},{'textarea':'多行文本'},{'select':'下拉选项'},{'radiobox':'单选按钮'},{'checkbox':'复选框'},{'dateselect':'日期选择'},{'userselect':'人员选择'},{'officeselect':'部门选择'},{'treeselect':'树选择控件'},{'fileselect':'文件上传选择'}]

var gen_dic_table = [{'curd':'增删改查（单表）'},{'curd_many':'增删改查（一对多）'},{'dao':'仅持久层（MyBatisGenerator）'},{'html':'仅生成界面(Html)'},{'treeTable':'树结构表（一体）'},{'treeTableAndList':'树结构表（左树右表）'}]

var notify_type_dic = [{'1':'会议通告'},{'2':'奖惩通告'},{'3':'活动通知'}]

var user_data;
var types = new Array()
$(function () {
    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        complete: function (XMLHttpRequest, textStatus) {
            //通过XMLHttpRequest取得响应结果
            var res = XMLHttpRequest.responseText;
            try {
                var jsonData = JSON.parse(res);
                if (jsonData.code == 10000) {
                    BJUI.loadLogin()
                }
            } catch (e) {
            }
        }
    });

    jQuery.support.cors = true;
    BJUI.init({
        JSPATH: 'BJUI/',         //[可选]框架路径
        PLUGINPATH: 'BJUI/plugins/', //[可选]插件路径
        loginInfo: {url: 'logind.html', title: '账号失效请重新登录', width: 400, height: 200}, // 会话超时后弹出登录对话框
        statusCode: {ok: 1, error: 500, timeout: 10000}, //[可选]
        ajaxTimeout: 100000, //[可选]全局Ajax请求超时时间(毫秒)
        pageInfo: {
            total: 'total',
            pageCurrent: 'pageCurrent',
            pageSize: 'pageSize',
            orderField: 'orderField',
            orderDirection: 'orderDirection'
        }, //[可选]分页参数
        alertMsg: {displayPosition: 'topcenter', displayMode: 'slide', alertTimeout: 3000}, //[可选]信息提示的显示位置，显隐方式，及[info/correct]方式时自动关闭延时(毫秒)
        keys: {statusCode: 'code', message: 'message'}, //[可选]
        ui: {
            windowWidth: 0, //框架显示宽度，0=100%宽，> 600为则居中显示
            showSlidebar: true, //[可选]左侧导航栏锁定/隐藏
            clientPaging: true, //[可选]是否在客户端响应分页及排序参数
            overwriteHomeTab: false //[可选]当打开一个未定义id的navtab时，是否可以覆盖主navtab(我的主页)
        },
        debug: false,    // [可选]调试模式 [true|false，默认false]
        theme: 'green' // 若有Cookie['bjui_theme'],优先选择Cookie['bjui_theme']。皮肤[五种皮肤:default, orange, purple, blue, red, green]
    });
    var saveSeconds = 0;
    //时钟
    var today = new Date(), time = today.getTime();
    $('#bjui-date').html(today.formatDate('yyyy/MM/dd'));
    setInterval(function () {
        today = new Date(today.setSeconds(today.getSeconds() + 1));
        $('#bjui-clock').html('   ' + today.formatDate('HH:mm:ss'));
    }, 1000);
    var intDiff = parseInt(1500);//倒计时总秒数量 25分钟
    function customer_timer(intDiff) {
        window.setInterval(function () {
            var day, hour, minute, second;//时间默认值
            if (intDiff >= 0) {
                day = Math.floor(intDiff / (60 * 60 * 24));
                hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                if (minute == 0 && second == 0) {
                    //30分钟后继续更新token
                } else {
                    $('#day_show').html(day + "天");
                    $('#hour_show').html('<s id="h"></s>' + hour + '时');
                    $('#minute_show').html('<s></s>' + minute + '分');
                    $('#second_show').html('<s></s>' + second + '秒');
                    localStorage.setItem("timeNmu", intDiff);
                }
                intDiff--;
            }
        }, 1000);
    }



    var timeStorage = localStorage.getItem("timeNmu");
    if (timeStorage != null) { //刷新时
        customer_timer(timeStorage);
    } else { //第一次进入页面
        customer_timer(intDiff);
    }

    $("#customer_timeout").click(function () {
        //退出登录
        $.ajax({
            url: '/sso/logout',
            type: 'get',
            success: function (d) {
                if (d.code == 1) {
                    window.location.href = 'login.html';
                    localStorage.removeItem("timeNmu");
                } else {
                    $(this).alertmsg('warn', "退出失败");
                }
            }
        });
    });

    $("#customer_fllowName").text("欢迎您，" + $.cookie("flowerName") + "!");

    initrole();
    function initrole() {
        user_data = new Array();
        $.ajax({
            url: '/manage/menu',
            type: 'get',
            success: function (d) {
                var $menuBar = $("#bjui-hnav-navbar");
                if (d.code == 1) {
                    //系统菜单
                    for (var data of d.data.upmsSystems) {
                        $.cookie(data.name, data.basepath, {path: '/'});
                        $menuBar.append('<li class=""  id ="top_menu_' + data.systemId + '" ><a href="javascript:;" class="fa fa-first-order" data-toggle="slidebar"> ' + data.title + ' </a>');
                    }

                    //菜单
                    for (var data of d.data.upmsPermissions) {
                        if (data.type == 1) {
                            $("#top_menu_" + data.systemId).append('<div class="items hide"><ul id="menu_' + data.permissionId + '"class="menu-items" data-faicon="list" data-tit="' + data.name + '"></ul></div>')
                        }
                        if (data.type == 3){
                            user_data.push(data)
                        }
                    }

                    //子项
                    for (var data of d.data.upmsPermissions) {
                        if (data.type == 2) {
                            var _thisMenu = '<li><a href="' + data.uri + '" data-toggle="navtab" data-options="{id:\'form-input_' + data.permissionId + '\', faicon:\'list-ul\'}">' + data.name + '</a></li>';
                            $("#menu_" + data.pid).append(_thisMenu);
                        }
                    }

                    //删除
                    for (var data of d.data.upmsSystems) {
                        if ($('#top_menu_'+data.systemId).find('div').length == 0){
                            $('#top_menu_'+data.systemId).remove()
                        }
                    }

                    $menuBar.find('li :eq(1)').click();
                }

            }
        });
    }
})
