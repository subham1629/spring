package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  private Integer uid;
  private String name;
  private String email;
  
  @ManyToOne
  private Laptop laptop;
  
  public User() {}
  public User(Integer uid, String name, String email) {
	super();
	this.uid = uid;
	this.name = name;
	this.email = email;
}



public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public Laptop getLaptop() {
	return laptop;
}
public void setLaptop(Laptop laptop) {
	this.laptop = laptop;
}
public Integer getId() {
    return uid;
  }

  public void setId(Integer uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

@Override
public String toString() {
	return "User [id=" + uid + ", name=" + name + ", email=" + email + "]";
}
}