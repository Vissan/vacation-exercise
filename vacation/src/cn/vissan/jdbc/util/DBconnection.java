package cn.vissan.jdbc.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBconnection {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream in = new FileInputStream("E:/eladmin-plus/vacation/resources/application.properties");
            properties.load(in);
            Class.forName(properties.getProperty("DriverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection conn() throws Exception {

        String url = properties.getProperty("url");
        String name = properties.getProperty("name");
        String passwd = properties.getProperty("passwd");
        return DriverManager.getConnection(url, name, passwd);
    }

    public static void close(Connection con, Statement stat, ResultSet res) throws Exception {
            if (res != null) {
                res.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (con != null) {
                con.close();
            }
    }
}
