package inks.hb.login.service;


import inks.hb.login.pojo.Login;

import java.sql.SQLException;

public interface LoginService {

    int queryByName(String name,String pwd) throws SQLException;

}