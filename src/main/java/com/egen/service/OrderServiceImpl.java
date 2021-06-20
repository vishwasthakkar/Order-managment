package com.egen.service;

import com.egen.model.Order;
import com.egen.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class OrderServiceImpl {

  @Autowired
  OrderRepository repository;

  List<Order> getAllOrders(){
    return repository.
  }

}
