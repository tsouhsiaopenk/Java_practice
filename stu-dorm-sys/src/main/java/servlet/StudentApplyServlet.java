package servlet;

import Dao.StudentDao;
import model.Student;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 分配学生住宿信息：
 *      选中若干学生，为他们分配宿舍。
 *      根据传进来的 id，修改数据库中的表，达到宿舍信息的分配
 */
@WebServlet("/student/apply")
public class StudentApplyServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        int num = StudentDao.apply(s);
        return null;
    }
}
