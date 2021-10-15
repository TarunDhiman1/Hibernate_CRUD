package com.servlets;


import com.entities.Note;
import com.entities.User;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SaveNoteServlet", value = "/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    public SaveNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //title,content fetch
            HttpSession httpSession = request.getSession();
            User user = (User) httpSession.getAttribute("current-User");

            String title=request.getParameter("title");
            String content=request.getParameter("content");
            Note note =new Note(title,content,new Date());
            note.setUser(user);

            Session s=FactoryProvider.getFactory().openSession();
            Transaction tx=s.beginTransaction();
            s.save(note);
            tx.commit();
            s.close();

            response.sendRedirect("all_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
