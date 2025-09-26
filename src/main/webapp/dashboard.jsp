<%@ page session="true" %>
<h2>Welcome, <%= session.getAttribute("user") %></h2>
<a href="employees.jsp">Manage Employees</a>