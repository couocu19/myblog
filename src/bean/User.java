package bean;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private String pwd;
    private Date date;
    private InputStream photo;

//    public User(int id, String name, String pwd, Date date) {
//        this.id = id;
//        this.name = name;
//        this.pwd = pwd;
//        this.date = date;
//    }


    public User(String name, String pwd, Date date, InputStream photo) {
        this.name = name;
        this.pwd = pwd;
        this.date = date;
        this.photo = photo;
    }

    public User(String name, String pwd, Date date) {
        this.name = name;
        this.pwd = pwd;
        this.date = date;
    }

    public User(){

    }

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
