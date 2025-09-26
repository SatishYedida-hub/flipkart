package com.portal.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import com.portal.dao.DBConnection;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, uname);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", uname);
                resp.sendRedirect("dashboard.jsp");
            } else {
                resp.sendRedirect("index.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}