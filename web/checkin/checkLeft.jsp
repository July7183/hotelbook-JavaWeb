<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
</head>

<body>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree">
            <li class="layui-nav-item">
                <a href="CheckInAdd.jsp" target="check">登记入住</a>
            </li>
            <li class="layui-nav-item">
                <a href="CheckinTable.jsp" target="check">入住管理</a>
            </li>
        </ul>
    </div>
</div>
<script src="../js/layui/layui.js"></script>
<script src="../js/jquery.js"></script>
<script>
    layui.use('element', function() {});
</script>
</body>

</html>