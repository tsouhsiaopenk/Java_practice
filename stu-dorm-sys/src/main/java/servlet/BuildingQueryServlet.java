package servlet;

import Dao.BuildingDao;
import model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 宿舍楼查询：
 *      在使用在下拉菜单中，要求按照数据字典响应格式返回请求
 */
@WebServlet("/building/queryAsDict")
public class BuildingQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<DictionaryTag> tags = BuildingDao.query();
        return tags;
    }
}
