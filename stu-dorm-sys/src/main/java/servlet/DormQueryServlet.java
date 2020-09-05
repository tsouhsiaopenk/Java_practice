package servlet;

import Dao.DormDao;
import model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 查询寝室：
 *      级联下拉菜单：选择宿舍楼下拉选项之后，根据选择的宿舍楼id查询所有寝室。
 *      要求按照数据字典响应格式返回
 */
@WebServlet("/dorm/queryAsDict")
public class DormQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DormDao.query(Integer.parseInt(key));
        return tags;
    }
}
