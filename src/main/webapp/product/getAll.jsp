<%@ page import="bstorm.akimts.demoee.service.ProductService" %>
<%@ page import="bstorm.akimts.demoee.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: akimts
  Date: 13-07-22
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../WEB-INF/fragments/css_part.jsp" %>
</head>
<body>

  <%! ProductService service = ProductService.getInstance(); %>

  <h1>Tous les produits</h1>

  <ul>
    <% for( Product p : service.getAll() ){ %>
    <li>
      <div>
        <p><span>nom:</span> <%= p.getName() %> </p>
        <p><span>prix:</span> <%= p.getPrice() %> $ </p>
        <p><a href="getOne.jsp?id=<%= p.getId() %>">voir détails</a></p>
        <p><a href="update?id=<%= p.getId() %>">modifier</a></p>
      </div>
    </li>
    <% } %>
  </ul>

  <a href="<%= request.getContextPath() %>/index.jsp">retour à l'accueil</a>

</body>
</html>
