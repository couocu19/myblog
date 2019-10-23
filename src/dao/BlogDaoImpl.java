package dao;

import bean.Article;
import bean.User;
import org.apache.commons.fileupload.FileItem;
import util.JDBCUtil;

import java.io.*;
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
    //注册用户信息

    @Override
    public void addUser(User u) {
        Connection con = JDBCUtil.getConnection();
        String sql = "insert into user (name,pwd,birth) values (?,?,?) ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getName());
            ps.setString(2,u.getPwd());
            ps.setObject(3,u.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //上传用户头像
    public void uploadImage(String path,String name){
        Connection con = JDBCUtil.getConnection();
//        InputStream in = null;
        String sql = "insert into imagepath (name,path) values (?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,path);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    //从数据库获取用户头像....好像不需要这个函数
    public String getImagePath(String name){
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from imagepath where name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream in = null;
        String path = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()){
                path = rs.getString("path");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return path;

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
//                    a = new Article(user,title,viewcount,commentcount,date);
                    articles.add(a);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;

    }
}
