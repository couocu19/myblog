package servlet;

import bean.Article;
import bean.User;
import dao.BlogDaoImpl;
import service.BlogService;
import service.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "register",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    BlogService bs = new BlogServiceImpl();
    BlogDaoImpl bd = new BlogDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        Date time = null;
        String user = req.getParameter("name");
//        System.out.println(user);
        String pwd = req.getParameter("pwd");
        SimpleDateFormat fomater = new SimpleDateFormat( "yyyy-MM-dd");
        String date = req.getParameter("date");
        try {
            time =  fomater.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("name",user);
        User u = new User(user,pwd,time);
        bs.addUserService(u);

        List<Article> list = bd.listArticles();
        req.getServletContext().setAttribute("list",list);

        req.getRequestDispatcher("/uploadphoto.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
