<%@ page import="bstorm.akimts.demoee.service.ProductService" %>
<%@ page import="bstorm.akimts.demoee.models.Product" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: akimts
  Date: 12-07-22
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- créer des variables et/ou methodes dans la classe de la Servlet générée --%>
<%! private final ProductService service = ProductService.getInstance(); %>

<%-- dans les <% ... %> seront décrites les différentes instructions de la méthode service de la Servlet générée --%>
<%
    String id = request.getParameter("id");
    if(id == null){
        response.setStatus(400);
        return;
    }
    System.out.println("dans la méthode service");
    Product p = service.getOne(Integer.parseInt(id));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Details d'un produit</h1>

<div>
    <p><span>id: </span> <%= p.getId() %></p>
    <p><span>nom: </span> <%= p.getName() %> </p>
    <p><span>marque: </span> <%= p.getBrand() %> </p>
    <p><span>categorie: </span> <%= p.getCategory() %> </p>
    <p><span>prix: </span> <%= p.getPrice() %> $ </p>
</div>


</body>
</html>
