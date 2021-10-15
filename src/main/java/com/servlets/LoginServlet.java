package com.servlets;

import com.entities.User;
import com.entities.UserDao;
import com.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDao userDao = new UserDao(FactoryProvider.getFactory());
            User user=userDao.getUserByEmailandPassword(email,password);  //this is returning basically user object
            HttpSession httpSession=request.getSession();
            if(user == null){
                //user does not exist
                httpSession.setAttribute("message1", "Invalid User Try Again");
                response.sendRedirect("login.jsp");
                return;
            }
                httpSession.setAttribute("current-User", user);
                response.sendRedirect("all_notes.jsp");
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
