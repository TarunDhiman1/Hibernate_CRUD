package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    public DeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           int noteId=Integer.parseInt(request.getParameter("note_id").trim());
           Session s= FactoryProvider.getFactory().openSession();
           Transaction tx=s.beginTransaction();
           Note note=(Note) s.get(Note.class,noteId);
           s.delete(note);
           tx.commit();
           s.close();
           response.sendRedirect("all_notes.jsp");
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
