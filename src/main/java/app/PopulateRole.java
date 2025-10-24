package app;

import app.config.HibernateConfig;
import app.security.SecurityDAO;
import jakarta.persistence.EntityManagerFactory;

public class PopulateRole {


    public static void main(String[] args) {
        SecurityDAO securityDAO = new SecurityDAO(HibernateConfig.getEntityManagerFactory());

        securityDAO.createRole("User");
        securityDAO.createRole("ANYONE");
        securityDAO.createRole("ADMIN");
    }




}
