package com.uniesquina.basicommerce.repositories;

import com.uniesquina.basicommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
