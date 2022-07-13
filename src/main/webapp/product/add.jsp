<%--
  Created by IntelliJ IDEA.
  User: akimts
  Date: 13-07-22
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <h1>Ajouter un produit</h1>

  <form action="<%=request.getContextPath()%>/product/add" method="post">
    <div>
      <label for="in-name">nom</label><br>
      <% String name = request.getParameter("name"); %>
      <input type="text" id="in-name" name="name" value="<%= name == null ? "" : name %>">
    </div>

    <div>
      <label for="in-brand">marque</label><br>
      <% String brand = request.getParameter("name"); %>
      <input type="text" id="in-brand" name="brand" value="<%= brand == null ? "" : brand %>">
    </div>

    <div>
      <label for="in-cat">categorie</label><br>
      <% String cat = request.getParameter("category"); %>
      <input type="text" id="in-cat" name="category" value="<%= cat == null ? "" : cat %>">
    </div>

    <div>
      <label for="in-price">prix</label><br>
      <% String price = request.getParameter("price"); %>
      <input type="number" id="in-price" name="price" value="<%= cat == null ? "" : cat %>">
    </div>

<%--    <input type="submit" value="envoyer">--%>
    <button type="submit">envoyer</button>
  </form>

</body>
</html>
