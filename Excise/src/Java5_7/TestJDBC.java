package Java5_7;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    private static void testInsert() throws SQLException {
        // 1.创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2.设置 dataSource 的属性，为连接数据库做准备
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useSSl=true";
        // localhost
        ((MysqlDataSource) dataSource).setURL(url);
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("mysql");
        // 3.创建 Connection 对象，用来表示和数据库建立一次连接
        Connection connection = dataSource.getConnection();
        // 4.操作数据库
        String sql = "insert into student values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "张三");
        statement.setInt(2, 20);
        statement.setString(3, "无");
        // 5.执行 sql
        int ret = statement.executeUpdate();
        System.out.println(ret);
        // 6.释放相关资源
        statement.close();
        connection.close();
    }
    private static void testSelect() throws SQLException {
        // 1.创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2.设置 dataSource 的属性，为连接数据库做准备
        String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8&useSSl=true";
        ((MysqlDataSource) dataSource).setURL(url);
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("mysql");
        // 3.创建 Connection 对象，用来表示和数据库建立一次连接
        Connection connection = dataSource.getConnection();
        // 4.操作数据库
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5.执行 sql
        ResultSet resultSet = statement.executeQuery();
        // 6.遍历结果集合
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String other = resultSet.getString("other");
            System.out.println(name + ":" + age + " 其他：" + other);
        }
        // 7.释放相关资源
        statement.close();
        connection.close();
    }
    public static void main(String[] args) throws SQLException {
        // testInsert();
        testSelect();
    }

}
