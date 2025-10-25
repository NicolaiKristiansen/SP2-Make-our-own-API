package app.daos;

import jakarta.persistence.EntityManagerFactory;

public class ReceiptDAO {
    EntityManagerFactory emf;

    public ReceiptDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
