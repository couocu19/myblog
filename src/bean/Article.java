package bean;


import java.util.Date;

public class Article {
    private int id;
    private String user;
    private int viewCount;
    private Date date;
    private String writing;
    private String hwriting;
    private int commentCount;
    //文章标题
    private String title;

    public Article(String user, int viewCount, Date date, String title,String writing,String hwriting,int commentCount) {
        this.user = user;
        this.viewCount = viewCount;
        this.date = date;
        this.title = title;
        this.writing = writing;
        this.hwriting = hwriting;
        this.commentCount = commentCount;
    }

    public Article(){

    }

    public Article(int id, String user, int viewCount, Date date, String writing, String hwriting, int commentCount, String title) {
        this.id = id;
        this.user = user;
        this.viewCount = viewCount;
        this.date = date;
        this.writing = writing;
        this.hwriting = hwriting;
        this.commentCount = commentCount;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getHwriting() {
        return hwriting;
    }

    public void setHwriting(String hwriting) {
        this.hwriting = hwriting;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}