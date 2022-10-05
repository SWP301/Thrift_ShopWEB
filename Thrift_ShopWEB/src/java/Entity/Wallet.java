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
public class Wallet {
    private int walletID;
    private double amount; // số dư
    private int userID; 

    public Wallet() {
    }

    public Wallet(int walletID, double amount, int userID) {
        this.walletID = walletID;
        this.amount = amount;
        this.userID = userID;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
}
