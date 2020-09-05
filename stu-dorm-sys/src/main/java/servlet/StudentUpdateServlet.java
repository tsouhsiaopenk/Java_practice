package servlet;

import Dao.StudentDao;
import model.Student;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改学生住宿信息
 *      读入修改后的学生信息，进行数据库表操作
 */
@WebServlet("/student/update")
public class StudentUpdateServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        int num = StudentDao.update(s);
        return num;
    }
}
