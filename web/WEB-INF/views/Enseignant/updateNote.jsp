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
                        <th>CNE</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Note Normal</th>
                        <th>Note Rattrapage</th>
                        <th>Modifier Note</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String module;
                        List<Note> notes = (List<Note>) request.getAttribute("Notes");
                        for (Note note : notes) {
                            Double sn = note.getSn();
                            Double sr = note.getSr();
                            module = note.getModuleNom().getNom();
                    %>

                    <tr>
                <form action="/MasterM2I/Enseignant/UpdateNote" method="POST">
                    <td><%=note.getEtudiantCne().getCne()%></td>
                    <td><%=note.getEtudiantCne().getNom()%></td>
                    <td><%=note.getEtudiantCne().getPrenom()%></td>
                    <td><input type="number" min="-2" max="20" step="0.01" name="sn" value="<%=sn == null ? "vide" : sn.doubleValue()%>"/></td>
                    <td><input type="number" min="-1" max="20" step="0.01" name="sr" value="<%=sr == null ? "vide" : sr.doubleValue()%>"/></td>
                    <td>
                        <input type="hidden" name="module" value="<%=note.getModuleNom().getNom()%>"/>
                        <input type="hidden" name="cne" value="<%=note.getEtudiantCne().getCne()%>"/>
                        <button class="button info active" type="submit">Insérer</button>
                    </td>
                </form> 
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <%
            request.setAttribute("active", "InsertNote");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>

