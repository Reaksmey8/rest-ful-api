package co.istad.restfulapi.controller;

import co.istad.restfulapi.db.ProductDbConfig;
import co.istad.restfulapi.domain.Product;
import co.istad.restfulapi.dto.CreateProductRequest;
import co.istad.restfulapi.dto.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDbConfig productDbConfig;

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) String title
    ){
        return productDbConfig.selectAll(title);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Integer id){
        return productDbConfig.selectById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        productDbConfig.removeById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest productRequest){
        return productDbConfig.save(productRequest);
    }

    @PatchMapping("{id}")
    public Product updateById(
            @PathVariable Integer id,
            @RequestBody UpdateProductRequest updateProductRequest
            ){
        return productDbConfig.updateById(id, updateProductRequest);
    }

}
