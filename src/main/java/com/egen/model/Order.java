package com.egen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private String id;

    @Column(name = "order_status")
    private OrderStatus status;

    // TODO Foreign key
    private String customer_id;

    @Column(name = "subtotal")
    private Double subTotal;

    private Double tax;

    @Column(name = "shipping_charges")
    private Double shippingCharges;

    private Double total;

    @OneToMany
    private List<Item> itemsInCart;

    @OneToMany
    private List<Payment> paymentsList;

    @OneToOne
    private Address shippingAddress;

    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    public Order(String id){
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
