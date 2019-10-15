package bean;

public class Comment {

    private int id;
    private String title;
    private String comment;

    public Comment(int id, String title, String comment) {
        this.id = id;
        this.title = title;
        this.comment = comment;
    }

    public Comment(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public Comment(){

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
