package servlet;

import Dao.StudentDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除学生住宿信息：
 *      删除可以选择多个，得到传进来待删除学生信息的id，
 *      在数据库中删除学生住宿信息
 */
@WebServlet("/student/delete")
public class StudentDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 相同的key有多个，可以获取到 value 数组
        String[] ids = req.getParameterValues("ids");
        int num = StudentDao.delete(ids);
        return null;
    }
}
