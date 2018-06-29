package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Order;
import com.intexsoft.bookservice.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query
    Order getByUser(User user);
}
