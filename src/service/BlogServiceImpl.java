package service;

import bean.Article;
import bean.User;
import dao.BlogDao;
import dao.BlogDaoImpl;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    BlogDao bd = new BlogDaoImpl();

    @Override
    public Boolean userMappingService(String user, String pwd) {

        return bd.userMapping(user,pwd);
    }

    @Override
    public void addUserService(User u) {
        bd.addUser(u);
    }

    @Override
    public void addArticleService(Article a) {
        bd.addArticle(a);
    }

    @Override
    public void deleteArticleService(int id) {
        bd.deleteArticle(id);
    }

    @Override
    public void updateArticleService(int id,String title,String writing,String hwriting) {
        bd.updateArticle(id,title,writing,hwriting);

    }

    @Override
    public List<Article> searchArticleService(String info) {
        return  bd.searchArticle(info);
    }

    @Override
    public List<Article> listArticlesService() {
        return bd.listArticles();
    }

    public Article getArticleService(int id){
        return bd.getArticle(id);
    }

    @Override
    public void updateViewService(int view, int id) {
        bd.updateView(view,id);
    }
}
