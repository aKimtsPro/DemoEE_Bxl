<%@ page import="bstorm.akimts.demoee.models.Product" %><%--
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
    <%@ include file="../WEB-INF/fragments/css_part.jsp" %>
</head>
<body>

<h1>Modifier un produit</h1>

<%
    Product toUpdate = (Product) request.getAttribute("product");
%>


<%
    String error = (String) request.getAttribute("error");
    if( error != null ){ %>
        <p style="color: red"><%=error%></p>
    <%}%>

<form action="<%=request.getContextPath()%>/product/update" method="post">
    <input type="hidden" name="id" value="<%= toUpdate.getId() %>" >
    <div>
        <label for="in-name">nom</label><br>
        <input type="text" id="in-name" name="name" value="<%= toUpdate.getName() %>">
    </div>

    <div>
        <label for="in-brand">marque</label><br>
        <input type="text" id="in-brand" name="brand" value="<%= toUpdate.getBrand() %>">
    </div>

    <div>
        <label for="in-cat">categorie</label><br>
        <input type="text" id="in-cat" name="category" value="<%= toUpdate.getCategory() %>">
    </div>

    <div>
        <label for="in-price">prix</label><br>
        <input type="number" id="in-price" name="price" value="<%= toUpdate.getPrice() %>">
    </div>

    <%--    <input type="submit" value="envoyer">--%>
    <button type="submit">envoyer</button>
</form>

</body>
</html>
