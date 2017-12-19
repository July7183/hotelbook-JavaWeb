<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="js/layui/css/layui.css" media="all">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">酒店管理系统</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item" >
                <a href="./checkin/checkMain.jsp" target="content">
                    <i class="layui-icon" >&#xe63c; 入住管理</i>
                </a>
            </li>
            <li class="layui-nav-item" >
                <a href="./account/accountMain.jsp" target="content">
                    <i class="layui-icon" >&#xe642; 账单管理</i>
                </a>
            </li>
        </ul>
    </div>
</div>

<script src="js/layui/layui.js"></script>
<script src="js/jquery.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function() {});
</script>
</body>

</html>