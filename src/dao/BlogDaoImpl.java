package dao;

import bean.Article;
import bean.User;
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
            if(rs.next()){
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
        Connection con = JDBCUtil.getConnection();
        String sql = "insert into articles (user,writing,commentcount,time,viewcount,title,hwriting) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,a.getUser());
            ps.setString(2,a.getWriting());
            ps.setInt(3,a.getCommentCount());
            //Date类型的相互转化
            java.sql.Date sqlDate=new java.sql.Date(a.getDate().getTime());
            ps.setDate(4,sqlDate);
            ps.setInt(5,a.getViewCount());
            ps.setString(6,a.getTitle());
            ps.setString(7,a.getHwriting());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteArticle(int id) {
        Connection con = JDBCUtil.getConnection();
        String sql = "delete from articles where id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateArticle(int id,String title,String writing,String hwriting) {
        Connection con = JDBCUtil.getConnection();
        String sql = "update articles set title = ?,writing = ?,hwriting = ? where id = ?";
        //String sql1 = "update articles set title = ?,hwriting = ? where id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,writing);
            ps.setString(3,hwriting);
            ps.setInt(4,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Article> searchArticle(String info) {
        List<Article> list = null ;
        Connection con = JDBCUtil.getConnection();
        //模糊查询
        String sql = "SELECT * FROM articles WHERE title or writing LIKE ?";
        //String sql = "select * from articles where match (title,writing) against (?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"%"+info+"%");
            rs = ps.executeQuery();
            if(rs!=null){
                list = new ArrayList<>();
                while(rs.next()){
                    Article a = pGetArticle(rs);
                    list.add(a);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
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
                    a = pGetArticle(rs);
                    articles.add(a);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;

    }

    //通过数据库的结果获取某个Article的所有信息
    private Article pGetArticle(ResultSet rs){
        Article a = null;
        try {
            int id = rs.getInt("id");
            String user = rs.getString("user");
            String writing = rs.getString("writing");
            String title = rs.getString("title");
            String hwriting = rs.getString("hwriting");
            int commentCount = rs.getInt("commentCount");
            int viewCount = rs.getInt("viewCount");
            java.sql.Date date = rs.getDate("time");
            java.util.Date Udate = new java.util.Date(date.getTime());
            a = new Article(id,user,viewCount,Udate,writing,hwriting,commentCount,title);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Article getArticle(int id){
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from articles where id = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Article a = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                String user = rs.getString("user");
                String writing = rs.getString("writing");
                String hwriting = rs.getString("hwriting");
                int viewCount = rs.getInt("viewcount");
                int commentCount = rs.getInt("commentCount");
                Date date = rs.getDate("time");
                String title = rs.getString("title");
                a = new Article(id,user,viewCount,date,writing,hwriting,commentCount,title);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;


    }
}


