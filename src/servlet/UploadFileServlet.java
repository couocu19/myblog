package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name="upload",urlPatterns = "/upload")
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String rootPath = req.getSession().getServletContext().getRealPath("/web/userimage");

        File filePath = new File(rootPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        //获取对应的请求数据

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) {
                //对普通的key-value数据进行处理
                String fieldName = item.getFieldName();
                String value = item.getString();
                req.setAttribute(fieldName, value);
            } else {
                //获取文件数据并保存
                StringBuilder fileName = new StringBuilder(item.getName());
                fileName.insert(fileName.indexOf("."), System.currentTimeMillis());
                System.out.println(fileName);

                File image = new File(rootPath, new String(fileName));

                InputStream is = item.getInputStream();
                OutputStream os = new FileOutputStream(image);
                byte[] buf = new byte[1024];
                int read;
                while ((read = is.read(buf)) > 0) {
                    os.write(buf, 0, read);
                }

                System.out.println(req.getRequestURL());
                System.out.println(req.getPathInfo());
                int endIndex = 0;
                if (req.getPathInfo() != null) {
                    endIndex = req.getRequestURL().length() - req.getPathInfo().length() - 8;
                } else {
                    endIndex = req.getRequestURL().length() - 7;
                }

                String url = req.getRequestURL().substring(0, endIndex);
                //返回文件对应url
                resp.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\" " + url
                        + req.getSession().getServletContext().getContextPath() + "/web/userimage/" + image.getName() + "\"}");


            }
        }
    }
}