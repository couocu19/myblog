package fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证登录验证过期问题
 */
@WebFilter(filterName = "loginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html;");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String request_uri = req.getRequestURI();
        String ctxPath = req.getContextPath();
        String uri = request_uri.substring(ctxPath.length());
        if (uri.contains("index.jsp") || uri.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (session.getAttribute("user") != null) {
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                out.println("您没有登录，请先登录！3秒后回到登录页面。");
                resp.setHeader("refresh", "3;url=" + ctxPath + "/index.jsp");
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
