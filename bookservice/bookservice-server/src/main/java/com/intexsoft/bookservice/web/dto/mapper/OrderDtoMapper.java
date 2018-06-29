package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Order;
import com.intexsoft.bookservice.dao.entity.aentity.AbstractEntity;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.web.dto.entity.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderDtoMapper extends AbstractDtoMapper<Order, OrderDto> {

    @Autowired
    BookService bookService;

    @Override
    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setBookIds(order.getBooks().stream().map(this::getEntityId).collect(Collectors.toList()));
        orderDto.setUserId(order.getUser().getId());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setOrderTime(order.getOrderTime());
        orderDto.setOrderStatus(order.getOrderStatus());
        return orderDto;
    }

    private Integer getEntityId(AbstractEntity abstractEntity) {
        return abstractEntity.getId();
    }

    public Order toObject(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderStatus(orderDto.getOrderStatus());
        order.setOrderTime(orderDto.getOrderTime());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setBooks(orderDto.getBookIds().stream().map(this::getById).collect(Collectors.toList()));
        return order;
    }

    private Book getById(Integer id) {
        return bookService.getBookById(id);
    }

}
