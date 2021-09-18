package com.uniesquina.basicommerce.service;

import com.uniesquina.basicommerce.entities.Product;
import com.uniesquina.basicommerce.repositories.ProductRepository;
import com.uniesquina.basicommerce.service.exceptions.DatabaseException;
import com.uniesquina.basicommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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
        if (product.getName() != null){
            entity.setName(product.getName());
        }
        if (product.getDescription() != null) {
            entity.setDescription(product.getDescription());
        }
        if (product.getPrice() != null){
            entity.setPrice(product.getPrice());
        }
        if (product.getImgUrl() != null){
            entity.setImgUrl(product.getImgUrl());
        }
    }
}
