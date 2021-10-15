package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    public UpdateServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String title=request.getParameter("title");
            String content=request.getParameter("content");

            Session s= FactoryProvider.getFactory().openSession();
            int noteId=Integer.parseInt(request.getParameter("noteId").trim());
            Transaction tx=s.beginTransaction();
            Note note=s.get(Note.class,noteId);
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());
            tx.commit();
            s.close();
            response.sendRedirect("all_notes.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
