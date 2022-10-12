/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class Payment {
    private int paymentID;
    private LocalDateTime paymentTime;
    private float amount;
    private String paymentType;
    Order order = new Order();

    public Payment(int paymentID, LocalDateTime paymentTime, float amount, String paymentType, Order order) {
        this.paymentID = paymentID;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.paymentType = paymentType;
        this.order = order;
    }

    public Payment() {
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
}
