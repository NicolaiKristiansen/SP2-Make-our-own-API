package app.dao;

import app.dto.ReceiptDTO;
import app.entities.Basket;
import app.entities.Receipt;
import app.exceptions.ApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ReceiptDAO implements IDAO<Receipt, Integer> {
    EntityManagerFactory emf;

    public ReceiptDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Receipt create(Receipt receipt) {
        return null;
    }

    @Override
    public Receipt findById(Integer id) {
        return null;
    }

    @Override
    public Receipt update(Receipt receipt, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

/*
    public List<ReceiptDTO> getAllReceipt(){
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Receipt> query = em.createQuery("SELECT r FROM Receipt r", Receipt.class);
            List<Receipt>receipts = query.getResultList();

        return ReceiptDTO.toDTOlist(receipts);
        }
    }



    @Override
    public Receipt create(ReceiptDTO receiptDTO) {
        Receipt receipt = new Receipt(receiptDTO);
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(receipt);
            em.getTransaction().commit();
        }
        catch(ApiException e){
            throw new ApiException(e.getCode(), "Failed to save receipt to the database");
        }
        return receipt;
    }

    @Override
    public Receipt findById(int id) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Receipt foundReceipt = em.find(Receipt.class, id);
            em.getTransaction().commit();
            return foundReceipt;
        } catch(ApiException e){
            throw new ApiException(e.getCode(), "Failed to find receipt with id " + id);
        }

    }

    @Override
    public Receipt update(ReceiptDTO receiptDTO, Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Receipt updatedReceipt = em.find(Receipt.class, id);
            if(updatedReceipt != null){
                updatedReceipt.setTotalPrice(receiptDTO.getTotalPrice());
                em.merge(updatedReceipt);
                em.getTransaction().commit();
            }
return updatedReceipt;
        }
    }

    @Override
    public void delete(int id) {
    try(EntityManager em = emf.createEntityManager()){
    Receipt deletedReceipt = em.find(Receipt.class, id);
    em.getTransaction().begin();
    em.remove(deletedReceipt);
    em.getTransaction().commit();
    }catch(ApiException e){
        throw new ApiException(e.getCode(), "Failed to delete receipt with id " + id);
       }
    }

 */
}
