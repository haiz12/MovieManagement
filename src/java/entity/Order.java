/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int id;
    private Date orderDate;
    private Date expirationDate;
    private double price;
    private int accountId;

    public Order() {
    }

    public Order(int id, Date orderDate, Date expirationDate, double price, int accountId) {
        this.id = id;
        this.orderDate = orderDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.accountId = accountId;
    }
    
    public Order(Date orderDate, Date expirationDate, double price, int accountId) {
        this.orderDate = orderDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
}
