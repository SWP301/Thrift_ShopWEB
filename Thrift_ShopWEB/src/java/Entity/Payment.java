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
public class Payment {
    private int paymentID;
    private Date paymentTime; // ngày trả tiền
    private double amount; // số dư
    private String paymentType; // hình thức thanh toán
    private int orderID;

    public Payment() {
    }

    public Payment(int paymentID, Date paymentTime, double amount, String paymentType, int orderID) {
        this.paymentID = paymentID;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.paymentType = paymentType;
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    
}
