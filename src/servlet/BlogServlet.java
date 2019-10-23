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
        String name  = (String)req.getServletContext().getAttribute("user");
        System.out.println(name);
        String birth = bd.getUserBirth(name);
        String path = bd.getImagePath(name);
        req.getServletContext().setAttribute("name",name);
        req.getServletContext().setAttribute("birth",birth);
        req.getServletContext().setAttribute("path",path);
        resp.sendRedirect("blog.jsp");
        //req.getRequestDispatcher("blog.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }
}
