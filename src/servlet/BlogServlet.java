package servlet;

import dao.BlogDao;
import dao.BlogDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "blog",urlPatterns = "/blog")
public class BlogServlet extends HttpServlet {

    BlogDaoImpl bd = new BlogDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        String name  = req.getParameter("user");
        String birth = bd.getUserBirth(name);
        req.setAttribute("name",name);
        req.setAttribute("birth",birth);
        req.getRequestDispatcher("/blog.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }
}
