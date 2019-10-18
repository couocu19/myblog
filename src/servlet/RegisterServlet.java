package servlet;

import bean.User;
import service.BlogService;
import service.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "register",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    BlogService bs = new BlogServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        Date time = null;
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        SimpleDateFormat fomater = new SimpleDateFormat( "yyyy-MM-dd");
        String date = req.getParameter("date");

        try {
            time =  fomater.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User u = new User(user,pwd,time);
        bs.addUserService(u);

//        UploadFileServlet up = new UploadFileServlet();
//        up.service(req,resp);

        resp.sendRedirect("uploadphoto.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
