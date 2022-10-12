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
public class Wallet {
    private int walletID;
    private float amount;
    Account user = new Account();

    public Wallet() {
    }

    public Wallet(int walletID, int amount, Account user) {
        this.walletID = walletID;
        this.amount = amount;
        this.user = user;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
    
    
    
}
