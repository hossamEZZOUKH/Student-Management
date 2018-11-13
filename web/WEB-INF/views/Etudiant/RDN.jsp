<%-- 
    Document   : RDN
    Created on : 17 févr. 2018, 22:10:43
    Author     : crazy
--%>

<%@page import="com.spring.entities.Enseignant"%>
<%@page import="com.spring.entities.Module"%>
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

        <%
            List<Note> notes = (List<Note>) request.getAttribute("Notes");
        %>
        <div id="container" style="width:700px;margin-top: 50px; height:100%;">
            <div style="text-align: center;">
                <div>
                    <form action="/MasterM2I/Etudiant/XML" method="POST">
                        <button class="button info active" type="submit">XML</button>
                        <button class="button info active" type="submit">PDF</button>
                    </form>
                </div>
            </div>
            <div id="btnContainer">
                <button class="button buttonButton info active" onclick="selection('etudiant')">S1</button>
                <button class="button buttonButton info" onclick="selection('enseignant')">S2</button>
                <button class="button buttonButton info" onclick="selection('admin')">S3</button>
                <button class="button buttonButton info" onclick="selection('module')">S4</button>
            </div>

            <div class="div-box etudiant">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <table>
                            <thead>
                                <tr>
                                    <th>Module</th>
                                    <th>Nom Enseignant</th>
                                    <th>Note Normal</th>
                                    <th>Note Rattrapage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    boolean check = false;
                                    for (Note note : notes) {
                                        long semestre = note.getModuleNom().getSemestre().longValue();
                                        if (semestre == 1) {
                                            check = true;
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
                                    }
                                    if (!check) {
                                %>
                                <tr>
                                    <td style="padding: 50px" colspan="4">Vide</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="div-box enseignant">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <table>
                            <thead>
                                <tr>
                                    <th>Module</th>
                                    <th>Nom Enseignant</th>
                                    <th>Note Normal</th>
                                    <th>Note Rattrapage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    check = false;
                                    for (Note note : notes) {
                                        long semestre = note.getModuleNom().getSemestre().longValue();
                                        if (semestre == 2) {
                                            check = true;
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
                                    }
                                    if (!check) {
                                %>
                                <tr>
                                    <td style="padding: 50px" colspan="4">Vide</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="div-box admin">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <table>
                            <thead>
                                <tr>
                                    <th>Module</th>
                                    <th>Nom Enseignant</th>
                                    <th>Note Normal</th>
                                    <th>Note Rattrapage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    check = false;
                                    for (Note note : notes) {
                                        long semestre = note.getModuleNom().getSemestre().longValue();
                                        if (semestre == 3) {
                                            check = true;
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
                                    }
                                    if (!check) {
                                %>
                                <tr>
                                    <td style="padding: 50px" colspan="4">Vide</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="div-box module">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <table>
                            <thead>
                                <tr>
                                    <th>Module</th>
                                    <th>Nom Enseignant</th>
                                    <th>Note Normal</th>
                                    <th>Note Rattrapage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    check = false;
                                    for (Note note : notes) {
                                        long semestre = note.getModuleNom().getSemestre().longValue();
                                        if (semestre == 4) {
                                            check = true;
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
                                    }
                                    if (!check) {
                                %>
                                <tr>
                                    <td style="padding: 50px" colspan="4">Vide</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <%
            request.setAttribute("active", "RDN");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>
