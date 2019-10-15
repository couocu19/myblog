package bean;


import java.util.Date;

public class Article {
    private int id;
    private String writer;
    private String title;
    private int viewCount;
    private int commentCount;
    private Date time;

    public Article(int id, String writer, String title, int viewCount, int commentCount, Date time) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.time = time;
    }

    public Article(String writer, String title, int viewCount, int commentCount, Date time) {
        this.writer = writer;
        this.title = title;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Article(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
