<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.entities.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Note</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <h1>Edit your Note</h1>
    <br>
    <%
        int noteId=Integer.parseInt(request.getParameter("note_id").trim());
        Session s= FactoryProvider.getFactory().openSession();
        Note note=(Note)s.get(Note.class,noteId);
    %>
    <form action="UpdateServlet" method="post">
        <input value="<%=note.getId()%>" name="noteId" type="hidden"/>
        <div class="mb-3">
            <label for="title" class="form-label">Note Title</label>
            <input
                    name="title"
                    required
                    type="text"
                    class="form-control"
                    id="title"
                    placeholder="Enter here"
                    value="<%=note.getTitle()%>"
                    aria-describedby="emailHelp"/>
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Note Content</label>
            <textarea
                    name="content"
                    required
                    id="content"
                    placeholder="Enter your Content here"
                    class="form-control"
                    style="height: 300px"
            ><%=note.getContent()%></textarea>
        </div>
        <div class="container text-center">
            <button type="submit" class="btn btn-success">Save your Note</button>
        </div>
    </form>
</div>
</body>
</html>
