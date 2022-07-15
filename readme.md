# Demo Java EE

##description

Ce projet a pour but d'éfleurer la création
d'application Entreprise via les outils qui se cachent
sous Spring boot.

Quand bien même il est peu probable que vous utilisiez cette
façon de faire pour créer vos applications futures, il est important
de comprendre sur quoi les outils que vous utiliserez reposent.

##Idée générale

Dans ce projet, 3 tentatives sont faites pour renvoyer une vue HTML à une requête HTTP
 - Génération de vue dans la Servlet (voir ProductServlet)
 - Code métier dans une JSP (voir getOne.jsp)
 - Alliance Servlet -forward-> JSP (proche du MVC - voir UpdateServlet)