<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Note Taker : Home Page</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <div class="card py-5">
        <div id="anim"></div>
        <h1 class="text-primary text-uppercase text-center mt-3">Start Taking your Notes</h1>
        <div class="container text-center">
        <button class="btn btn-outline-primary text-center"><a href="add_notes.jsp">Start Here</a></button>
        </div>
    </div>
</div>
<br>
<script src="js/script.js"></script>
<script src="js/lottie.js"></script>
</body>
</html>