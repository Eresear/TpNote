<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Accueil</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">
<%--    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">--%>

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
          <th> Nombre de place</th>
          <th>  </th>
          <th>  </th>
        </tr>
      </thead>
      <!-- Table contenant les livres-->
      <c:forEach items = "${listOffres}" var="offre" >
      <tr>
        <td>${offre.nomDestination}</td>
        <td>${offre.tarif}</td>
        <td>${offre.description}</td>
        <td>${offre.nbPlaces}</td>
        <td>
          <a data-toggle="modal" href="" data-target="#modalInfos_${offre.nomDestination}" >Infos</a>
        </td>
        <td>
          <a href="${pageContext.request.contextPath}/reservation?pays=${offre.nomDestination}&tarif=${offre.tarif}&idOffre=${offre.idOffre}">Réserver</a>
        </td>
      </tr>


      </c:forEach>
    </table>

  </div>

      <c:forEach items="${listOffres}" var="offre">

          <div class="modal fade" tabindex="-1" role="dialog" id="modalInfos_${offre.nomDestination}">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                  <h4 class="modal-title">Détails sur l'offre</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- Modal body -->
                <div class="modal-body">

                  <ul class="list-group">
                    <li class="list-group-item list-group-item-primary">Activites</li>
                      <c:forEach items="${offre.activitesList}" var="activite" >
                        <li class="list-group-item">${activite.nomActivite}</li>
                      </c:forEach>

                    <li class="list-group-item list-group-item-primary">Chose à faire</li>
                      <c:forEach items="${offre.choseAFaireList}" var="chose" >
                        <li class="list-group-item"> ${chose.nomChose}</li>
                      </c:forEach>

                  </ul>

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>


              </div>
            </div>
          </div>
      </c:forEach>

  <c:choose>
    <c:when test="${sessionScope.authenticated=='yes'}">
      <div class="row justify-content-center">
          <button style="background-color: darkmagenta" formaction="" class="btn btn-primary"  id="addButton">Ajouter Offre</button>
      </div>
      <jsp:include page="addOffre.jsp"></jsp:include>
    </c:when>
  </c:choose>
  <c:if test="${sessionScope.addOffreAlert!=null}">
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
