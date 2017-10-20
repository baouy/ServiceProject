layui.define(['layer', 'form', 'ZJOINS'], function (exports) {
    var layer = layui.layer,
        $ = layui.jquery,
        ZJOIN = layui.ZJOINS,
        ELEM = '.zjoin-upload',

        ZJOIN_default = {},
        Zjoin = function (options) {
            var that = this;
            ZJOIN_default = that.config = options || {};
            return that;
        };



    //全局设置
    Zjoin.prototype.set = function (options) {
        var that = this;
        $.extend(true, that.config, options);
        return that;
    };
    var upload = function () {
        layer.open({
            type: 1,
            id: 'fly-jie-upload',
            title: '插入图片',
            shade: true,
            area: '300px',
            skin: 'layui-layer-border',
            content: ['<div id="container" class="layui-form layui-form-pane" style="margin: 20px;"><p><div id="pickfiles" class="layui-btn" style="width:100%;padding:0!important"><div id="upload-progress" style="width:100%;height:100%;">上传文件</div></div></p></div>'].join(''),
            success: function (layero, index) {
                $.ajax({
                    type: "POST",
                    url: "/api/uptoken/",
                    dataType: "json",
                    success: function (data) {
                        if (data.code != 0) return layer.close(index), layer.msg('无效token', {
                            icon: 5
                        });
                        $("#upload-progress").css({
                            "background": "url(/layui/images/loading.png) no-repeat",
                            "background-size": "0% 100%"
                        });
                        var uploader = Qiniu.uploader({
                            runtimes: 'html5,flash,html4',
                            browse_button: 'pickfiles',
                            uptoken_url: '/api/uptoken/',
                            uptoken: data.value,
                            unique_names: false,
                            save_key: false,
                            domain: ZJOIN.domain,
                            get_new_uptoken: false,
                            container: 'container',
                            max_file_size: '1mb',
                            max_retries: 3,
                            dragdrop: !0,
                            drop_element: 'container',
                            chunk_size: '1mb',
                            filters: {
                                mime_types: [{
                                    title: "Image files",
                                    extensions: "jpg,gif,png,jpeg"
                                }]
                            },
                            auto_start: !0,
                            init: {
                                'FilesAdded': function (up, files) {
                                    $("#upload-progress").text("上传中......");
                                    plupload.each(files, function (file) {
                                    });
                                },
                                'BeforeUpload': function (up, file) {
                                },
                                'UploadProgress': function (up, file) {
                                    $("#upload-progress").css({
                                        "background-size": up.total.percent + "% 100%"
                                    })

                                },
                                'FileUploaded': function (up, file, info) {
                                    var z = JSON.parse(info.response);
                                    var img_domain = ZJOIN.domain;
                                    if (ZJOIN_default.image)ZJOIN_default.image.attr("src", img_domain + z.key);
                                    if (ZJOIN_default.input)ZJOIN_default.input.val(img_domain + z.key);

                                },
                                'Error': function (up, err, errTip) {
                                    layer.msg('上传失败', {
                                        icon: 5
                                    })
                                },
                                'UploadComplete': function (data) {
                                    $("#upload-progress").text("上传文件");
                                    layer.close(index);

                                },
                                'Key': function (up, file) {
                                    //var key = "";
                                    //return key
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    var icon = function () {
        var $this = $(this)
        var $div = $('<div id="icons"  style="width: 300px;height:200px;position: fixed;background-color: #ffffff;display: none"></div>');
        var $ul = $('<ul></ul>');
        //新增
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" icon-data="dgx1002;" title="刷新">&#x1002;</i></li>')
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="刷新">&#xe5d5;</i></li>')
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe145;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加组">&#xe7f0;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加人">&#xe7fe;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe99d;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe147;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe3ba;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe567;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe854;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="添加">&#xe608;</i></li>');

        //删除
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="关闭">&#xe5cd;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="取消">&#xe5c9;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="删除">&#xe65f;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="删减">&#xe99e;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="删减">&#xe15b;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="删减">&#xe15d;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="错误">&#xe000;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="错误">&#xe001;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="更新">&#xe923;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="编辑">&#xe650;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="修改">&#xe254;</i></li>');

        //勾选
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="勾选">&#xe5ca;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="勾选">&#xe834;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="勾选">&#xe86c;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="单选">&#xe837;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="勾选">&#xe99f;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="对勾">&#xea3a;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="单选">&#xea7f;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="标记">&#xea3b;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="空选">&#xea7d;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="空选">&#xea80;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="校验">&#xe8e8;</i></li>');

        //文件
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="图片文件">&#xe951;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="音乐文件">&#xe952;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="播放">&#xe953;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="视频文件">&#xe954;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="压缩文件">&#xe955;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="复制">&#xe956;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="粘贴">&#xe957;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="跟踪">&#xe958;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="文件夹">&#xe959;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="文件夹">&#xe94b;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="图书">&#xe949;</i></li>');

        //加载
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="加载">&#xe9a6;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="加载">&#xe9a4;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="加载">&#xe9a3;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="加载">&#xe9ac;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="撤销">&#xe991;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="欢迎">&#xe992;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="回应">&#xe994;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="前进">&#xe993;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="下载">&#xe98a;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="上传">&#xe98b;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="搜索">&#xe9b0;</i></li>');

        //菜单
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="菜单">&#xe9e7;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="菜单">&#xe9e8;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="菜单">&#xe9e9;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="菜单">&#xe9ea;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe9e4;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe9e5;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe9e3;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="树图">&#xe9e6;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe065;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe05f;</i></li>');
        $ul.append('<li class="zjoin-icon-li"><i class="layui-icon skin-color" title="列表">&#xe8ab;</i></li>');
        $ul.appendTo($div);
        $div.css({top:$this.offset().top,left:$this.offset().left})
        $this.after($div)
        $div.show()
        $div.on('click','ul li i',function () {
            console.log($(this))
            debugger
            $this.val($(this).text())
        });
    }
    var dom = $(document);
    dom.on('click', ELEM, upload);
    dom.on('click', '.zjoin-icon-pick', icon);
    Zjoin.prototype.timetrans = function (date) {
        var date = new Date(date);//如果date为13位不需要乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
        var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
        var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
        return Y + M + D + h + m + s;
    }

    window.zjoin = new Zjoin();
    exports('zjoin',new Zjoin()); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
}); 