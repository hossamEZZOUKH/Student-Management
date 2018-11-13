<%-- 
    Document   : index
    Created on : 22 janv. 2018, 13:21:21
    Author     : hunter
--%>

<%@page import="com.spring.entities.Etudiant"%>
<%@page import="com.spring.entities.Note"%>
<%@page import="com.spring.entities.Module"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enseignant Page</title>
    </head>
    <body>
        <div style="padding:20px;margin-top:50px;">
            <table>
                <thead>
                    <tr>
                        <th>CNE</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Réinscription</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("Etudiants");
                        for (Etudiant etudiant : etudiants) {
                    %>
                    <tr>
                        <td><%=etudiant.getCne()%></td>
                        <td><%=etudiant.getNom()%></td>
                        <td><%=etudiant.getPrenom()%></td>
                        <td><form action="/MasterM2I/Admin/ReinscriptionEtudiant" method="POST">
                                <button class="button info active" type="submit" name="cne" value="<%=etudiant.getCne()%>">Reinscription</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <%
            request.setAttribute("active", "Reinscription");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>
