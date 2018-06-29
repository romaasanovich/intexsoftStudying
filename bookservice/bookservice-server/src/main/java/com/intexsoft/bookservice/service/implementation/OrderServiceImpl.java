package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Order;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.entity.enums.OrderStatus;
import com.intexsoft.bookservice.dao.repository.OrderRepository;
import com.intexsoft.bookservice.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(Order order, User user) {
        order.setOrderStatus(OrderStatus.CHECK);
        order.setOrderTime(LocalDateTime.now());
        order.setUser(user);
        orderRepository.save(order);
    }

    @Override
    public Order getByUser(User user) {
        return orderRepository.getByUser(user);
    }
}
