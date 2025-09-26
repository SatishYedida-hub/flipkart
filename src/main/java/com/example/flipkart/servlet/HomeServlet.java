package com.example.flipkart.servlet;

import com.example.flipkart.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class HomeServlet extends HttpServlet {
    private List<Product> products;

    @Override
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Samsung Phone", 15000, "Electronics"));
        products.add(new Product(2, "Nike Shoes", 3000, "Fashion"));
        products.add(new Product(3, "Rice Bag 10kg", 500, "Groceries"));
        getServletContext().setAttribute("products", products);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}