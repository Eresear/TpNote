<%--
  Created by IntelliJ IDEA.
  User: nournasrallah
  Date: 19/04/2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Espace Agence</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</head>

<style>

    body {
        font-family: 'Raleway', sans-serif;
    }

</style>

<body>

    <div class="row">
        <div class="col">
            <h1 style="color: darkmagenta">Réservations</h1>
        </div>
        <div class="col-lg-2">
            <h4 style="margin-left: 5px"><a href="${pageContext.request.contextPath}/Accueil">Retour à l'accueil</a></h4>
        </div>
    </div>

    <div style="margin-top: 5%" class="container text-center">
        <table cellpadding="10" , border="1", class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th> Numéro de réservation </th>
            <th> Nom du client </th>
            <th> Nombre de voyageurs adultes </th>
            <th> Nombre de voyageurs étudiants </th>
            <th> Nombre de voyageurs enfants  </th>
            <th> Prix total (en €) </th>
        </tr>
        </thead>
        <!-- Table contenant les réservations-->
        <c:forEach items = "${listReservations}" var="reservation" >
            <tr>
            <td>${reservation.idReservation}</td>
            <td>${reservation.nomClient}</td>
            <td>${reservation.normaux}</td>
            <td>${reservation.etudiants}</td>
            <td>${reservation.enfants}</td>
            <td>${reservation.prix}</td>
            </tr>
        </c:forEach>
        </table>
    </div>

    <div class="row">
        <div class="col">
            <h1 style="color: darkmagenta">Employés de l'entreprise</h1>
        </div>
    </div>

    <div style="margin-top: 5%" class="container text-center">
        <table cellpadding="10" , border="1", class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th> Nom et Prenom </th>
                <th> Adresse </th>
                <th> Date de naissance </th>
                <th> Temps de travail </th>
            </tr>
            </thead>
            <!-- Table contenant les réservations-->
            <c:forEach items = "${listEmployes}" var="employe" >
                <tr>
                    <td>${employe.nomprenom}</td>
                    <td>${employe.adresse}</td>
                    <td>${employe.dateDeNaissance}</td>
                    <td>${employe.typeTemps}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
