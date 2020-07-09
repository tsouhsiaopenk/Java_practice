package zxp.util;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    // tomcat 运行在多线程的环境下，所以我们这里写的是一个双重校验锁的形式
    private static volatile DataSource DATA_SOURCE;

    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private DBUtil() {}

    // 单例模式下获取数据源

    /**
     * 获取数据库连接池：使用双重校验的单例模式创建数据库连接池
     * 自己使用，不开放
     * @return
     */
    private static DataSource getDataSource(){
        if (DATA_SOURCE == null){
            synchronized(DBUtil.class){
                DATA_SOURCE = new MysqlDataSource();
                ((MysqlDataSource)DATA_SOURCE).setURL(URL);
                ((MysqlDataSource)DATA_SOURCE).setUser(USERNAME);
                ((MysqlDataSource)DATA_SOURCE).setPassword(PASSWORD);
            }
        }
        return DATA_SOURCE;
    }
    /**
     * 获取数据库连接：提供给其他地方操作JDBC时获取数据库连接
     */
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败");
        }
    }

    /**
     * JDBC操作步骤：
     * （1）创建数据库连接 DataSource DriverManager
     * （2）创建操作命令对象 Statement:
     *         Statement:简单sql语句的执行
     *         PreparedStatement:可以执行带参数的sql
     *              （1）可以预编译，效率更高
     *              （2）防止一定程度的sql注入
     * （3）执行sql
     * （4）如果是查询，处理结果集ResultSet
     * （5）释放资源（反向释放）
     */
    public static void close(Connection c, Statement s, ResultSet r){
        // 传进来的有可能为空
        try {
            if (r != null){
                r.close();
            }
            if (s != null){
                s.close();
            }
            if (c != null){
                c.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接失败",e);
        }
    }

    public static void close(Connection c, Statement s){
        close(c,s,null);
    }
}
