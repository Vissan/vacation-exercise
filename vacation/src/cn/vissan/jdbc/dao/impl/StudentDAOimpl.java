package cn.vissan.jdbc.dao.impl;

import cn.vissan.jdbc.util.DBconnection;
import cn.vissan.jdbc.dao.StudentDao;
import cn.vissan.jdbc.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOimpl implements StudentDao {


    @Override
    public void insert(Student student) throws Exception {
        final Connection connection = DBconnection.conn();
        String sql = "INSERT INTO student (name, email, age) VALUES (?, ?, ?)";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.executeUpdate();

        DBconnection.close(connection, preparedStatement, null);
    }

    @Override
    public void update(Student student) throws Exception {
        Connection conn = DBconnection.conn();
        String sql = "update student set name = ? where id = ?";
        final PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getId());
        preparedStatement.executeUpdate();

        DBconnection.close(conn, preparedStatement, null);
    }

    @Override
    public void delete(int student_id) throws Exception {
        Connection connection = DBconnection.conn();
        String sql = "delete from student where id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, student_id);
        preparedStatement.executeUpdate();
        DBconnection.close(connection, preparedStatement, null);

    }

    @Override
    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<Student>();
        final Connection connection = DBconnection.conn();
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
        DBconnection.close(connection, preparedStatement, resultSet);
        return list;
    }

    @Override
    public Student FindByID() throws Exception {
        Connection connection = DBconnection.conn();
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
            return student;
        }

        DBconnection.close(connection, preparedStatement, resultSet);
        return student;
    }
}
