<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H+ 后台主题UI框架 - 数据表格</title>
    <link href="/res/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/res/css/animate.min.css" rel="stylesheet">
    <link href="/res/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link rel="stylesheet" href="/res/css/plugins/zTree/zTreeStyle.css" type="text/css">
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
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/res/js/jquery.min.js?v=2.1.4"></script>
<script src="/res/js/bootstrap.min.js?v=3.3.5"></script>
<!--ztree-->
<script src="/res/js/plugins/ztree/jquery.ztree.all.min.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">
    <!--
    var setting = {
        async: {
            enable: true,
            url:"/resource/data",
            autoParam:["id", "name","icon"]
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
    });
    //-->
</SCRIPT>
</body>

</html>
