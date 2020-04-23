<%--
  Created by IntelliJ IDEA.
  User: yangyang
  Date: 2020/4/13
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">"
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<html>
<head>
    <title>Réserver</title>
</head>
<style>
    body {
        font-family: 'Raleway', sans-serif;
    }
</style>
<body>
    <div class="col">
        <h1 style="color: darkmagenta">Votre réservation</h1>
    </div>
    <form action="reservation"  method="post">
        <div class="form-group" style="text-align:left; width: 100%; max-width: 330px;
            padding: 15px; margin-left:10px ;position: relative;">
            <h5 style="margin-bottom: 20px"> Pays de destination : ${sessionScope.pays}</h5>
            <c:choose>
                <c:when test="${sessionScope.reserverAlert!=null}">
                    <p class="alert alert-danger">${sessionScope.reserverAlert} </p>
                </c:when>
                <c:otherwise>
                    <p></p>
                </c:otherwise>
            </c:choose>

            <label for="name">Nom et prénom:</label>
            <input style="margin-bottom: 10px" type="text" class="form-control" id="name" name="name">
            <label for="nbAdultes">Nombre voyageurs adultes:</label>
            <input style="margin-bottom: 10px" id="nbAdultes" type="number" name="nbAdultes" value="0" min="0" max="10" step="1" onchange="calcul();"/>
            <label for="nbEtudiants">Nombre Étudiants (18-25 ans):</label>
            <input style="margin-bottom: 10px" id="nbEtudiants" name="nbEtudiants" type="number" value="0" min="0" max="10" step="1" onchange="calcul();"/>
            <label for="nbEnfants">Nombre Enfants (moins de 3 ans):</label>
            <input style="margin-bottom: 10px" id="nbEnfants" name="nbEnfants" type="number" value="0" min="0" max="10" step="1" onchange="calcul();"/>
            <label for="prixTotal">Total (en €):</label>
            <input  readonly id="prixTotal" name="prixTotal" type="text" value="0" ></input>
            <a href="Accueil" style="margin-bottom: 10px" type="button" class="btn btn-secondary"  >Close</a>
            <button style="background-color: darkmagenta; margin-bottom: 10px" type="submit" class="btn btn-primary">Réserver</button>

        </div>
    </form>

</body>
</html>
<script type="text/javascript">
    function calcul() {
        var reductionEtuediant = 0.2;
        var reductionEnfants = 0.5;
        var nbAdulte = document.getElementById("nbAdultes").value;
        var nbEtudiants = document.getElementById("nbEtudiants").value;
        var nbEnfants = document.getElementById("nbEnfants").value;
        var tarifPer = ${sessionScope.tarif};

        var total = nbAdulte*tarifPer+ nbEtudiants*tarifPer*(1-reductionEtuediant) + nbEnfants*tarifPer*(1-reductionEnfants);
        // document.getElementById('prixTotal').innerHTML = total;
        document.getElementById("prixTotal").value= total;

    }
</script>
