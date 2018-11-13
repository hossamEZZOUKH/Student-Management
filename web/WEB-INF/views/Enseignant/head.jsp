<%@page import="com.spring.entities.Module"%>
<%@page import="com.spring.entities.Note"%>

<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/MasterM2I/static/css/css.css"/>
<script src="/MasterM2I/static/js/js.js"></script>
<ul>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        String active = (String) request.getAttribute("active");
        Note notee = (Note) request.getAttribute("note");
        String modulee = (String) request.getAttribute("module");
    %>

    <li>
        <form action="/MasterM2I/Enseignant" method="POST">
            <button class="button info<%= active.equals("Enseignant") ? " active" : ""%>" type="">Home</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Enseignant/ConsulterModule=${module}" method="POST">
            <button class="button info<%= active.equals("ConsulterModule") ? " active" : ""%>">Consultation</button>
        </form>
    </li>

    <li>
        <form action="/MasterM2I/Enseignant/InsertNote=${module}" method="POST">
            <button class="button info<%= active.equals("InsertNote") ? " active" : ""%>">Insértion</button>
        </form>
    </li>
    <%
        if (notee != null) {
    %>
    <li>
        <form action="/MasterM2I/Enseignant/UpdateNoteEtudiant" method="POST">
            <input type="hidden" name="module" value="${module}"/>
            <input type="hidden" name="cne" value="${cne}"/>
            <button class="button info<%= active.equals("UpdateNoteEtudiant") ? " active" : ""%>">Update</button>
        </form>
    </li>
    <%
        }
    %>

    <li>
        <form action="/MasterM2I/Enseignant/XML" method="POST">
            <button class="button info<%= active.equals("XML") ? " active" : ""%>">XML<%=modulee == null ? "" : " : " + modulee%></button>
        </form>
    </li>
    <li style="float: right;">
        <form action="/MasterM2I/logout" method="POST">
            <input type="hidden" name="operation" value="logout">
            <input type="hidden" name="user" value="etudiant">
            <button class="button info" type="submit">Log Out</button>
        </form>
    </li>
</ul>