<%-- 
    Document   : index
    Created on : 22 janv. 2018, 13:21:21
    Author     : hunter
--%>

<%@page import="com.spring.entities.Note"%>
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
            <div class="xml">

                <%
                    List<Note> notes = (List<Note>) request.getAttribute("Notes");
                    if (notes != null && !notes.isEmpty()) {
                %>

                <xmp><?xml version="1.0" encoding="UTF-8"?><%=Note.toDocumentXML(notes)%>
                </xmp>
                <%
                    }
                %>
            </div>
        </div>

        <%
            request.setAttribute("active", "XML");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>
