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
public class Attribute {
    private int attributeID;
    private String attributeName;
    private String unit; 
    private int displayIndex;
    private int categoryID;

    public Attribute() {
    }

    public Attribute(int attributeID, String attributeName, String unit, int displayIndex, int categoryID) {
        this.attributeID = attributeID;
        this.attributeName = attributeName;
        this.unit = unit;
        this.displayIndex = displayIndex;
        this.categoryID = categoryID;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
}
