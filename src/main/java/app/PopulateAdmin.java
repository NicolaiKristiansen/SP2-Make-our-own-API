package app;

import app.config.HibernateConfig;
import app.exceptions.EntityNotFoundException;
import app.security.SecurityDAO;
import app.security.SecurityRoutes.Role;

public class PopulateAdmin {

    public static void main(String[] args) throws EntityNotFoundException {
        SecurityDAO securityDAO = new SecurityDAO(HibernateConfig.getEntityManagerFactory());
        securityDAO.createUser("ADMIN", "1234");
        securityDAO.addUserRole("ADMIN", "Admin");
    }
}
