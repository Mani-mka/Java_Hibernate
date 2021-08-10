package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

    @Id
    @Column(name="customerID")
    private int customerID;
    @Column(name="customerName")
    private String customerName;
    @Column(name="customerOrder")
    private String order;
    @Column(name="customerPoints")
    private int points;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String order, int points) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.order = order;
        this.points = points;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", order='" + order + '\'' +
                ", points=" + points +
                '}';
    }

}
