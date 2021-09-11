package com.uniesquina.basicommerce.repositories;

import com.uniesquina.basicommerce.entities.OrderItem;
import com.uniesquina.basicommerce.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
