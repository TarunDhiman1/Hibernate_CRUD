<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="com.entities.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.User" %>
<%@ page import="com.entities.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Note: Note Taker</title>
    <%@include file="all_js_css.jsp"%>
</head>
<%
    HttpSession httpSession = request.getSession();
    User user = (User) httpSession.getAttribute("current-User");
    if(user==null){
        out.println("YOU NEED TO SIGN IN TO DISPLAY NOTES");
    }
    else{
        Session s= FactoryProvider.getFactory().openSession();
        UserDao userDao =new UserDao(FactoryProvider.getFactory());
%>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h1>All Notes:</h1>
    <div class="row">
        <div class="col-12">
            <%
                List<Note> list= userDao.getNotesbyUserId(user.getUserId());
                if(list.isEmpty()){
            %>
                  <h3>You dont have Notes &nbsp;&nbsp;<a href="add_notes.jsp">Click here to Add</a></h3>
            <%
                }
                for (Note note: list){
            %>
            <div class="card mt-3">
                <img class="card-img-top m-4 mx-auto" src="img/writing.png" style="max-width: 100px" alt="Card image cap">
                <div class="card-body px-5">
                    <h5 class="card-title"><%=note.getTitle()%></h5>
                    <p class="card-text">
                        <%=note.getContent()%>
                    </p>
                    <c:set var = "now" value = "<%=note.getAddedDate()%>" />
                    <p><b class="text-primary">Added Date: <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}"/></b></p>
                    <div class="container text-center">
                    <a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete Note</a>
                    <a href="edit.jsp?note_id=<%=note.getId()%>" class="btn btn-primary">Update</a>
                    </div>
            </div>
            <%
                }
                s.close();
                }
            %>
        </div>
        </div>
</div>
</div>
</body>
</html>
