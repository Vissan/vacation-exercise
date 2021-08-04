package cn.vissan.jdbc.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druidconnection {

    private static DataSource dataSource = null;
    static {
        try {
            InputStream in = new FileInputStream("E:/eladmin-plus/vacation/resources/application.properties");
            Properties properties = new Properties();
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
