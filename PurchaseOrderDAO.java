/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.*;
/**
 *
 * @author 91789
 */import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.PurchaseOrder;

public class PurchaseOrderDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String INSERT_PURCHASE_ORDER_QUERY = "INSERT INTO PurchaseOrder (ProductName, Quantity, Pricing, MRP, CustomerID) VALUES (?, ?, ?, ?, ?)";

    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PURCHASE_ORDER_QUERY)) {
            System.out.println("purchaseorderDao");
            preparedStatement.setString(1, purchaseOrder.getProductName());
            preparedStatement.setInt(2, purchaseOrder.getQuantity());
            preparedStatement.setDouble(3, purchaseOrder.getPricing());
          preparedStatement.setDouble(4, purchaseOrder.getMRP());
   preparedStatement.setInt(5, purchaseOrder.getCustomerID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Handle exceptions appropriately (e.g., log or throw a custom exception)
            e.printStackTrace();
        }
    }
}

