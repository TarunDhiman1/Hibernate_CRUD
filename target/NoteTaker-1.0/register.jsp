<%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 15-10-2021
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="parent">
    <div class="child">
    <h2 class="text-center my-3"><strong>Add User Here</strong></h2>
    <form action="RegisterServlet" method="post">
        <div class="form-group">
            <label for="email">User Email</label>
            <input name="user_email" required type="email" class="form-control" id="email" placeholder="Enter your email here" aria-describedby="emailHelp" >
        </div>
        <div class="form-group">
            <label for="name">User Name</label>
            <input name="user_name" required type="text" class="form-control" id="name" placeholder="Enter your name here" aria-describedby="emailHelp" >
        </div>
        <div class="form-group">
            <label for="password" >User Password</label>
            <input name="user_password" type="password" required class="form-control" id="password" placeholder="Enter your password" aria-describedby="emailHelp" >
        </div>
        <a href="login.jsp" class="text-center d-block mb-2 link">If Already a User Click Here</a>
        <div class="container text-center">
            <button id="register">Register</button>
            <button type="reset" id="reset">Reset</button>
        </div>
    </form>
    </div>
</div>
</body>
</html>
