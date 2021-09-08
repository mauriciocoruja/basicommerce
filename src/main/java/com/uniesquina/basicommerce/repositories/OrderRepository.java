package com.uniesquina.basicommerce.repositories;

import com.uniesquina.basicommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
