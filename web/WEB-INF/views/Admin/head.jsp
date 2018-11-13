
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/MasterM2I/static/css/css.css"/>
<script src="/MasterM2I/static/js/js.js"></script>
<ul>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        //response.setHeader("Pragma", "no-cache");
        //response.setHeader("Expires", "0");
        String active = (String) request.getAttribute("active");
    %>
    <li>
        <form action="/MasterM2I/Admin" method="POST">
            <button class="button info<%= active.equals("Admin") ? " active" : ""%>" type="">Home</button>
        </form>            </li>
    <li>
        <form action="/MasterM2I/Admin/Create" method="POST">
            <button class="button info<%= active.equals("Create") ? " active" : ""%>">Create</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Admin/Update" method="POST">
            <button class="button info<%= active.equals("Update") ? " active" : ""%>" type="">Update</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Admin/Delete" method="POST">
            <button class="button info<%= active.equals("Delete") ? " active" : ""%>" type="">Delete</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Admin/Inscription" method="POST">
            <button class="button info<%= active.equals("Inscription") ? " active" : ""%>" type="">Inscription</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Admin/Reinscription" method="POST">
            <button class="button info<%= active.equals("Reinscription") ? " active" : ""%>" type="">Reinscription</button>
        </form>
    </li>
    <li style="float: right;">
        <form action="/MasterM2I/logout" method="post">
            <input type="hidden" name="operation" value="logout">
            <input type="hidden" name="user" value="etudiant">
            <button class="button info" type="submit">Log Out</button>
        </form>
    </li>
</ul>