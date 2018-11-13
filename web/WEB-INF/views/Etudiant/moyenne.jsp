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

        <div id="container" style="width:700px;margin-top: 50px; height:100%;">
            <div>
                <div id="box">
                    <div style="padding:20px;margin-top:30px;">
                        <%
                            double s1 = 0;
                            double s2 = 0;
                            double s3 = 0;
                            double s4 = 0;
                            int count_s1 = 0;
                            int count_s2 = 0;
                            int count_s3 = 0;
                            int count_s4 = 0;
                            List<Note> notes = (List<Note>) request.getAttribute("Notes");
                            for (Note note : notes) {
                                Double sn = note.getSn();
                                Double sr = note.getSr();
                                int semestre = note.getModuleNom().getSemestre();
                                if (semestre == 1) {
                                    if (sn != null && sn < 10.0) {
                                        count_s1++;
                                    }
                                    s1 += sn == null ? 0 : sr == null ? sn : sn > sr ? sn : sr;
                                } else if (semestre == 2) {
                                    s2 += sn == null ? 0 : sr == null ? sn : sn > sr ? sn : sr;
                                } else if (semestre == 3) {
                                    s3 += sn == null ? 0 : sr == null ? sn : sn > sr ? sn : sr;
                                } else if (semestre == 4) {
                                    s4 += sn == null ? 0 : sr == null ? sn : sn > sr ? sn : sr;
                                }
                            }
                            String annee1 = String.format("%.2f", ((s1 / 6) + (s2 / 6)) / 2);
                            String annee2 = String.format("%.2f", ((s3 / 6) + s4) / 2);

                            String S1 = String.format("%.2f", (s1 / 6));
                            String S2 = String.format("%.2f", (s2 / 6));
                            String S3 = String.format("%.2f", (s3 / 6));
                            String S4 = String.format("%.2f", s4);

                        %>
                        <table>
                            <thead>
                                <tr>
                                    <th>S1</th>
                                    <th>S2</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=S1%></td>
                                    <td><%=S2%></td>
                                </tr>
                            </tbody>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>Première Année</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=annee1%></td>
                                </tr>
                            </tbody>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>S3</th>
                                    <th>S4</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=S3%></td>
                                    <td><%=S4%></td>
                                </tr>
                            </tbody>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>Deuxiéme Année</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=annee2%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%
            request.setAttribute("active", "Moyenne");
        %>
        <%@include  file="head.jsp" %>

    </body>
</html>

