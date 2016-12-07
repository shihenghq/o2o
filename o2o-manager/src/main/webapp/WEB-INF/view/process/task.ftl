<#--模板列表-->
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
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>任务ID</th>
                            <th>任务名称</th>
                            <th>任务执行人</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as temp>
                        <tr>
                            <td>${temp.id}</td><td>${temp.name}</td><td>${temp.assignee}</td><td><a href="../process/complete?id=${temp.id}">完成</a> <a href="../process/graphics?taskId=${temp.id}">图形</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/res/js/jquery.min.js?v=2.1.4"></script>
<script src="/res/js/bootstrap.min.js?v=3.3.5"></script>
<script src="/res/js/plugins/dataTables/bootstrap-table.js"></script>
<script src="/res/js/plugins/dataTables/bootstrap-table-zh-CN.js"></script>

</body>

</html>
