<%-- 
    Document   : create
    Created on : 3 févr. 2018, 13:59:50
    Author     : crazy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Create</title>
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
                <form id="etudiantForm" action="/MasterM2I/Admin/CreateEtudiant" method="post">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><div class="input">
                            <input class="aaa" oninput="this.className = 'aaa'" name="dateN" type="date">
                            <input class="aaa" placeholder="CNE..." oninput="this.className = 'aaa'" name="cne">
                        </div></p>
                        <p><input placeholder="Adresse..." oninput="this.className = ''" name="adress"></p>
                        <p><div class="input">
                            <input class="aaa" placeholder="Ville..." oninput="this.className = 'aaa'" name="ville">
                            <input class="aaa"  placeholder="Pays..." oninput="this.className = 'aaa'" name="pays">
                        </div></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                               
                                <button class="button info active" type="button" onclick="envoyer('etudiant')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="etudiant">
                </form>
            </div>
            <div class="div-box enseignant">
                <form id="enseignantForm"  action="/MasterM2I/Admin/CreateEnseignant" method="POST">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><input placeholder="Numero de Somme..." oninput="this.className = ''" name="numeroSomme"></p>
                        <p><input placeholder="CIN..." oninput="this.className = ''" name="cin"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('enseignant')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="enseignant">
                </form>
            </div>
            <div class="div-box admin">
                <form id="adminForm"  action="/MasterM2I/Admin/CreateAdmin" method="POST">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><input placeholder="CIN..." oninput="this.className = ''" name="cin"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('admin')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="admin">
                </form>
            </div>
            <div class="div-box module">
                <form id="moduleForm"  action="/MasterM2I/Admin/CreateModule" method="POST">
                    <div id="box">
                        <p><input placeholder="Nom..." oninput="this.className = ''" name="nommodule"></p>
                        <p><input placeholder="Semestre..." oninput="this.className = ''" type="integer" name="semestre"></p>
                        <p><input placeholder="Numero de Somme..." oninput="this.className = ''" name="NS"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button class="button info active" type="button" onclick="envoyer('module')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="data" value="module">
                </form>
            </div>
        </div>

        <%
            request.setAttribute("active", "Create");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>
