package model;

import java.math.BigDecimal;

public class PurchaseOrder {
    private String productName;
    private int quantity;
    private double pricing;
    private double mrp;
    private int customerID;
    private String customerName;
    private String email;
    private String mobileNumber;
    private String city;

    // Constructors, getters, and setters

    // Constructors
    public PurchaseOrder() {
        // Default constructor
    }

    public PurchaseOrder(String productName, int quantity, double pricing, double mrp, int customerID) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricing = pricing;
        this.mrp = mrp;
        this.customerID = customerID;
    }

    // Getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public double getMRP() {
        return mrp;
    }

    public void setMRP(double mrp) {
        this.mrp = mrp;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

  

   
   
}
