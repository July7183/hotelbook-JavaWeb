package inks.hb.login.dao;

class JdbcDAOFactory extends LoginDAOFactory {
    public LoginDao getLoginDao() {
        return new LoginDaoImpl();
    }
}