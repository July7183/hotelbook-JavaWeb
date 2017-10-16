package inks.hb.login.service;

import inks.hb.login.pojo.Login;

import java.sql.SQLException;

public interface LoginService {

    public Login queryByName(String name) throws SQLException;

}
