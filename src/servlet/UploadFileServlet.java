package servlet;

import com.jspsmart.upload.SmartUpload;
import dao.BlogDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.UUID;

import java.util.List;


@WebServlet(name="upload",urlPatterns = "/upload")
public class UploadFileServlet extends HttpServlet {
    BlogDaoImpl bd = new BlogDaoImpl();
    SmartUpload su = new SmartUpload();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        String user = null;
        String path = null;
        //设置缓冲区大小与临时文件目录
        factory.setSizeThreshold(1024*1024*10);
        File uploadTemp=new File("e:\\uploadTemp");
        uploadTemp.mkdirs();
        factory.setRepository(uploadTemp);
        //设置单个文件大小限制
        upload.setFileSizeMax(1024*1024*10);
        //设置所有文件总和大小限制
        upload.setSizeMax(1024*1024*30);
        try {
            List<FileItem> list=upload.parseRequest(request);
            System.out.println(list);
            for (FileItem fileItem:list){
                if (!fileItem.isFormField()&&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
                    String filName=fileItem.getName();
                    //利用UUID生成伪随机字符串，作为文件名避免重复
                    String uuid= UUID.randomUUID().toString();
                    //获取文件后缀名
                    String suffix=filName.substring(filName.lastIndexOf("."));
                    //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
                    String uploadPath=request.getSession().getServletContext().getRealPath("/web/userimage");
                    File file=new File(uploadPath);
                    file.mkdirs();
                    //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
                    fileItem.write(new File(uploadPath,uuid+suffix));
                    path = "http://localhost:8080"+request.getContextPath()+"/web/userimage/"+uuid+suffix;
                    System.out.println(path);
                    request.getServletContext().setAttribute("path",path);
                }

                else{
                    System.out.println(fileItem.getFieldName()); //该name值空间中的value值
                    System.out.println(fileItem.getString("UTF-8"));
                    user = fileItem.getString("UTF-8");
                    user = URLDecoder.decode(user,"UTF-8");
                    System.out.println(user);
                    request.getServletContext().setAttribute("name",user);
                    System.out.println(path);
                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
        bd.uploadImage(path,user);
        response.sendRedirect("blog.jsp");

    }
}
