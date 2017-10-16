package com.inks.hb.login.dao;

import inks.hb.login.dao.LoginDao;
import inks.hb.login.dao.LoginDaoImpl;
import inks.hb.login.pojo.Login;
import org.junit.Test;

public class LoginDaoImplTest {

    private Login login = null;

    private LoginDao loginDao = new LoginDaoImpl();

    @Test
    public void queryByName() throws Exception {
        login = loginDao.queryByName("root");

        System.out.printf(login.toString());

        //login = new Login();
        //System.out.println(login.toString());

    }

}