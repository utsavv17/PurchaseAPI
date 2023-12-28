/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DAO.CustomerDAO;
import model.PurchaseOrder;
import model.Customer;
import DAO.PurchaseOrderDAO;


/**
 *
 * @author 91789
 */
public class PurchaseOrderController {
       private CustomerDAO customerDAO;
    private PurchaseOrderDAO purchaseOrderDAO;

    public PurchaseOrderController() {
        this.customerDAO = new CustomerDAO();
        this.purchaseOrderDAO = new PurchaseOrderDAO();
    }

    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        // Validate the input, retrieve customer details, and create a purchase order
        Customer customer = customerDAO.getCustomerById(purchaseOrder.getCustomerID());
        if (customer != null) {
            // Set customer details in the purchase order before creating it
            purchaseOrder.setCustomerName(customer.getCustomerName());
            purchaseOrder.setEmail(customer.getEmail());
            purchaseOrder.setMobileNumber(customer.getMobileNumber());
            purchaseOrder.setCity(customer.getCity());

            // Implement any other business logic/validation

            // Create the purchase order
            purchaseOrderDAO.createPurchaseOrder(purchaseOrder);
        } else {
            // Handle invalid customer ID
            System.out.println("Invalid customer ID: " + purchaseOrder.getCustomerID());
        }
    }
}

    

