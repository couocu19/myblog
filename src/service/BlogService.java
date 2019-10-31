package service;

import bean.Article;
import bean.User;

import java.util.List;

public interface BlogService {
    //登录处理
    Boolean userMappingService(String user,String pwd);
    //增加用户处理
    void addUserService(User u);

    //增加博文处理
    void addArticleService(Article a);

    void deleteArticleService(int id);
    void updateArticleService(int id,String title,String writing,String hwriting);

    //查找博文
    List<Article> searchArticleService(String info);

    //列举所有博文
    List<Article> listArticlesService();

   void updateViewService(int view,int id);

    Article getArticleService(int id);
}
