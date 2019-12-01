package servlet;

import bean.Article;
import dao.BlogDaoImpl;
import service.BlogService;
import service.BlogServiceImpl;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "article",urlPatterns = "/article/*")
public class ArticleServlet extends HttpServlet {

    BlogService bd = new BlogServiceImpl();
    //BlogDaoImpl bd = new BlogDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlPattern = req.getRequestURI();
        String[] url = urlPattern.split("/");
        String methodName = url[3];
        System.out.println(methodName);
        UUID uuid = UUID.randomUUID();
        try {
            //利用反射获取url要调用的方法名
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 在主页显示所有博文
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public void showArticles(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        List<Article> list = bd.listArticlesService();
        request.getServletContext().setAttribute("list",list);
        request.getRequestDispatcher("/blog.jsp").forward(request,response);

    }

    public List<Article> showMainArticles(HttpServletRequest request,HttpServletResponse response) throws Exception{


        return null;
    }

    /**
     * 提交文章方法
     * @param request
     * @param response
     * @throws Exception
     */
    public void submit(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        String path = (String)request.getServletContext().getAttribute("path");
        String name = request.getParameter("user");
        System.out.println(name);
        request.getServletContext().setAttribute("user",name);
        String title = request.getParameter("title");
        Date date = new Date();
        int view = 0;
        int comment = 0;
        String writing = request.getParameter("markdown");
        String hwriting = request.getParameter("essay");
        Article a = new Article(name,view,date,title,writing,hwriting,comment);
        bd.addArticleService(a);

        request.getRequestDispatcher("/blog").forward(request,response);
    }

    public void show(HttpServletRequest request,HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        int id;
        if(request.getParameter("id") == null){
            id =(int)request.getServletContext().getAttribute("id");
            System.out.println(id);
        }else{
            id = Integer.valueOf(request.getParameter("id"));
            System.out.println(id);
        }
        Article a = bd.getArticleService(id);
        //更新文章的访问量,每有一次该请求更新一次。
        int view = a.getViewCount();
        view = view+1;
        System.out.println(view);
        bd.updateViewService(view,id);
        a.setViewCount(view);
        request.getServletContext().setAttribute("article",a);
        response.sendRedirect(request.getContextPath()+"/Article.jsp");
    }

    public void delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        int id = Integer.valueOf(request.getParameter("id"));
        Article a = bd.getArticleService(id);
        String name = a.getUser();
        System.out.println(name);
        System.out.println(id);
        bd.deleteArticleService(id);
        request.getServletContext().setAttribute("user",name);
        //request.getRequestDispatcher("/blog").forward(request,response);
         response.sendRedirect(request.getContextPath()+"/blog");

    }

    public void update1(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        int id = Integer.valueOf(request.getParameter("id"));
        Article a = bd.getArticleService(id);
        request.setAttribute("article",a);
        request.getRequestDispatcher("/updateArticle.jsp").forward(request,response);


    }

    public void update2(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        int id = Integer.valueOf(request.getParameter("id"));
        Article a = bd.getArticleService(id);
        String title = request.getParameter("title");
        String writing = request.getParameter("writing");
        String hwriting = request.getParameter("hwriting");
        bd.updateArticleService(id,title,writing,hwriting);
        request.getServletContext().setAttribute("id",id);
        response.sendRedirect(request.getContextPath()+"/article/show");
    }

    public void search(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        String info = request.getParameter("info");
        System.out.println(info);
        List<Article> list = bd.searchArticleService(info);
        request.getServletContext().setAttribute("infoList",list);
        response.sendRedirect(request.getContextPath()+"/searchArticle.jsp");
        //request.getRequestDispatcher("/searchArticle.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
