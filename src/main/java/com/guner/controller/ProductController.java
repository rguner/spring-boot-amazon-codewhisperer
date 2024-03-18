package com.guner.controller;

import com.guner.entity.Product;
import com.guner.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping("/createRandomProducts")
    public ResponseEntity<String> createRandomProducts(){
        productService.createRandomProducts();
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedproduct = productService.createProduct(product);
        return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/products/1
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getProductByTitleAndPrice/{title}/{price}")
    public ResponseEntity<Product> getProductByTitleAndPrice(@PathVariable("title") String title,
                                                            @PathVariable("price") int price) {
        Product product = productService.getProductByTitleAndPrice(title, price);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // http://localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                           @RequestBody Product product){
        product.setId(productId);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PutMapping("/locked/{id}")
    // http://localhost:8080/api/products/1
    public ResponseEntity<Product> updateProductWithLock(@PathVariable("id") Long productId,
                                                 @RequestBody Product product){
        product.setId(productId);
        Product updatedProduct = productService.updateProductWithLock(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("product successfully deleted!", HttpStatus.OK);
    }

}
