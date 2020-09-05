package servlet;

import Dao.DictionaryTagDao;
import model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 查询毕业年份字典：
 *      根据请求数据里边的 dictionaryKey ，返回毕业年份代码和毕业年份
 */
@WebServlet("/dict/tag/query")
public class DictionaryTagQueryServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDao.query(key);
        return tags;
    }
}
