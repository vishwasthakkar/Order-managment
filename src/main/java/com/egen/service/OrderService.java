package com.egen.service;

import com.egen.model.Items;
import com.egen.model.Order;
import com.egen.model.Payment;
import com.egen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepositoryImpl;

    @Autowired
    ItemsService itemsService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    AddressService addressService;

    public List<Order> getAllOrders(){
        List<Order> list = (List<Order>) orderRepositoryImpl.findAll();

        return list;
    }

    public Order getOrderById(long id){
        Optional<Order> existing = orderRepositoryImpl.findById(id);

        return existing.get();
    }

    public List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime){
        List<Order> orderList = orderRepositoryImpl.getAllOrdersWithInInterval(startTime,endTime);

        return orderList;
    }

    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip){
        List<Order> orderList = orderRepositoryImpl.findTop10OrdersWithHighestDollarAmountInZip(zip);

        return orderList;
    }

    @Transactional
    public Order placeOrder(Order order){

        //create items
        List<Items> item=order.getItems();
        for(Items it : item) {
            itemsService.create(it);
        }

        //create payment method
        List<Payment> paymentsList = order.getPayment();
        for(Payment paymnt : paymentsList) {
            paymentService.create(paymnt);
        }

        //create address
        addressService.create(order.getShippingAddress());

        Order existing = orderRepositoryImpl.save(order);

        return existing;
    }

    @Transactional
    public Order cancelOrder(long id){
        Order existing = orderRepositoryImpl.cancel(id);

        return existing;
    }

    @Transactional
    public Order updateOrder(Order order){

        //create items
        List<Items> item=order.getItems();
        for(Items it : item) {
            itemsService.update(it);
        }

        //create payment method
        List<Payment> paymentsList = order.getPayment();
        for(Payment paymnt : paymentsList) {
            paymentService.update(paymnt);
        }

        //create address
        addressService.update(order.getShippingAddress());

        Order existing = orderRepositoryImpl.save(order);

        return order;
    }
}
