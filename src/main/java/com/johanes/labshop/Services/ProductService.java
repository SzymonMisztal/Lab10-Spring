package com.johanes.labshop.Services;

import com.johanes.labshop.Objects.Product;
import com.johanes.labshop.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

}
