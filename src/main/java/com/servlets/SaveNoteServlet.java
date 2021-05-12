package com.servlets;


import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            String title=request.getParameter("title");
            String content=request.getParameter("content");
            Note note =new Note(title,content,new Date());
           //System.out.println(note.getId()+":"+note.getTitle());
            // Hibernate :save()
            Session s=FactoryProvider.getFactory().openSession();
            Transaction tx=s.beginTransaction();
            s.save(note);
            tx.commit();
            s.close();
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            response.sendRedirect("all_notes.jsp");
//            out.println("<h1 style='text-align:center;'>Note is added successfully</h1>");
//            out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'</h1>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
