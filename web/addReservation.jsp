<%--
  Created by IntelliJ IDEA.
  User: yangyang
  Date: 2020/4/13
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="offre" scope="request">
    <jsp:setProperty name="offre" property="*"></jsp:setProperty>
</jsp:useBean>
<html>
<head>
    <title>Réserver</title>
</head>
<body>
    <form action="reserver" >
        <div class="modal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Réserver</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="input-group mb-3">
                            <input style="margin-bottom: 10px;min-width: auto;" class="form-control" type="text" name="lieu" placeholder="Votre nom" style="min-width: 100%">
                        </div>
                        <div class="input-group mb-3">
                            <input type="number" min="0"  id="enfant" name="enfant">

                            <label for="jeune">Age 3-18:</label>
                            <input type="number" min="0" id="jeune" name="reduction">
                            <label for="adult">Age >18:</label>
                            <input type="number" min="0"  id="adult" name="reduction">
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Save changes</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
