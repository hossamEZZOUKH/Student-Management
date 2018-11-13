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
        <title>Master M2I</title>
    </head>
    <body>
        <div id="container">
            <%= (request.getAttribute("description") != null) ? "<h4>" + request.getAttribute("description") + "<h4>" : ""%>
            <h1>Master M2I</h1>
            <h2>Espace</h2>
            <div id="btnContainer">
                <button class="button info active" onclick="selection('etudiant')">Etudiant</button>
                <button class="button info" onclick="selection('enseignant')">Enseignant</button>
                <button class="button info" onclick="selection('admin')">Admin</button>
            </div>
            <div class="div-box etudiant">
                <form id="etudiantForm" action="/MasterM2I/login" method="post">
                    <div id="box">
                        <p><input placeholder="CNE..." oninput="this.className = ''" name="username"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('etudiant')">Log in</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="login">
                    <input type="hidden" name="user" value="etudiant">
                </form>
            </div>
            <div class="div-box enseignant">
                <form id="enseignantForm"  action="/MasterM2I/login" method="POST">
                    <div id="box">
                        <p><input placeholder="CIN..." oninput="this.className = ''" name="username"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('enseignant')">Log in</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="login">
                    <input type="hidden" name="user" value="enseignant">
                </form>
            </div>
            <div class="div-box admin">
                <form id="adminForm"  action="/MasterM2I/login" method="POST">
                    <div id="box">
                        <p><input placeholder="Username..." oninput="this.className = ''" name="username"></p>
                        <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
                        <div style="overflow:auto;">
                            <div style="float:right;">
                                <button type="button" onclick="envoyer('admin')">Log in</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="operation" value="login">
                    <input type="hidden" name="user" value="admin">
                </form>
            </div>
        </div>
        <%@include  file="head.jsp" %>
    </body>
</html>
