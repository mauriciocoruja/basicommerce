package com.uniesquina.basicommerce.service;

import com.uniesquina.basicommerce.entities.Product;
import com.uniesquina.basicommerce.entities.User;
import com.uniesquina.basicommerce.repositories.ProductRepository;
import com.uniesquina.basicommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        try {
            Product entity = productRepository.getById(id);
            updateData(entity, product);
            return productRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setImgUrl(product.getImgUrl());
        entity.setPrice(product.getPrice());
    }
}
