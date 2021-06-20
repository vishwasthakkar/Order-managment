package com.egen.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @Column(name = "payment_amount")
  private double paymentAmount;

  @Column(name = "order_payment_method")
  private PaymentMethod paymentMethod;

  @Column(name = "order_payment_date")
  private Date paymentDate;

  @Column(name = "order_payment_confirmation_number")
  private String confirmationNumber;

  @Column(name="payment_time")
  private Time time;

  @Column(name="payment_amount",nullable=false)
  private Double amount;

  @OneToOne
  private Address billingAddress;

  public Payment() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public String getConfirmationNumber() {
    return confirmationNumber;
  }

  public void setConfirmationNumber(String confirmationNumber) {
    this.confirmationNumber = confirmationNumber;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Address getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }



}
