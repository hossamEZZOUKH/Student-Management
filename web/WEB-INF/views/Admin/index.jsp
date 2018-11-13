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
        <title>Admin Page</title>
    </head>
    <body>
        <div style="padding:20px;margin-top:50px;">
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>CIN</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <%=session.getAttribute("user")%>
                </tbody>
            </table>
        </div>

        <%
            request.setAttribute("active", "Admin");
        %>
        <%@include  file="head.jsp" %>
    </body>
</html>
