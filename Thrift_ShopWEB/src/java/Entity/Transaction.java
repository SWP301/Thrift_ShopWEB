/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author htmlo
 */
public class Transaction {
    private int transactionID;
    private double amount; // số dư
    private int walletID;
    private int paymentID;

    public Transaction() {
    }

    public Transaction(int transactionID, double amount, int walletID, int paymentID) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.walletID = walletID;
        this.paymentID = paymentID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    
}
