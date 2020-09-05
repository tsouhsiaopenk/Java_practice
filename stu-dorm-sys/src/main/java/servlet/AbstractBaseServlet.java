package servlet;

import model.Response;
import util.JSONUtil;
import util.ThreadLocalHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 所有 Servlet类 的父类
 */
public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //设置响应数据格式

        // 统一包装的返回格式
        Response response = new Response();
        try {
            Object o = process(req,resp);
            response.setSuccess(true);
            response.setCode("200");
            response.setMessage("操作成功");
            // 第一个get是自定义的方法，获取一个ThreadLocal变量
            // 第二个get是ThreadLocal变量的方法，获取当前线程设置的count变量
            response.setTotal(ThreadLocalHolder.get().get());
            response.setData(o);
        } catch (Exception e) {
            response.setCode("500");
            response.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            System.err.println(stackTrace);
            response.setStackTrace(stackTrace);
        }finally {
            // 使用完ThreadLocal，在线程结束前，删除变量。防止内存泄漏
            ThreadLocalHolder.get().remove();
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(response));
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
