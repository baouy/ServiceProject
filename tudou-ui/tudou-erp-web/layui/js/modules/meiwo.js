/**
 项目JS主入口
 以依赖Layui的layer和form模块为例
 **/
layui.define(['layer', 'element', 'table', 'zjoin', 'ZJOINdropdown', 'ZJOINselect', 'ZJOINboxrefresh', 'ZJOINwidget', 'ZJOINsidebar', 'ZJOINlayout', 'ZJOINpushmenu', 'ZJOINtodoList', 'ZJOINtree', 'ZJOINtheme', 'cookie','BJUIcore'], function (exports) {
    var element = layui.element,
        $ = layui.jquery,
        form = layui.form,
        layer = layui.layer;
    
    layer.config({
        extend: 'zjoin-skin/skin.css', //加载新皮肤
        skin: 'zjoin-skin' //一旦设定，所有弹层风格都采用此主题。
    })

    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        complete: function (XMLHttpRequest, textStatus) {
            //通过XMLHttpRequest取得响应结果
            var res = XMLHttpRequest.responseText;
            try {
                var jsonData = JSON.parse(res);
                if (jsonData.code == 10000) {
                    //自定页
                    layer.open({
                        title:'用户登录',
                        type: 5,
                        closeBtn: 1, //不显示关闭按钮
                        area: ['500px', '300px'],
                        anim: 5,
                        shadeClose: true, //开启遮罩关闭
                        content:'/resources/erp/logind.html'
                        , btn: ['登录', '取消']
                        , yes: function (index, layero) {
                            //按钮【按钮一】的回调
                        }
                        , btn2: function (index, layero) {
                            window.location.href = 'login.html';
                            //return false 开启该代码可禁止点击该按钮关闭
                        }
                        , cancel: function () {
                            window.location.href = 'login.html';
                            //return false 开启该代码可禁止点击该按钮关闭
                        }
                    });
                }
            } catch (e) {
            }
        }
    });
    initrole();
    element.init();
    function initrole() {
        user_data = new Array();
        $.ajax({
            url: '/manage/menu',
            type: 'get',
            success: function (d) {
                var $menuBar = $("#erp-menu");
                if (d.code == 1) {
                    //系统菜单
                    var $selectMenu = $("#top-erp-menu-bar");
                    for (var data of d.data.upmsSystems) {
                        $.cookie(data.name, data.basepath, {path: '/'});
                        var html ='<div class="top-menu-bar '
                        switch (data.systemId){
                            case 1:
                                html +=' zjoin-this" data-id='+data.systemId+'><i class="layui-icon">&#xe8b8;';
                                break;
                            case 2:
                                html +='" data-id='+data.systemId+'><i class="layui-icon">&#xe705;';
                                break;
                            case 3:
                                html +='" data-id='+data.systemId+'><i class="layui-icon">&#xeb12;';
                                break;
                        }
                        if(!layui.device().ios && !layui.device().android){
                            html +='</i><span>&nbsp;'+data.title+'</span></div>';
                        }else{
                            html +='</i></div>';
                        }
                        $selectMenu.append(html);

                    }
                    var treeviewData = [], treeviewMenuData = [], treeviewOpeData = [];
                    //菜单
                    for (var data of d.data.upmsPermissions) {
                        if (data.type == 1) {
                            treeviewData.push(data);
                        }
                        if (data.type == 2) {
                            treeviewMenuData.push(data)
                        }
                        if (data.type == 3) {
                            treeviewOpeData.push(data)
                        }
                    }
                    window.user_data = treeviewOpeData;
                    $(".top-menu-bar").bind('click',function () {
                        $(".top-menu-bar").removeClass('zjoin-this');
                        $(this).addClass('zjoin-this');
                        var pid = $(this).attr('data-id');
                        $menuBar.find('.treeview').remove();
                        $menuBar.find('.sidebar-menuli').remove();
                        //$menuBar.append('<li class="sidebar-menuli" data-url="/resources/erp/main.html" data-id="-1"><a href="#"><i class="layui-icon">&#xe907;</i>&nbsp;&nbsp;&nbsp;&nbsp;首页</a></li>');
                        for (var data of treeviewData) {
                            if (data.systemId == pid) {
                                $menuBar.append('<li class="treeview treeview-' + data.systemId + '" ><a href="#"><i class="fa fa-bars"></i><span>' + data.name + '</span><span class="pull-right-container"></span> </a><ul class="treeview-menu" id="treeview-menu-' + data.permissionId + '"> </ul></li>');
                            }
                        }
                        for (var data of treeviewMenuData) {
                            if (data.systemId == pid) {
                                $("#treeview-menu-" + data.pid).append('<li class="sidebar-menuli" data-url="' + data.uri + '" data-id="' + data.permissionId + '"><a href="#"><i class="fa fa-circle-o"></i>' + data.name + '</a></li>');
                            }
                        }
                        $menuBar.find('.treeview :eq(0)').parent('li').addClass('menu-open active ');
                    });
                    $(".top-menu-bar:eq(0)").click();

                }

            }
        });
    }

    var active = {
        tabAdd: function (elem) {
            //新增一个Tab项
            element.tabAdd2('admin-tab', {
                title: elem.text()
                , content: elem.attr('data-url')
                , id: elem.attr('data-id') //实际使用一般是规定好的id，这里以时间戳模拟下
            })
        }
    };
    function addMainPage() {
        element.tabAdd2('admin-tab', {
            title: '主页'
            , content: '/resources/erp/main.html'
            , id: -1 //实际使用一般是规定好的id，这里以时间戳模拟下
        })
        element.tabChange('admin-tab', -1);
    }
    addMainPage();

    $('body').delegate('.sidebar-menuli', 'click', function () {
        $('.treeview-menu li').removeClass('active')
        $('.sidebar-menuli').removeClass('active')
        $(this).addClass('active')
        $('.treeview').removeClass('active')
        $(this).parents('li').addClass('active')
        var id = $(this).attr('data-id');
        if ($(".layui-tab-title li[lay-id=" + id + "]").length > 0) {
            element.tabChange('admin-tab', id);
        } else {
            active['tabAdd'].call($(this), $(this));
            element.tabChange('admin-tab', id);
        }
    });
    var h = window.innerHeight;
    h = h - 31 - 40 - 50
    $(".layui-tab-content").css("height", h + 'px');
    $("#user-flowername").text($.cookie("flowerName"));
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
                    layer.msg("退出失败", {icon: 5})
                }
            }
        });
    });
    var types = new Array();
    window.types = types;

    $(window).resize(function() {
        BJUI.initLayout()
        setTimeout(function() {$(this).trigger(BJUI.eventType.resizeGrid)}, 30)
    })
    exports('meiwo', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});

