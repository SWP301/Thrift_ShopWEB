/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author htmlo
 */
public class Order {
    private int orderID;
    private Date orderDate; //ngày đặt hàng 
    private Date shipDate; // ngày giao hàng 
    private String shipAddress; // dịa chỉ giao hàng
    private double totalPrice; // tổng giá 
    private int userID; 
    private int productID;

    public Order() {
    }

    public Order(int orderID, Date orderDate, Date shipDate, String shipAddress, double totalPrice, int userID, int productID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.productID = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", shipAddress=" + shipAddress + ", totalPrice=" + totalPrice + ", userID=" + userID + ", productID=" + productID + '}';
    }
    
    
    
}
