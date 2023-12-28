package Resource;

import DAO.PurchaseOrderDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.PurchaseOrder;

public class PurchaseOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("enter");
            // Assuming you have a PurchaseOrder object and other necessary data
            String productName = req.getParameter("productName");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            double pricing = Double.parseDouble(req.getParameter("pricing"));
            double mrp = Double.parseDouble(req.getParameter("mrp"));
            System.out.println(quantity);
            System.out.println(pricing);
            System.out.println(mrp);
            // Validate or process the data as needed
            // ...

            // Create a PurchaseOrder object (replace this with your actual logic)
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setProductName(productName);
            purchaseOrder.setQuantity(quantity);
            purchaseOrder.setPricing(pricing);
            purchaseOrder.setMRP(mrp);
            System.out.println("hey");
            // Your existing logic to persist the purchase order to the database or perform other actions
            // For now, we'll assume a PurchaseOrderDAO class exists
            PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
            purchaseOrderDAO.createPurchaseOrder(purchaseOrder);

            // Set the API response in the request attribute
          
            // Forward to the JSP page
            req.getRequestDispatcher("/test.jsp").forward(req, resp);
        } catch (Exception e) {
            // Handle exception (e.g., log it or show an error message)
            e.printStackTrace(); // This is just an example; in a real application, you might want to handle exceptions more gracefully.
        }
    }
}
