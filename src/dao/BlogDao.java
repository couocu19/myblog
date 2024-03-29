package dao;

import bean.Article;
import bean.User;

import java.util.List;

public interface BlogDao {

    //登录处理
    Boolean userMapping(String user,String pwd);
    //增加用户处理
    void addUser(User u);
    //增加博文处理
    void addArticle(Article a);
    void deleteArticle(int id);
    void updateArticle(int id,String title,String writing,String hwriting);
    //查找博文
    List<Article> searchArticle(String info);
    //列举所有博文
    List<Article> listArticles();
    Article getArticle(int id);
    //更新文章访问量
    void updateView(int view,int id);

}
