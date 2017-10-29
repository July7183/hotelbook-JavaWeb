package inks.hb.login.dao;

public abstract class LoginDAOFactory {

    private static LoginDAOFactory factory = new JdbcDAOFactory();

    public static LoginDAOFactory instance() {
        return factory;
    }

    public static LoginDAOFactory instance(String factoryName) {
        try {
            Class c = Class.forName(factoryName);
            if (factoryName.getClass() != c)
                factory = (LoginDAOFactory) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract LoginDao getLoginDao();
}

