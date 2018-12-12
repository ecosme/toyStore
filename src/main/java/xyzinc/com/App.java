package xyzinc.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import xyzinc.com.model.Product;
import xyzinc.com.repository.ProductRepository;

/**
 *
 *
 */

@SpringBootApplication
        //(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableAutoConfiguration
//@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
public class App implements CommandLineRunner
{
    @Autowired
    private ProductRepository productRepository;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        /*productRepository.deleteAll();

        Product prd01 = new Product("Cajita Feliz", "Cajita Feliz con premio", 12.22);
        productRepository.save(prd01);
        prd01 = new Product("Peluca", "Peluca colores", 33.22);
        productRepository.save(prd01);
        prd01 = new Product("Reloj", "Reloj digital analogico", 133.22);
        productRepository.save(prd01);
*/

    }



}
