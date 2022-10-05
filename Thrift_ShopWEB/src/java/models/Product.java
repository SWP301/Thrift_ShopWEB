/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author buile
 */
public class Product {

    private int productID;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private String productDesc;
    private float rating;
    private String imageLink;
    Category category = new Category();
    Account user = new Account();

    public Product() {
    }

    public Product(int productID, String productName, int productPrice, int productQuantity, String productDesc, float rating, Category category, Account user) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.rating = rating;
        this.category = category;
        this.user = user;
    }

    public Product(int productID, String productName, int productPrice, int productQuantity, String productDesc, float rating, String imageLink) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.rating = rating;
        this.imageLink = imageLink;
    }    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productDesc=" + productDesc + ", rating=" + rating + '}';
    }
    

}
