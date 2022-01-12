package com.dms.Dao.Implementation;

import com.dms.Dao.BaseDao;
import com.dms.Dao.Interfaces.StudentDao;
import com.dms.Po.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    /**
     * 通过id查找学生
     * @param student_id
     * @return 查到的学生
     */
    @Override
    public Student selectById(String student_id) {
        Student student = null;
        String sql = "select * from `student` where `student_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            rs = pst.executeQuery();
            if(rs.next()) {
                student = new Student();
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getString("birthday"));
                student.setContact(rs.getString("contact"));
                student.setStudent_id(student_id);
                student.setCollege(rs.getString("college"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getString("classes"));
                student.setBuilding_id(rs.getString("building_id"));
                student.setDorm_id(rs.getString("dorm_id"));
                student.setBed_id(rs.getInt("bed_id"));
                student.setStatus(rs.getInt("status"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 查找所有学生
     * @return
     */
    @Override
    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from student";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getString("birthday"));
                student.setContact(rs.getString("contact"));
                student.setStudent_id(rs.getString("student_id"));
                student.setCollege(rs.getString("college"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getString("classes"));
                student.setBuilding_id(rs.getString("building_id"));
                student.setDorm_id(rs.getString("dorm_id"));
                student.setBed_id(rs.getInt("bed_id"));
                student.setStatus(rs.getInt("status"));
                studentList.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public int addStudent(Student student) {
        int res = 0;
        String sql = "insert into `student` values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getGender());
            pst.setString(3, student.getBirthday());
            pst.setString(4, student.getContact());
            pst.setString(5, student.getStudent_id());
            pst.setString(6, student.getCollege());
            pst.setString(7, student.getMajor());
            pst.setString(8, student.getClasses());
            pst.setString(9, student.getBuilding_id());
            pst.setString(10, student.getDorm_id());
            pst.setInt(11, student.getBed_id());
            pst.setInt(12, student.getStatus());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据学生id修改信息为student
     * @param student_id
     * @param student
     * @return
     */
    @Override
    public int updateStudent(String student_id, Student student) {
        int res = 0;
        String sql = "update student set name = ?, gender = ?, birthday = ?, contact = ?, college = ?, major = ?, classes = ?, building_id = ?, dorm_id = ?, bed_id = ?, status = ? where student_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getGender());
            pst.setString(3, student.getBirthday());
            pst.setString(4, student.getContact());
            pst.setString(5, student.getCollege());
            pst.setString(6, student.getMajor());
            pst.setString(7, student.getClasses());
            pst.setString(8, student.getBuilding_id());
            pst.setString(9, student.getDorm_id());
            pst.setInt(10, student.getBed_id());
            pst.setInt(11, student.getStatus());
            pst.setString(12, student_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteStudent(String student_id) {
        int res = 0;
        String sql = "delete from student where student_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
