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
        String pwd = req.getParameter("pwd");
        req.getServletContext().setAttribute("user",user);
        req.getServletContext().setAttribute("pwd",pwd);
        if(bs.userMappingService(user,pwd)){
            List<Article> list = bd.listArticles();
            req.getServletContext().setAttribute("list",list);
          req.getRequestDispatcher("/blog").forward(req,resp);
        }else{
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
