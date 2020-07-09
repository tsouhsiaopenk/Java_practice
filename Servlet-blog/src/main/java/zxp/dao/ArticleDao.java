package zxp.dao;

import zxp.model.Article;
import zxp.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章工具类：封装一些与数据库的交互操作
 */
public class ArticleDao {
    // 查询文章列表：根据传入id，查询出所有的文章列表
    public static List<Article> query(int id) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            c = DBUtil.getConnection();
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time from article a\n" +
                    " join user u on a.user_id = u.id where user_id=?";
            // 2.创建操作命令
            ps = c.prepareStatement(sql);
            // 第一个占位符
            ps.setInt(1, id);
            // 3.执行sql
            rs = ps.executeQuery();
            // 4.处理结果集
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表出错，一般都是自己sql写错了", e);
        } finally {
            // 5.释放资源
            DBUtil.close(c, ps, rs);
        }
        return articles;
    }

    // 插入操作：即将新建的文章插入数据库
    public static int insert(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into article(title,content,user_id,create_time)" +
                    " values(?,?,?,NOW())";
            // 2.创建操作命令
            ps = c.prepareStatement(sql);

            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, 1); // 写死用户id
            // 3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入文章出错，一般都是自己sql写错了", e);
        } finally {
            // 5.释放资源
            DBUtil.close(c, ps);
        }
    }

    // 查询文章详情：将id所对应的文章从数据库中查出来，返回
    public static Article queryById(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select a.id, a.title, a.content, a.user_id, a.create_time from article a where a.id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            // 4.处理结果集
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                return a;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("查询文章详情出错，一般都是自己sql写错了", e);
        } finally {
            // 5.释放资源
            DBUtil.close(c, ps, rs);
        }
    }

    // 修改操作
    public static int update(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id = ?";
            // 2.创建操作命令
            ps = c.prepareStatement(sql);

            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            // 3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("修改文章出错，一般都是自己sql写错了", e);
        } finally {
            // 5.释放资源
            DBUtil.close(c, ps);
        }
    }

    public static int delete(int[] ids) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete article where id in (");
            for (int i = 0; i < ids.length; i++) { // 通过传入的int数组动态生成带占位符的sql
                if (i == 0){
                    sql.append("?");
                }else {
                    sql.append(",?");
                }
            }
            sql.append(")");
            // 2.创建操作命令
            ps = c.prepareStatement(sql.toString());
            for (int i = 0; i < ids.length; i++) {
                ps.setInt(i+1,ids[i]);
            }
            // 3.执行sql
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("删除文章出错，一般都是自己sql写错了", e);
        } finally {
            // 5.释放资源
            DBUtil.close(c, ps);
        }
    }
}
