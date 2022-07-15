package bstorm.akimts.demoee.service;

import bstorm.akimts.demoee.listeners.EMFWebListener;
import bstorm.akimts.demoee.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

//@Singleton
public class ProductService {

    // region SINGLETON
    private static ProductService instance;
    public static ProductService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new ProductService() : instance;
    }
    private ProductService() {
        manager = EMFWebListener.createEntityManager();
    }
    // endregion

    private final EntityManager manager;
    private final List<Product> list = new ArrayList<>();
    private int lastID;

    public List<Product> getAll(){
        List<Product> productList = manager.createNamedQuery("get_all", Product.class).getResultList();
        manager.clear();
        return productList;

    }

    public Product getOne(long id){
        Product p = manager.find(Product.class, id);
        manager.clear();
        return p;
    }

    public long insert(Product toInsert){
        manager.getTransaction().begin();

        toInsert.setId(0);
        manager.persist(toInsert);

        manager.getTransaction().commit();
        return toInsert.getId();
    }

    public void update(Product toUpdate) {
        manager.getTransaction().begin();
        manager.merge(toUpdate);
        manager.getTransaction().commit();
    }

    public void delete(long id){
        manager.getTransaction().begin();
        Query q = manager.createNamedQuery("remove_one");
        q.setParameter("id", id);
        q.executeUpdate();
        manager.getTransaction().commit();
    }

}
