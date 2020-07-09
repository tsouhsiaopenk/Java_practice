package zxp.servlet;

import zxp.dao.ArticleDao;
import zxp.model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@WebServlet("/articleList")不使用注解—>xml
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        // 根据用户id查询关联的所有文章
        List<Article> articles = ArticleDao.query(Integer.parseInt(id));
        return articles;
    }
}
