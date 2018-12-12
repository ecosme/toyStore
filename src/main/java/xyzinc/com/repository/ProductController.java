package xyzinc.com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.web.bind.annotation.*;
import xyzinc.com.model.Product;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method= RequestMethod.GET, value="/products")
    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }


    @RequestMapping(method=RequestMethod.GET, value="/producta-z/byPrice")
    public Iterable<Product> getByPrice(){

        return productRepository.findAll(Sort.by("prodPrice"));
    }

    //Sorted Product List
    @RequestMapping(method= RequestMethod.GET, value="/producta-z")
    public Iterable<Product> getProductsOrdered(){

        return productRepository.findAll(Sort.by("prodDesc"));
    }


    /*
    @RequestMapping(method=RequestMethod.GET, value="/products/priceMax/{price}")
    public Iterable<Product> getProductsByPriceMaximum(@PathVariable Double price){
        Query searchPriceQuery = new Query(Criteria.where("prodPrice").lte(price));
        searchPriceQuery.with(PageRequest.of(0, 10, Sort.DEFAULT_DIRECTION));

        Product prod = new Product();
        prod.setProdPrice(price);


        ExampleMatcher exMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withMatcher("prodPrice", )


        return productRepository.findAll(searchPriceQuery);
    }
*/




    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String save(@RequestBody Product product){
        productRepository.save(product);

        return product.getId();
    }

    //fix it
    @RequestMapping(method=RequestMethod.GET, value="/products/prodName/{prodName}")
    public Product getProductsByProdName(@PathVariable String prodName){
        return productRepository.findByProdName(prodName);
    }

    @RequestMapping(method=RequestMethod.GET, value="/products/{id]")
    public Optional<Product> getProductById(@PathVariable String id){
        return productRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product){
        Optional<Product> prodt = productRepository.findById(id);
        Product prod = prodt.get();
        if (product.getProdName() != null){
            prod.setProdName(product.getProdName());
        }
        if (product.getProdDesc() != null){
            prod.setProdDesc(product.getProdDesc());
        }
        if (product.getProdPrice() != null){
            prod.setProdPrice(product.getProdPrice());
        }

        return prod;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public String delete(@PathVariable String id){

        Optional<Product> prod = productRepository.findById(id);
        Product product = prod.get();
        productRepository.delete(product);

        return "product deleted";
    }
}
