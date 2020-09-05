package filter;

import model.Response;
import util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// 过滤器，满足 url 请求的url匹配的路径规则，才会过滤（调用filter中的方法）
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        /**
         * 页面的静态资源，后台服务
         * 需要处理的敏感资源：
         *      1.首页：/public/page/main.html没有登陆，重定向到登陆页面
         *      2，后端的服务资源：除登陆接口/user/login以外，其他接口
         */
        // 获取session信息
        HttpSession session = req.getSession(false);// 没有session时返回null
        if (session == null) {// 没有登陆
            // 获取当前http请求的路径
            String uri = req.getServletPath();
            // 访问 /public/page/main.html 就让它重定向到登陆页面
            if ("/public/page/main.html".equals(uri)) {
                //  http
                String schema = req.getScheme();
                // 服务器域名或者ip
                String host = req.getServerName();
                // 服务器端口号
                int port = req.getServerPort();
                // 项目部署名
                String contextPath = req.getContextPath();

                String basePath = schema + "://" + host + ":" + port + contextPath;
                res.sendRedirect(basePath+"/public/index.html");
                return;
            } else if (!"/user/login".equals(uri) &&
                    !uri.startsWith("/public/") &&
                    !uri.startsWith("/static/")) {
                // 访问了后台资源（除登陆等前端页面），返回错误信息（JSON格式）
                req.setCharacterEncoding("UTF-8");
                res.setCharacterEncoding("UTF-8");
                res.setContentType("application/json"); //设置响应数据格式

                Response r = new Response();
                r.setCode("301"); // 不是响应的状态码，是响应的字段
                r.setMessage("未授权的HTTP请求");
                PrintWriter pw = res.getWriter();
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
