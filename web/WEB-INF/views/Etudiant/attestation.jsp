<%-- 
    Document   : attestation
    Created on : 17 févr. 2018, 21:11:14
    Author     : crazy
--%>

<%@page import="com.spring.entities.Note"%>
<%@page import="java.util.List"%>
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
                        <th>Module</th>
                        <th>Enseignant</th>
                        <th>Note Normal</th>
                        <th>Note Rattrapage</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Note> notes = (List<Note>) request.getAttribute("Notes");
                        for (Note note : notes) {
                            Double sn = note.getSn();
                            Double sr = note.getSr();
                    %>

                    <tr>
                        <td><%=note.getModuleNom().getNom()%></td>
                        <td><%= note.getModuleNom().getEnseignantNs().getNom()%></td>
                        <td><%=sn == null ? "-" : sn.doubleValue() + ""%></td>
                        <td><%=sr == null ? "-" : sr.doubleValue() + ""%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%
            request.setAttribute("active", "Attestation");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>

