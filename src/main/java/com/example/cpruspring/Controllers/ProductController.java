package com.example.cpruspring.Controllers;

import com.example.cpruspring.model.Product;
import com.example.cpruspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return saved;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product productDetail = productRepository.findById(id).orElse(null);
        productDetail.setProductName(product.getProductName());
        productDetail.setCategory(product.getCategory());
        productDetail.setPrice(product.getPrice());
        Product response = productRepository.save(productDetail);
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);
    }

}
