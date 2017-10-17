package inks.hb.login.dao;

import inks.hb.login.pojo.Login;

import java.sql.SQLException;

public class LoginQuery {

    public int loginQuery(Login login) throws SQLException {
        LoginDao loginDao = LoginDAOFactory.instance().getLoginDao();
        Login loginer = loginDao.queryByName(login.getLoginName());

        loginer.toString();

        if (loginer.getLoginAdmin() == -1)
            return -1;  //用户不存在

        if (login.getLoginPwd().equals(loginer.getLoginPwd()))
            return 1;   //登录成功
        else
            return 0;   //用户密码错误
    }
}