<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="WEB-INF/fragments/css_part.jsp" %>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="product/getAll.jsp">Voir les produits</a>
<a href="product/add.jsp">Ajouter un produits</a>
</body>
</html>