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
public class Image {
    private int imageID;
    private String imageLink;
    private int productID;

    public Image() {
    }

    
    public Image(int imageID, String imageLink, int productID) {
        this.imageID = imageID;
        this.imageLink = imageLink;
        this.productID = productID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
}
