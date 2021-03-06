<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H+ 后台主题UI框架 - 数据表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/res/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <!-- Data Tables -->
    <link href="/res/css/plugins/dataTables/bootstrap-table.css" rel="stylesheet">
    <link href="/res/css/animate.min.css" rel="stylesheet">
    <link href="/res/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link rel="stylesheet" href="/res/css/plugins/zTree/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="/res/css/plugins/toastr/toastr.min.css" type="text/css">
    <style type="text/css">
        .modal{
            overflow-y: auto;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本
                        <small>分类，查找</small>
                    </h5>
                </div>
                <div class="ibox-content">
                    <table
                           id="table"
                           data-toggle="table"
                           data-striped="true"
                           data-url="/sysUser/data"
                           data-height="630"
                           data-page-size="10"
                           <#--data-show-refresh="true"-->
                           data-pagination="true"
                           data-side-pagination="server"
                           data-pagination-loop="true"
                           data-pagination-pre-text="上一页"
                           data-pagination-next-text="下一页">
                        <thead>
                        <tr>
                            <th data-field="state" data-checkbox="true"></th>
                            <th data-field="code">编码</th>
                            <th data-field="account">账号</th>
                            <th data-field="name">名字</th>
                            <th data-field="phone">手机号</th>
                            <th data-field="email">邮箱</th>
                            <th data-field="operation" data-formatter="actionFormatter" data-events="actionEvents">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    用户授权
                </h4>
            </div>
            <div class="modal-body">
                <div  class="container" >
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary btn-danger" id="sourceSubmitBtn">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="/res/js/jquery.min.js?v=2.1.4"></script>
<script src="/res/js/bootstrap.min.js?v=3.3.5"></script>
<script src="/res/js/plugins/dataTables/bootstrap-table.js"></script>
<script src="/res/js/plugins/dataTables/bootstrap-table-zh-CN.js"></script>
<!--ztree-->
<script src="/res/js/plugins/ztree/jquery.ztree.all.min.js" type="text/javascript"></script>
<script src="/res/js/content.min.js" type="text/javascript"></script>
<script src="/res/js/plugins/toastr/toastr.min.js" type="text/javascript"></script>

<script src="/res/js/o2o.js" type="text/javascript"></script>

<script>
    function actionFormatter(value, row, index) {
        return '<a class="btn btn-sm btn-danger mod" >修改</a> ' + '<a class=" btn btn-sm btn-warning delete">删除</a>' + ' <a class=" btn btn-sm btn-warning" data-toggle="modal" data-target="#myModal">授权</a>';
    }
    //表格  - 操作 - 事件
    window.actionEvents = {
        'click .mod': function(e, value, row, index) {
            nodes();
            //修改操作
        },
        'click .delete' : function(e, value, row, index) {

        }
    }
</script>

<SCRIPT type="text/javascript">

    <!--
    var setting = {
        async: {
            enable: true,
            url:"/resource/data",
            autoParam:["id", "name","icon"]
        },
        check : {
            enable: true,
            chkboxType : {"Y": "ps", "N": "ps"},
            chkStyle : "checkbox"
        },
        data:{
            simpleData :{
                enable:true
            }
        }
    };
    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }

    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting);
        $("#sourceSubmitBtn").click(function(){
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getCheckedNodes(true);

            var resources = new Array();
            var resource ;
            for(var i=0;i<nodes.length;i++){
                resource = {};
                resource.code = nodes[i].id;
                resource.title = nodes[i].name;
                resource.icon = nodes[i].icon;
                resource.parent_code = nodes[i].pId;
                resources.push(resource);
            }
            $.ajax({
                type: "POST",
                url: "/resource/putData",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(resources),
                dataType: "json",
                success: function (response) {
                    if(response.success){
                        toastr['success'](response.msg, SUCCCESS_MSG);
                    }else{
                        toastr['error'](response.msg, ERROR_MSG);
                    }
                },
                error: function (response) {
                    toastr['error'](response.msg, ERROR_MSG);
                }
            });
            $('#myModal').modal('hide');
        });

    });
    //-->
</SCRIPT>
</body>

</html>
