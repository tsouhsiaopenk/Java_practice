package servlet;

import Dao.StudentDao;
import model.Page;
import model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 查询学生住宿信息
 *      查询出所有学生住宿信息
 */
@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 解析//searchText=&sortOrder=asc&pageSize=7&pageNumber=1&_=1594084296034
        Page page = Page.parse(req);
        List<Student> students = StudentDao.query(page);
        return students;
    }
}
