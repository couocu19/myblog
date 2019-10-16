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

    }

    @Override
    public void deleteArticleService(int id) {

    }

    @Override
    public void updateArticleService(int id) {

    }

    @Override
    public List<Article> searchArticleService(String info) {
        return null;
    }

    @Override
    public List<Article> listArticlesService() {
        return null;
    }
}
