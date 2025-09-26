package com.portal.controller;
import com.portal.dao.EmployeeDAO;
import com.portal.model.Employee;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String dept = req.getParameter("department");
        Employee emp = new Employee(name, email, dept);
        EmployeeDAO.addEmployee(emp);
        resp.sendRedirect("employees.jsp");
    }
}