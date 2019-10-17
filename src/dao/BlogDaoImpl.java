package dao;

import bean.Article;
import bean.User;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import jdk.nashorn.internal.scripts.JD;
import org.omg.CORBA.ARG_IN;
import util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            ps.setString(1,user);
            ps.setString(2,pwd);
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
        Connection con = JDBCUtil.getConnection();
        String sql = "insert into user (name,pwd,birth) values (?,?,?) ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getName());
            ps.setString(2,u.getPwd());
            //???咋回事呢这里
            ps.setObject(3,u.getDate());
//            //感觉这里会出问题
 //          ps.setBinaryStream(4,u.getPhoto(),u.getPhoto().available());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public String getUserBirth(String name){
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from user where name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Date time = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1,name);
            rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()) {
                     time = rs.getDate("birth");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Date类型转为字符串类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String birth = sdf.format(time);

        return birth;
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

    //展示所有博文
    @Override
    public List<Article> listArticles()
    {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from articles";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> articles = null;
        Article a = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs!=null){
                articles = new ArrayList<>();
                while(rs.next()){
                    String user = rs.getString("user");
                    int commentcount = rs.getInt("commentcount");
                    Date date = rs.getDate("time");
                    int viewcount = rs.getInt("viewcount");
                    String title = rs.getString("title");
                    a = new Article(user,title,viewcount,commentcount,date);
                    articles.add(a);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;

    }
}
