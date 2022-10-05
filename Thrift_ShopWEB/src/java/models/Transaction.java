/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Le Nguyen Nhat Minh
 */
public class Transaction {
    private int transactionID;
    private float amount;
    Wallet wallet = new Wallet();
    Payment payment = new Payment();

    public Transaction(int transactionID, float amount, Wallet wallet, Payment payment) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.wallet = wallet;
        this.payment = payment;
    }

    public Transaction() {
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
}
