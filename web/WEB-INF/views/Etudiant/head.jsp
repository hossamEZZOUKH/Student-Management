
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
    %>
    <li>
        <form action="/MasterM2I/Etudiant" method="POST">
            <button class="button info<%= active.equals("Etudiant") ? " active" : ""%>" type="">Home</button>
        </form>            </li>
    <li>
        <form action="/MasterM2I/Etudiant/Attestation" method="POST">
            <button class="button info<%= active.equals("Attestation") ? " active" : ""%>">Attestation</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Etudiant/RDN" method="POST">
            <button class="button info<%= active.equals("RDN") ? " active" : ""%>" type="">RDN</button>
        </form>
    </li>
    <li>
        <form action="/MasterM2I/Etudiant/Moyenne" method="POST">
            <button class="button info<%= active.equals("Moyenne") ? " active" : ""%>" type="">Moyenne</button>
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

