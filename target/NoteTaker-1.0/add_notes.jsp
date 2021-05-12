<%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 12-05-2021
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h1>Please fill your Notes Detail</h1>
    <br>
    <%--This is Add Form--%>
    <form action="SaveNoteServlet" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Note Title</label>
            <input
                    name="title"
                    required
                    type="text"
                    class="form-control"
                    id="title"
                    placeholder="Enter here"
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
            ></textarea>
        </div>
            <div class="container text-center">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
    </form>
</div>
</body>
</html>
