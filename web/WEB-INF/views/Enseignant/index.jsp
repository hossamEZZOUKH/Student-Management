<%-- 
    Document   : index
    Created on : 22 janv. 2018, 13:21:21
    Author     : hunter
--%>

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
                        <th>Module</th>
                        <th>Semetre</th>
                        <th>Consulter Etudiants</th>
                        <th>Insértion Notes</th>
                        <th>Affiche XML</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Module> modules = (List<Module>) request.getAttribute("Modules");
                        for (Module module : modules) {
                    %>
                    <tr>
                        <td><%=module.getNom()%></td>
                        <td><%= module.getSemestre()%></td>
                        <td>
                            <form action="/MasterM2I/Enseignant/ConsulterModule=<%=module.getNom()%>" method="POST">
                                <button class="button info active" type="submit">Consulter</button>
                            </form>
                        </td>
                        <td>
                            <form action="/MasterM2I/Enseignant/InsertNote=<%=module.getNom()%>" method="POST">
                                <button class="button info active" type="submit">Insértion</button>
                            </form>
                        </td>
                        <td>
                            <form action="/MasterM2I/Enseignant/XML=<%=module.getNom()%>" method="POST">
                                <button class="button info active" type="submit">XML</button>
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
            request.setAttribute("active", "Enseignant");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>
