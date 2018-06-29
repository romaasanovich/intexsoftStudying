package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Order;
import com.intexsoft.bookservice.dao.entity.User;

public interface OrderService {

    void addOrder(Order order, User user);

    Order getByUser(User user);
}
