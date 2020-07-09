package zxp.servlet;

import zxp.dao.ArticleDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idsString = req.getParameter("ids");
        String[] idsArray = idsString.split(",");
        int[] ids = new int[idsArray.length];
        for (int i = 0; i < idsArray.length; i++) {
            ids[i] = Integer.parseInt(idsArray[i]);
        }
        int num = ArticleDao.delete(ids);
        return null;
    }
}
