<%@ page contentType="text/html;charset=UTF-8"  %>
<jsp:useBean id="Login" scope="request" class="inks.hb.login.pojo.Login">
    <jsp:setProperty name="Login" property="loginName" />
    <jsp:setProperty name="Login" property="loginPwd" />
</jsp:useBean>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='img/windows.ico'>
    <link rel="stylesheet" type="text/css" href="css/register-login.css">
</head>

<body>

<div id="box"></div>

<!--主栏-->
<div class="cent-box">
    <!--标题-->
    <div class="cent-box-header">
        <h1 class="main-title">HotelBook</h1>
        <h2 class="sub-title">酒店管理系统</h2>
    </div>

    <div class="cont-main clearfix">

        <!--登录区域开始-->
        <form name="Loginform" id="Loginform" method="post" action="checkLogin.jsp" class="login form">
            <!--文本输入框-->
            <div class="group">
                <!--用户名输入框-->
                <div class="group-ipt loginName">
                    <input type="text" name="loginName" id="loginName" class="ipt" placeholder="输入您的用户名" required>
                </div>
                <!--密码输入框-->
                <div class="group-ipt loginPwd">
                    <input type="password" name="loginPwd" id="loginPwd" class="ipt" placeholder="输入您的登录密码" required>
                </div>
            </div>
            <!--登录按钮-->
            <div class="button" id="btnLogin">
                <button type="submit" class="login-btn register-btn button" id="embed-submit">登录</button>
            </div>
        </form>
        <!--登录区域结束-->
        <!--尾注-->
        <div class="remember clearfix">
            <label class="remember-me"><a href="#">获取帮助</a></label>
            <label class="forgot-password"><a href="#">忘记密码？</a></label>
        </div>
    </div>
</div>

<!--脚注-->
<div class="footer">
    <p>© 2017 <a href="#">HotelBook System</a></p>
</div>

<!--导入LW Background-->
<script type="text/javascript" src='js/particles.js'></script>
<script type="text/javascript" src='js/background.js'></script>

</body>
</html>
