package com.uniesquina.basicommerce.repositories;

import com.uniesquina.basicommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
