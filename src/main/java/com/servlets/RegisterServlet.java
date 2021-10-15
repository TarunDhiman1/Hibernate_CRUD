package com.servlets;

import com.entities.User;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            try {
                String userName=request.getParameter("user_name");
                String userEmail=request.getParameter("user_email");
                String userPassword=request.getParameter("user_password");

                HttpSession httpSession=request.getSession();
                //validation
                if(userName==null){
                    httpSession.setAttribute("message1", "User Name Cannot be Null");
                    response.sendRedirect("login.jsp");
                }
                else{
                    User user = new User(userEmail,userName,userPassword);
                    Session session = FactoryProvider.getFactory().openSession();
                    Transaction transaction = session.beginTransaction();
                    int userId= (int)session.save(user);
                    transaction.commit();
                    session.close();
                    httpSession.setAttribute("current-User",user);
                    response.sendRedirect("all_notes.jsp");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }
}


