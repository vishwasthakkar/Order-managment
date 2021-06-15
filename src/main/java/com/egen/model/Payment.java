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

  @ManyToOne
  @JoinColumn(name = "order_id")
  public Order orderObjInPayment;

  @Column(name = "order_payment_method")
  private PaymentMethod paymentMethod;

  @Column(name = "order_payment_date")
  private Date paymentDate;

  @Column(name = "order_payment_confirmation_number")
  private String confirmationNumebr;

  @Column(name="payment_time")
  public Time time;

  @Column(name="payment_amount",nullable=false)
  public Double amount;

  @OneToOne
  public Address billingAddress;

}
