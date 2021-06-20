package com.egen.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

    @OneToOne(cascade = {CascadeType.ALL})
    private String customer_id;

    @Column(name = "subtotal")
    private Double subTotal;

    private Double tax;

    @Column(name = "shipping_charges")
    private Double shippingCharges;

    private Double total;

    @OneToMany
    private Set<OrderedItem> itemsInCart;

    @OneToMany
    private List<Payment> paymentsList;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address shippingAddress;

    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(Double shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<OrderedItem> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(Set<OrderedItem> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public List<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
