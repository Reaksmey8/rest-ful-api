package co.istad.restfulapi.db;

import co.istad.restfulapi.domain.Product;
import co.istad.restfulapi.dto.CreateProductRequest;
import co.istad.restfulapi.dto.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class ProductDbConfig {

    // inject dependency by constructor best
    private final List<Product> products;


    public ProductDbConfig (){
        products = new ArrayList<>();
        Random random = new Random();

        Product pro1 = new Product();
        pro1.setId(random.nextInt(999));
        pro1.setTitle("Coca");
        pro1.setPrice(BigDecimal.valueOf(2.93));
        pro1.setQty(20);
        pro1.setIsActive(true);

        Product pro2 = new Product();
        pro2.setId(random.nextInt(999));
        pro2.setTitle("Pepsi");
        pro2.setPrice(BigDecimal.valueOf(3.93));
        pro2.setQty(30);
        pro2.setIsActive(true);

        Product pro3 = new Product();
        pro3.setId(random.nextInt(999));
        pro3.setTitle("ABC");
        pro3.setPrice(BigDecimal.valueOf(3.93));
        pro3.setQty(30);
        pro3.setIsActive(true);

        products.addAll(List.of(pro1, pro2, pro3));
//        products.add(pro1);
//        products.add(pro2);
    }

    public List<Product> selectAll(String title){

        if (title == null){
            return products;
        }
        return products.stream()
                .filter(pro -> pro.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }


    public Product selectById(Integer id) {
        return products.stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void removeById(Integer id){
        products.removeIf(
                pro -> pro.getId().equals(id)
        );
    }

    public Product save(CreateProductRequest productRequest) {
        Product product = new Product();
        product.setId(new Random().nextInt(999));
        product.setTitle(productRequest.title());
        product.setPrice(productRequest.price());
        product.setQty(productRequest.qty());
        product.setIsActive(true);

        products.add(product);
        return product;
    }

    public Product updateById(Integer id, UpdateProductRequest updateProductRequest) {
        Product updatedProduct = selectById(id);

        if (updateProductRequest.title() != null){
            updatedProduct.setTitle(updateProductRequest.title());
        }
        if (updateProductRequest.price() != null){
            updatedProduct.setPrice(updateProductRequest.price());
        }
        if (updateProductRequest.qty() != null){
            updatedProduct.setQty(updateProductRequest.qty());
        }
        if (updateProductRequest.isActive() != null){
            updatedProduct.setIsActive(updateProductRequest.isActive());
        }

        return updatedProduct;
    }


}
