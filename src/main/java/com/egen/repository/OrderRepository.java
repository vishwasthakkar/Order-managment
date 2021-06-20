package com.egen.repository;

import com.egen.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderRepository extends JpaRepository<Order, String> {

  @Query("SELECT order from orders order")
  public List<Order> findAll();

}
