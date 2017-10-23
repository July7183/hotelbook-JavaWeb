<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<jsp:useBean id="Login" scope="request" class="inks.hb.login.pojo.Login">
    <jsp:setProperty name="Login" property="loginName" />
    <jsp:setProperty name="Login" property="loginPwd" />
</jsp:useBean>
<jsp:useBean id="checkLogin" class="inks.hb.login.service.LoginQuery"></jsp:useBean>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='img/windows.ico'>
</head>

<body>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>

<script>
    layui.use(['layer'], function(){
        var layer = layui.layer;
        $(document).ready(function () {
            <%
                int num = 0;
                try {
                        num = checkLogin.loginQuery(Login);
                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("alert('出现一些错误'); ");
                }
                switch (num){
                    case 0:
                        out.println("alert('用户密码错误'); ");
                        out.println("window.history.back(-1)");
                        break;
                    case 1:
                        out.println("layer.msg('登录成功', {");
                        out.println("   icon: 16");
                        out.println("   ,shade: 0.01");
                        out.println("});");
                        out.println("setTimeout(function() {");
                        out.println("    location.href = 'main.html';");
                        out.println("}, 1000);");
                        break;
                    default:
                        out.println("alert('用户不存在'); ");
                        out.println("window.history.back(-1)");
                }
            %>
        });
    });

</script>


</body>
</html>
