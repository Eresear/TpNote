<%--
  Created by IntelliJ IDEA.
  User: yangyang
  Date: 2020/4/6
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Accueil</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
  </head>
  <body>

  <div>
    <h1 style="color: darkmagenta">Offres de voyage</h1>

    <!-- Bouton "Se connecter"-->
    <h2><a href="?op=login">Sing In</a></h2>
  </div>

  <div class="container text-center">
    <table cellpadding="10" , border="1", class="table table-striped table-bordered">
      <thead class="thead-dark">
        <tr>
          <th> Nom </th>
          <th> Tarif </th>
          <th>  </th>
        </tr>
      </thead>
      <!-- Table contenant les livres-->
      <c:forEach items = "${listOfrre}" var="offres">
      <tr>
        <td>${offres.nom}</td>
        <td>${offres.tarif}</td>
        <td>
          <a href="?op=emprunter&id=${offres.id}&username=">Réserver</a>
        </td>
      </tr>
      </c:forEach>
    </table>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </body>
</html>
