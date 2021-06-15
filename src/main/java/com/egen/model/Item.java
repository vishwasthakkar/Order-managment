package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
