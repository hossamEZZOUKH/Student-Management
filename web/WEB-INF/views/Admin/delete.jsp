<%-- 
    Document   : delet
    Created on : 16 févr. 2018, 21:01:13
    Author     : crazy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Delet</title>
    </head>
    <body>

        <div id="container">
            <div id="btnContainer">
                <button class="button buttonButton info active" onclick="selection('etudiant')">Etudiant</button>
                <button class="button buttonButton info" onclick="selection('enseignant')">Enseignant</button>
                <button class="button buttonButton info" onclick="selection('admin')">Admin</button>
                <button class="button buttonButton info" onclick="selection('module')">Module</button>
            </div>
           
            <div class="div-box etudiant">
                <form id="etudiantForm" action="/MasterM2I/Admin/DeleteEtudiant" method="post">
                    <div id="box">
                        <div class="input">
                            <input class="aaa" placeholder="CNE..." oninput="this.className = 'aaa'" name="cne">
                        </div>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('etudiant')">Supprimer</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="etudiant">
                </form>
            </div>
            <div class="div-box enseignant">
                <form id="enseignantForm"  action="/MasterM2I/Admin/DeleteEnseignant" method="POST">
                    <div id="box">
                        <p><input placeholder="Numero de Somme..." oninput="this.className = ''" name="numeroSomme"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('enseignant')">Supprimer</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="enseignant">
                </form>
            </div>
            <div class="div-box admin">
                <form id="adminForm"  action="/MasterM2I/Admin/DeleteAdmin" method="POST">
                    <div id="box">

                        <p><input placeholder="CIN..." oninput="this.className = ''" name="cin"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('admin')">Supprimer</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="admin">
                </form>
            </div>
            <div class="div-box module">
                <form id="moduleForm"  action="/MasterM2I/Admin/DeleteModule" method="POST">
                    <div id="box">
                        <p><input placeholder="Nom..." oninput="this.className = ''" name="nommodule"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('module')">Supprimer</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="module">
                </form>
            </div>
        </div>
        
        <%
            request.setAttribute("active", "Delete");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>

