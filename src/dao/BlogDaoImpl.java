package dao;

import bean.Article;
import bean.User;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogDaoImpl implements BlogDao {
    @Override
    public Boolean userMapping(String user, String pwd) {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from user where name = ? and pwd = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean flag = true;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs!=null){
                flag = true;
            }else{
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void addUser(User u) {

    }

    @Override
    public void addArticle(Article a) {

    }

    @Override
    public void deleteArticle(int id) {

    }

    @Override
    public void updateArticle(int id) {

    }

    @Override
    public List<Article> searchArticle(String info) {
        return null;
    }

    @Override
    public List<Article> listArticles() {
        return null;
    }
}
