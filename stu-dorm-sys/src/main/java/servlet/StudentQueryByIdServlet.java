package servlet;

import Dao.StudentDao;
import model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  查询学生详细信息：
 *      用于修改之前显示出来当前的数据。
 *      根据传入的id，将学生详细信息查询出来。
 */
@WebServlet("/student/queryById")
public class StudentQueryByIdServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Student s = StudentDao.queryById(Integer.parseInt(id));
        return s;
    }
}
