package bstorm.akimts.demoee.service;

import bstorm.akimts.demoee.exception.ProductNotFoundException;
import bstorm.akimts.demoee.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // region SINGLETON
    private static ProductService instance;
    public static ProductService getInstance(){
        System.out.println("recup de l'instance du service");
        return instance == null ? instance = new ProductService() : instance;
    }
    private ProductService() {}
    // endregion

    private final List<Product> list = new ArrayList<>();
    private int lastID;

    public List<Product> getAll(){
        return new ArrayList<>(list);
    }

    public Product getOne(int id){
        return list.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow( () -> new ProductNotFoundException(id) );
    }

    public int insert(Product toInsert){
        toInsert.setId( ++lastID );
        list.add(toInsert);
        return toInsert.getId();
    }

}
