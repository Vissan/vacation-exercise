package cn.vissan.jdbc.test;

import cn.vissan.jdbc.util.DBconnection;
import cn.vissan.jdbc.domain.Student;
import cn.vissan.jdbc.util.Druidconnection;
import org.junit.Test;

import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {


    @Test
    public void update() throws Exception{
        Student student = new Student();
        student.setId(1);
        student.setName("wanger");
        student.setAge(18);
        student.setEmail("111xx.com");
        final Connection conn = DBconnection.conn();
        String sql = "update student set name = ? where id = ?";
        final PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getId());
        preparedStatement.executeUpdate();

        DBconnection.close(conn, preparedStatement, null);
    }

    @Test
    public void delete() throws Exception {
        Student student = new Student();
        student.setId(2);
        final Connection connection = DBconnection.conn();
        String sql = "delete from student where id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.executeUpdate();

        DBconnection.close(connection, preparedStatement, null);
    }

    @Test
    public void FindByID() throws Exception {
        final Connection connection = DBconnection.conn();
        String sql = "select * from student where id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        final ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        while (resultSet.next()) {
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setAge(resultSet.getInt("age"));
            System.out.println(student);
        }

        DBconnection.close(connection, preparedStatement, resultSet);
    }

    @Test
    public void FindAll() throws Exception {
        List<Student> list = new ArrayList<Student>();
        final Connection connection = Druidconnection.getConnection();
        String sql = "select * from student";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        final ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setAge(resultSet.getInt("age"));
            list.add(student);
        }
        System.out.println(list);
//        DBconnection.close(connection, preparedStatement, resultSet);
    }

    @Test
    public void insert() throws Exception {
        final Connection connection = DBconnection.conn();
        String sql = "INSERT INTO student (name, email, age) VALUES (?, ?, ?)";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "wudidi");
        preparedStatement.setString(2, "3333xxx.com");
        preparedStatement.setInt(3, 22);
        preparedStatement.executeUpdate();

        DBconnection.close(connection, preparedStatement, null);
    }
}
