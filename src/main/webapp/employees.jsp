<%@ page import="java.util.*,com.portal.dao.EmployeeDAO,com.portal.model.Employee" %>
<h2>Employees</h2>
<form action="addEmployee" method="post">
  Name: <input type="text" name="name" required><br>
  Email: <input type="email" name="email" required><br>
  Department: <input type="text" name="department" required><br>
  <button type="submit">Add</button>
</form>
<hr>
<table border="1">
  <tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th></tr>
  <%
    List<Employee> list = EmployeeDAO.getAllEmployees();
    for(Employee emp : list){
  %>
    <tr>
      <td><%= emp.getId() %></td>
      <td><%= emp.getName() %></td>
      <td><%= emp.getEmail() %></td>
      <td><%= emp.getDepartment() %></td>
    </tr>
  <% } %>
</table>