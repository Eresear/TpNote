<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Accueil</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">"

  </head>
  <style>

    body {
      font-family: 'Raleway', sans-serif;
    }
  </style>
  <body>

  <div class="row">
    <div class="col">
      <h1 style="color: darkmagenta">Offres de voyage</h1>
    </div>

    <c:choose>
      <c:when test="${sessionScope.authenticated==null}">
        <div class="col-lg-2">
          <h2 style="margin-left: 5px"><a href="${pageContext.request.contextPath}/login.jsp">Se connecter</a></h2>
        </div>
      </c:when>
      <c:when test="${sessionScope.authenticated=='yes'}">
        <div class="col-lg-2">
          <h3 style="margin-left: 0px"><a href="${pageContext.request.contextPath}/logout">Se déconnecter</a></h3>
        </div>
      </c:when>
    </c:choose>

  </div>

  <div style="margin-top: 5%" class="container text-center">
    <table cellpadding="10" , border="1", class="table table-striped table-bordered">
      <thead class="thead-dark">
        <tr>
          <th> Destination </th>
          <th> Tarif (en €) </th>
          <th> Description </th>
          <th>  </th>
          <th>  </th>
        </tr>
      </thead>
      <!-- Table contenant les livres-->
      <c:forEach items = "${listOffres}" var="offre">
      <tr>
        <td>${offre.nomDestination}</td>
        <td>${offre.tarif}</td>
        <td>${offre.description}</td>
        <td>
          <a href='offre=${offre.idOffre}'>Infos</a>
        </td>
        <td>
          <a href="?op=reserver&id=${offres.id}">Réserver</a>
        </td>
      </tr>
      </c:forEach>
    </table>
  </div>

  <c:choose>
    <c:when test="${sessionScope.authenticated=='yes'}">
      <div class="row justify-content-center">
          <button formaction="" class="btn btn-primary"  id="addButton">Ajouter Offre</button>
      </div>
      <jsp:include page="addOffre.jsp"></jsp:include>
    </c:when>
  </c:choose>
  <c:if test="${requestScope.alert!=null}">
   <script>
     $('#modal').modal("show");
   </script>
  </c:if>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </body>
</html>

<script type="text/javascript">
  $(function () {
    $(document).on('click', '#addButton', function(e)
    {
      $('#modal').modal("show");
    });
  });
</script>
