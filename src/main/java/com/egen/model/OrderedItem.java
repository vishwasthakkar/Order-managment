package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_items")
public class OrderedItem {

  @OneToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @Column(name = "order_item_qty")
  private Integer quantity;

}
