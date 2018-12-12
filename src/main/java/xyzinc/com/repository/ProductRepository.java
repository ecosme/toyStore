package xyzinc.com.repository;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyzinc.com.model.Product;

import java.util.List;


public interface ProductRepository extends MongoRepository<Product, String> {


    Product findByProdName(String prodName);

    //@Override
    //List<Product> findAll(Example<Product> example);


    List<Product> findByNameStartingWith(String stingStart);


    @Override
    List<Product> findAll(Sort sort);

    @Override
    long count();

    @Override
    void delete(Product product);

    @Override
    void deleteAll();

    List<Product> findByProdDesc(String prodDesc);
}

