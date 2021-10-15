<%@ page import="com.entities.User" %><%
    User user1 = (User) session.getAttribute("current-User");
%>
<nav class="navbar navbar-expand-lg navbar-dark blue_light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Note Taker</a>
        <%
            if(user1==null){
        %>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add_notes.jsp">Add Note</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="all_notes.jsp" tabindex="-1" aria-disabled="true">Show Notes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp" style="cursor: pointer;">Log In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp" style="cursor: pointer;">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%
} else{
%>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="add_notes.jsp">Add Note</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="all_notes.jsp" tabindex="-1" aria-disabled="true">Show Notes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" style="cursor: pointer;">Welcome <%=user1.getUserName()%></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet" style="cursor: pointer;">Log out</a>
        </li>
    </ul>
</div>
</div>
</nav>
<%
    }
%>