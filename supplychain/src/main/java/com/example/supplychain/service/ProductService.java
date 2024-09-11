package com.example.supplychain.service;

import com.example.supplychain.entity.Product;
import com.example.supplychain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Tüm ürünleri getirmek için :
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ID ile ürün getirmek için :
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
    }

    // Yeni ürün oluşturmak için :
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Mevcut ürünü güncellemek için :
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    // Ürün silmek için:
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
