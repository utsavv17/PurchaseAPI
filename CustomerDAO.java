/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import controller.*;
import model.Customer;  // Replace "path.to.your" with the actual package path

/**
 *
 * @author 91789
 */import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    private static final String JDBC_URL = "jdbc:mysql://your-database-url:3306/your-database-name";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM Customer WHERE CustomerID = ?";

    public Customer getCustomerById(int customerID) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {

            preparedStatement.setInt(1, customerID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Mapping the result set to a Customer object
                    Customer customer = new Customer();
                    customer.setCustomerID(resultSet.getInt("CustomerID"));
                    customer.setCustomerName(resultSet.getString("CustomerName"));
                    customer.setEmail(resultSet.getString("Email"));
                    customer.setMobileNumber(resultSet.getString("MobileNumber"));
                    customer.setCity(resultSet.getString("City"));

                    return customer;
                }
            }
        } catch (SQLException e) {
            // Handle exceptions appropriately (e.g., log or throw a custom exception)
            e.printStackTrace();
        }

        return null; // Return null if no customer found or an error occurred
    }
}

