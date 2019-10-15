package bean;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String pwd;
    private Date date;

    public User(int id, String name, String pwd, Date date) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.date = date;
    }

    public User(String name, String pwd, Date date) {
        this.name = name;
        this.pwd = pwd;
        this.date = date;
    }

    public User(){

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
