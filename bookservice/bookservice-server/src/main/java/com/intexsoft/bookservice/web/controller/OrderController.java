package com.intexsoft.bookservice.web.controller;


import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.service.api.OrderService;
import com.intexsoft.bookservice.service.api.UserService;
import com.intexsoft.bookservice.web.dto.entity.OrderDto;
import com.intexsoft.bookservice.web.dto.mapper.OrderDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDtoMapper orderDtoMapper;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/order")
    public void addOrder(@RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getByUsername(currentPrincipalName);
        orderService.addOrder(orderDtoMapper.toObject(orderDto), user);
    }
}
