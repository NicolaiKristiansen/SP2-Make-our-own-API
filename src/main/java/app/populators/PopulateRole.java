package app.populators;

import app.config.HibernateConfig;
import app.exceptions.EntityNotFoundException;
import app.security.daos.SecurityDAO;

public class PopulateRole {


    public static void main(String[] args) throws EntityNotFoundException {
        SecurityDAO securityDAO = new SecurityDAO(HibernateConfig.getEntityManagerFactory());

        securityDAO.createRole("User");
        securityDAO.createRole("Anyone");
        securityDAO.createRole("Admin");

        securityDAO.createUser("ADMIN", "1234");
        securityDAO.addUserRole("ADMIN", "Admin");
    }





}
