package cn.vissan.jdbc.dao;

import cn.vissan.jdbc.domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 插入操作
     * @param student
     */
    void insert(Student student) throws Exception;

    /**
     * 更新操作
     * @param student
     */
    void update(Student student) throws Exception;

    /**
     * 删除操作
     *
     */
    void delete(int student_id) throws Exception;

    /**
     * 查询学生信息
     */
    List<Student> findAll() throws Exception;

    /**
     *
     * @return
     */
    Student FindByID() throws Exception;
}
