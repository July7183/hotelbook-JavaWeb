<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel='Shortcut Icon' type='image/x-icon' href='/MAIN/img/windows.ico'>
    <link rel="stylesheet" type="text/css" href="/login/css/register-login.css">
</head>
<body>

<div id="box"></div>

<div class="cent-box">
    <div class="cent-box-header">
        <h1 class="main-title">HotelBook</h1>
        <h2 class="sub-title">酒店管理系统</h2>
    </div>

    <div class="cont-main clearfix">

        <form class="login form" action="/MAIN/main.html" method="post">
            <div class="group">
                <div class="group-ipt loginName">
                    <input type="text" name="loginName" id="loginName" class="ipt" placeholder="输入您的用户名" required>
                </div>
                <div class="group-ipt loginPwd">
                    <input type="password" name="loginPwd" id="loginPwd" class="ipt" placeholder="输入您的登录密码" required>
                </div>
            </div>

            <div class="button">
                <button type="submit" class="login-btn register-btn button" id="embed-submit">登录</button>
            </div>
        </form>

        <div class="remember clearfix">
            <label class="remember-me"><a href="#">获取帮助</a></label>
            <label class="forgot-password"><a href="#">忘记密码？</a></label>
        </div>
    </div>
</div>

<div class="footer">
    <p>© 2017 <a href="#">HotelBook System</a></p>
</div>

<script type="text/javascript" src='/login/js/particles.js'></script>
<script type="text/javascript" src='/login/js/background.js'></script>

</body>
</html>
