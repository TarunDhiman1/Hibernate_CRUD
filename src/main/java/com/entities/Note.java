package com.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
public class Note {
    @Id
    private int id;
    private String title;
    @Column(length = 1500)
    private String content;
    private Date addedDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Note( String title, String content, Date addedDate) {
        super();
        //random id will be created
        this.id = new Random().nextInt(100000);
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
    }
    public Note() {
        super();
    }
}
