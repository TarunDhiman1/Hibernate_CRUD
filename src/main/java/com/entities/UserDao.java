package com.entities;

import com.helper.FactoryProvider;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    private SessionFactory factory;

    public UserDao(SessionFactory factory){
        this.factory=factory;
    }
    public UserDao() {
    }
    public User getUserByEmailandPassword(String email, String password) {
        User user = null;
        try {
            //validation if the user exists
            Session session = this.factory.openSession();
            String q = "from User where userEmail=: e and userPassword=: p";
            Query query = (Query) session.createQuery(q);
            query.setParameter("e", email);
            query.setParameter("p", password);
            user = (User) query.uniqueResult();
            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public List<Note> getNotesbyUserId(int userId){
        List<Note> note=null;
        try{
            //Session session = this.factory.openSession();
            Session session = FactoryProvider.getFactory().openSession();
            String q = "from Note where user.userId=:i";
            Query query =(Query) session.createQuery(q);
            query.setParameter("i",userId);
            note=query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return note;
    }
//    public void deleteNotebyId(int Id){
//        Session session = FactoryProvider.getFactory().openSession();
//        String q= "delete from myhiber.note where id=:i";
//        SQLQuery query = session.createSQLQuery(q);
//        query.setParameter("i",Id);
//    }
}
