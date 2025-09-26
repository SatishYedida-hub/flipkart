<html>
<body>
<h2>Products</h2>
<ul>
<%
   java.util.List<com.example.flipkart.model.Product> products =
     (java.util.List<com.example.flipkart.model.Product>) request.getAttribute("products");
   for (com.example.flipkart.model.Product p : products) {
%>
   <li>
     <%= p.getName() %> - ₹<%= p.getPrice() %>
     <a href="cart?action=add&id=<%=p.getId()%>">Add to Cart</a>
   </li>
<% } %>
</ul>
<a href="cart">View Cart</a>
</body>
</html>