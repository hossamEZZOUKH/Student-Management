<%-- 
    Document   : index
    Created on : 22 janv. 2018, 13:21:21
    Author     : hunter
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etudiant Page</title>
    </head>
    <body>
        <div style="padding:20px;margin-top:50px;">
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>CNE</th>
                        <th>Password</th>
                        <th>Date Naissance</th>
                        <th>Adresse</th>
                        <th>Ville</th>
                        <th>Pays</th>
                    </tr>
                </thead>
                <tbody>
                    <%=session.getAttribute("user")%>
                </tbody>
            </table>
        </div>
        <%
            request.setAttribute("active", "Etudiant");
        %>
        <%@include  file="head.jsp" %>
    </body>
</html>
