<%-- 
    Document   : gerer-etudiant
    Created on : 14 janv. 2018, 09:46:57
    Author     : hunter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
            <%= (request.getAttribute("description") != null) ? "<h4>" + request.getAttribute("description") + "<h4>" : ""%>
            <h2>Ajouter un Compte</h2>
            <div id="btnContainer">
                <button class="button info active" onclick="selection('etudiant')">Etudiant</button>
                <button class="button info" onclick="selection('enseignant')">Enseignant</button>
                <button class="button info" onclick="selection('admin')">Admin</button>
            </div>
            <div class="div-box etudiant">
                <form id="etudiantForm" action="/MasterM2I/Administrateur" method="post">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><div class="input">
                            <input class="aaa" placeholder="CNE..." oninput="this.className = 'aaa'" name="cne">
                            <input class="aaa"  placeholder="CIN..." oninput="this.className = 'aaa'" name="cin">
                        </div></p>
                        <p><input oninput="this.className = ''" name="cin" type="date"></p>
                        <p><input placeholder="Adresse..." oninput="this.className = ''" name="adresse"></p>
                        <p><div class="input">
                            <input class="aaa" placeholder="Ville..." oninput="this.className = 'aaa'" name="ville">
                            <input class="aaa"  placeholder="Pays..." oninput="this.className = 'aaa'" name="pays">
                        </div></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('etudiant')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="ajouter">
                    <input type="hidden" name="user" value="etudiant">
                </form>
            </div>
            <div class="div-box enseignant">
                <form id="enseignantForm"  action="/MasterM2I/Administrateur" method="POST">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><input placeholder="CIN..." oninput="this.className = ''" name="cin"></p>
                        <p><input placeholder="Numero de Somme..." oninput="this.className = ''" name="numeroSomme"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('enseignant')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="ajouter">
                    <input type="hidden" name="user" value="enseignant">
                </form>
            </div>
            <div class="div-box admin">
                <form id="adminForm"  action="/MasterM2I/Administrateur" method="POST">
                    <div id="box">
                        <p><div class="input">
                            <input class="aaa" placeholder="Nom..." oninput="this.className = 'aaa'" name="nom">
                            <input class="aaa"  placeholder="Prenom..." oninput="this.className = 'aaa'" name="prenom">
                        </div></p>
                        <p><input placeholder="CIN..." oninput="this.className = ''" name="cin"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('admin')">Ajoutée</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="ajouter">
                    <input type="hidden" name="user" value="admin">
                </form>
            </div>
        </div>
    </body>
</html>
