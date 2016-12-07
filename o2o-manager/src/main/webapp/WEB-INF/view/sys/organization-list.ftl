<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>荭琪枫商城-后台管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.4 -->
    <link href="/res/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/res/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link href="/res/css/skin-red.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="/res/css/zTreeStyle.css" type="text/css">
</head>
<body class="skin-red sidebar-mini">
<div class="wrapper">

    <#include "/comm/header.ftl" >

    <#include "/comm/aside.ftl" >

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-5">
                    <a href="mailbox.html" class="btn btn-primary btn-block margin-bottom">Back to Inbox</a>
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Folders</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul id="treeDemo" class="ztree"></ul>
                        </div><!-- /.box-body -->
                    </div><!-- /. box -->
                </div><!-- /.col -->
                <div class="col-md-7">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Compose New Message</h3>
                        </div><!-- /.box-header -->
                    </div><!-- /. box -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

<#include "/comm/footer.ftl" >

</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.1.4 -->
<script src="/res/js/jQuery-2.1.4.min.js" type="text/javascript"></script>
<!--ztree-->
<script src="/res/js/jquery.ztree.all.min.js" type="text/javascript"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="/res/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="/res/js/app.min.js" type="text/javascript"></script>

<SCRIPT type="text/javascript">
    <!--
    var setting = {
        async: {
            enable: true,
            url:"/organization/data",
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
