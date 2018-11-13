<%-- 
    Document   : RDN
    Created on : 17 févr. 2018, 22:10:43
    Author     : crazy
--%>

<%@page import="java.util.ArrayList"%>
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
        <div id="container" style="width:700px;margin-top: 50px;height: 100%;">
            <div id="btnContainer">
                <button class="button buttonButton info active" onclick="selection('etudiant')">S1</button>
                <button class="button buttonButton info" onclick="selection('enseignant')">S2</button>
                <button class="button buttonButton info" onclick="selection('admin')">S3</button>
                <button class="button buttonButton info" onclick="selection('module')">S4</button>
            </div>

            <div class="div-box etudiant">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <%
                            List<Note> notesS1 = new ArrayList();
                            List<Note> notesS2 = new ArrayList();
                            List<Note> notesS3 = new ArrayList();
                            List<Note> notesS4 = new ArrayList();
                            if (notes != null && !notes.isEmpty()) {
                                for (Note note : notes) {
                                    long semestre = note.getModuleNom().getSemestre().longValue();
                                    if (semestre == 1) {
                                        notesS1.add(note);
                                    } else if (semestre == 2) {
                                        notesS2.add(note);
                                    } else if (semestre == 3) {
                                        notesS3.add(note);
                                    } else if (semestre == 4) {
                                        notesS4.add(note);
                                    }
                                }
                            }
                            if (!notesS1.isEmpty()) {
                        %>
                        <div class="xml">
                            <xmp><?xml version="1.0" encoding="UTF-8"?><%=Note.toDocumentXML(notesS1)%>
                            </xmp>
                        </div>
                        <%
                        } else {
                        %>
                        <div>
                            Vide
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="div-box enseignant">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <%
                            if (!notesS2.isEmpty()) {
                        %>
                        <div class="xml">
                            <xmp><?xml version="1.0" encoding="UTF-8"?><%=Note.toDocumentXML(notesS2)%>
                            </xmp>
                        </div>
                        <%
                        } else {
                        %>
                        <div>
                            Vide
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="div-box admin">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <%
                            if (!notesS3.isEmpty()) {
                        %>
                        <div class="xml">
                            <xmp><?xml version="1.0" encoding="UTF-8"?><%=Note.toDocumentXML(notesS3)%>
                            </xmp>
                        </div>
                        <%
                        } else {
                        %>
                        <div>
                            Vide
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="div-box module">
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <%
                            if (!notesS4.isEmpty()) {
                        %>
                        <div class="xml">
                            <xmp><?xml version="1.0" encoding="UTF-8"?><%=Note.toDocumentXML(notesS4)%>
                            </xmp>
                        </div>
                        <%
                        } else {
                        %>
                        <div>
                            Vide
                        </div>
                        <%
                            }
                        %>
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
