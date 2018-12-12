package xyzinc.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
    @Id
    private String id;
    private String prodName;
    private String prodDesc;
    private Double prodPrice;

    public Product() {
    }

    public Product(String prodName, String prodDesc, Double prodPrice) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
