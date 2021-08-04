import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {
    public static void main(String[] args) {
        JDBC_Test test = new JDBC_Test();
        test.con();
    }

    public void con() {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false\n";
        String name = "root";
        String passwd = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载驱动
//            创建数据库连接
            final Connection connection = DriverManager.getConnection(url, name, passwd);
//            获取数据库对象
            final Statement statement = connection.createStatement();
//            执行sql语句
            String sql = "INSERT INTO student (`name`, `email`, `age`) VALUES ('haian', '222@xx.com', 18)";
            final int i = statement.executeUpdate(sql);
            if (i != 0) {
                System.out.println("添加成功");
            }
//            释放连接
            connection.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
