package com.dms.Service.Interfaces;

import com.dms.Ex.*;
import com.dms.Po.*;

import java.util.List;

public interface Biz {
    // x1 查找
    // note 查找学生
    Student selectStudentById(String student_id);
    // note 查找寝室内学生
    List<Student> selectStudentByBuilding_idAndDorm_id(String building_id, String dorm_id);
    // note 查找楼宇内学生
    List<Student> selectStudentByBuilding_id(String building_id);
    // note 查找管理员
    Manager selectManagerById(String manager_id);
    // note 查找宿舍
    Dorm selectDormByBuilding_idAndDorm_id(String building_id, String dorm_id) throws NoSuchAccountException;
    // note 查找所管理宿舍
    List<Dorm> selectDormsByBuilding_id(List<Building> buildingList);
    // note 查找楼宇
    Building selectBuildingByBuilding_id(String building_id) throws NoSuchAccountException;
    // note 查找所管理楼宇
    List<Building> selectBuildingsByManager_id(String manager_id);
    // note 查找日志信息
    List<Log> selectAllLog();
    // note 查找个人签到信息
    List<Log> selectLogByStudent_id(String student_id);
    // note 查找宿舍缴费信息
    List<Log> selectLogByBuilding_idAndDorm_id(String building_id, String dorm_id);
    // x2 更新
    // note 更新学生信息
    boolean updateStudentInfo(String student_id, Student student);
    // note 更新宿舍信息
    boolean updateDormInfo(String building_id, String dorm_id, Dorm dorm);
    // note 展示学生个人信息
    void studentShowOnAll(Student student) throws NoSuchAccountException; // todo delete
    // note 展示管理员个人信息
    void managerShowOnAll(Manager manager); // todo delete
    // x3 操作
    // note 通过id签到
    boolean signIn(String student_id) ;
    // note 通过id签退
    boolean signOut(String student_id) ;
    // note 缴费
    boolean saveMoney(String id, String building_id, String dorm_id, double value) throws InputValueException;
    // note 登录
    int Login(String account, String password) throws NoSuchAccountException, PasswordWrongException, AccountInputEmptyException, PasswordInputEmptyException;
}
