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
public class Product {
    private int productID;
    private String productName; // tên sản phẩm
    private double productPrice; //giá 1 sản phẩm 
    private int productQuantity; // số lượng sản phẩm
    private String productDesc; // description of Product
    private float rating; // đánh giá sản phẩm 
    private int categoryID; //loại sản phẩm
    private int userID; 
    private boolean status; //tình trạng của sản phẩm 

    public Product() {
    }

    public Product(int productID, String productName, double productPrice, int productQuantity, String productDesc, float rating, int categoryID, int userID, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDesc = productDesc;
        this.rating = rating;
        this.categoryID = categoryID;
        this.userID = userID;
        this.status = status;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productDesc=" + productDesc + ", rating=" + rating + ", categoryID=" + categoryID + ", userID=" + userID + ", status=" + status + '}';
    }
    
}
