package servlet;

import bean.Article;
import dao.BlogDao;
import dao.BlogDaoImpl;
import service.BlogService;
import service.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "login",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    BlogDaoImpl bd = new BlogDaoImpl();
    BlogService bs = new BlogServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        String user = req.getParameter("user");
        System.out.println(user);
        String pwd = req.getParameter("pwd");
        System.out.println(pwd);
        if(user!=""&& pwd!="") {
            if (bd.userMapping(user, pwd)) {
                System.out.println("ok");
                req.getServletContext().setAttribute("user",user);
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                List<Article> list = bd.listArticles();
                req.getServletContext().setAttribute("list", list);
                req.getRequestDispatcher("/blog").forward(req, resp);
            } else {
                String msg = "用户名或者密码错误！";
                req.setAttribute("msg",msg);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
        }else{
            String msg = "请将登录信息填写完整！";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
