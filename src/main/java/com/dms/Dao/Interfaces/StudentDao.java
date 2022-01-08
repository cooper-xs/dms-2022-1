package com.dms.Dao.Interfaces;

import com.dms.Po.Student;

import java.util.List;

public interface StudentDao {
    // note 通过id查找
    public Student selectById(String student_id);
    // note 查找全部学生
    public List<Student> selectAll();
    // note 添加student到表中
    public int addStudent(Student student);
    // note 通过id修改为新的student
    public int updateStudent(String student_id, Student student);
    // note 通过id删除
    public int deleteStudent(String student_id);
}
