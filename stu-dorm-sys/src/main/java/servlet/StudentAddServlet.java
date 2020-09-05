package servlet;

import Dao.StudentDao;
import model.Student;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 新增学生住宿信息：
 *      获取前端传进来的数据，将其插入数据库。
 */
@WebServlet("/student/add")
public class StudentAddServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        int num = StudentDao.insert(s);
        return num;
    }
}
