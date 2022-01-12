package com.dms.Service.Implementation;

import com.dms.Service.Interfaces.Biz;
import com.dms.Dao.Implementation.*;
import com.dms.Dao.Interfaces.*;
import com.dms.Ex.*;
import com.dms.Po.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BizImpl implements Biz {
    StudentDao studentDao = new StudentDaoImpl();
    ManagerDao managerDao = new ManagerDaoImpl();
    DormDao dormDao = new DormDaoImpl();
    BuildingDao buildingDao = new BuildingDaoImpl();
    RegisterDao registerDao = new RegisterDaoImpl();
    LogDao logDao = new LogDaoImpl();

    /**
     * 借助账户名和密码进行登录，成功则返回用户类型
     */
    @Override
    public int Login(String account, String password) throws NoSuchAccountException, PasswordWrongException, AccountInputEmptyException, PasswordInputEmptyException {
        int identity;
        if(account.equals("")) {
            // 输入账号为空
            throw new AccountInputEmptyException();
        }
        if(password.equals("")) {
            // 密码为空
            throw new PasswordInputEmptyException();
        }
        Register register = registerDao.selectById(account);
        if(register == null) {
            // 用户不存在
            throw new NoSuchAccountException(account);
        }
        if(register.getPassword().equals(password)) {
            identity = register.getIdentity();
        } else {
            // 密码错误
            throw new PasswordWrongException();
        }
        return identity;
    }

    /**
     * note 通过学生账号找到学生
     */
    @Override
    public Student selectStudentById(String student_id) {
        return studentDao.selectById(student_id);
    }

    /**
     * 根据楼宇号与宿舍号精确查找宿舍内学生
     * @param building_id
     * @param dorm_id
     * @return
     */
    @Override
    public List<Student> selectStudentByBuilding_idAndDorm_id(String building_id, String dorm_id) {
        List<Student> studentList = studentDao.selectAll();
        List<Student> studentReturn = new ArrayList<>();
        for(Student student : studentList) {
            if(student.getBuilding_id().equals(building_id) && student.getDorm_id().equals(dorm_id)) {
                studentReturn.add(student);
            }
        }
        return studentReturn;
    }

    @Override
    public List<Student> selectStudentByBuilding_id(String building_id) {
        List<Student> studentList = studentDao.selectAll();
        List<Student> studentReturn = new ArrayList<>();
        for(Student student : studentList) {
            if(student.getBuilding_id().equals(building_id)) {
                studentReturn.add(student);
            }
        }
        return studentReturn;
    }

    @Override
    public List<Manager> selectAllManager() {
        return managerDao.selectAll();
    }

    /**
     * 根据id将数据库的信息更新为新的student
     * @param student_id
     * @param student
     * @return
     */
    @Override
    public boolean updateStudentInfo(String student_id, Student student) {
        return studentDao.updateStudent(student_id, student) > 0;
    }

    /**
     * 更新宿舍信息
     * @param building_id
     * @param dorm_id
     * @param dorm
     * @return
     */
    @Override
    public boolean updateDormInfo(String building_id, String dorm_id, Dorm dorm) {
        return dormDao.updateDorm(building_id, dorm_id, dorm) > 0;
    }

    @Override
    public boolean updateManagerInfo(String manager_id, Manager manager) {
        return managerDao.updateManager(manager_id, manager) > 0;
    }

    @Override
    public boolean updateBuildingInfo(String building_id, Building building) {
        return buildingDao.updateBuilding(building_id, building) > 0;
    }

    /**
     * 直接找到管理员
     */
    @Override
    public Manager selectManagerById(String manager_id) {
        return managerDao.selectById(manager_id);
    }

    /**
     * 展示学生信息（在所有table上）
     */
    public void studentShowOnAll(Student student) {
        System.out.println(student);
    }

    /**
     * 展示管理员信息（在所有table上）
     */
    @Override
    public void managerShowOnAll(Manager manager) {
        System.out.println(manager);
    }

    @Override
    public boolean resetPassword(String account, String passwordBefore, String passwordNew, String passwordRepeat) throws PasswordWrongException, PasswordNotSameException, PasswordSameWithBeforeException {
        Register register = registerDao.selectById(account);

        if(!register.getPassword().equals(passwordBefore)) {
            throw new PasswordWrongException();
        }
        if(!passwordNew.equals(passwordRepeat)) {
            throw new PasswordNotSameException();
        }
        if(passwordBefore.equals(passwordNew)) {
            throw new PasswordSameWithBeforeException();
        }
        return registerDao.updateRegister(account, passwordNew) > 0;
    }

    /**
     * 展示宿舍信息（在学生table上）
     */
    @Override
    public Dorm selectDormByBuilding_idAndDorm_id(String building_id, String dorm_id) throws NoSuchAccountException {
        Dorm dorm = dormDao.selectById(building_id, dorm_id);
        if(dorm == null) {
            throw new NoSuchAccountException(building_id + "#" + dorm_id);
        }
        return dorm;
    }

    /**
     * 根据楼宇号查找楼宇
     * @param building_id
     * @return
     * @throws NoSuchAccountException
     */
    @Override
    public Building selectBuildingByBuilding_id(String building_id) throws NoSuchAccountException {
        Building building = buildingDao.selectById(building_id);
        if(building == null) {
            throw new NoSuchAccountException(building_id);
        }
        return building;
    }

    /**
     * 通过id签到
     */
    @Override
    public boolean signIn(String student_id) {
        return logDao.signIn(student_id) > 0;
    }

    /**
     * 通过id签退
     */
    @Override
    public boolean signOut(String student_id) {
        return logDao.signOut(student_id) > 0;
    }

    /**
     * 存value元钱到宿舍 building_id # dorm_id
     */
    @Override
    public boolean saveMoney(String id, String building_id, String dorm_id, double value) throws InputValueException {
        return logDao.saveMoney(id, building_id, dorm_id, value) > 0;
    }

    /**
     * 返回一个管理员的全部管理楼栋
     */
    @Override
    public List<Building> selectBuildingsByManager_id(String manager_id) {
        List<Building> buildingList = new ArrayList<>();
        for(Building building : buildingDao.selectAll()) {
            if(Objects.equals(building.getManager_id(), manager_id)) {
                buildingList.add(building);
            }
        }
        return buildingList;
    }

    @Override
    public List<Building> selectAllBuilding() {
        return buildingDao.selectAll();
    }

    /**
     * 返回一栋楼的全部宿舍
     */
    @Override
    public List<Dorm> selectDormByBuilding_id(String building_id) {
        List<Dorm> dormList = new ArrayList<>();
        for(Dorm dorm : dormDao.selectAll()) {
            if(Objects.equals(building_id, dorm.getBuilding_id())) {
                dormList.add(dorm);
            }
        }
        return dormList;
    }

    @Override
    public List<Dorm> selectAllDorm() {
        return dormDao.selectAll();
    }

    /**
     * 返回全部日志信息
     */
    @Override
    public List<Log> selectAllLog() {
        return logDao.selectAll();
    }

    @Override
    public List<Log> selectLogByStudent_id(String student_id) {
        List<Log> logReturn = new ArrayList<>();
        List<Log> logList = selectAllLog();
        for(Log log : logList) {
            if(log.getAccount_id().equals(student_id)) {
                logReturn.add(log);
            }
        }
        return logReturn;
    }

    @Override
    public List<Log> selectLogByBuilding_idAndDorm_id(String building_id, String dorm_id) {
        List<Log> logReturn = new ArrayList<>();
        List<Log> logList = selectAllLog();
        for(Log log : logList) {
            if(log.getType() == 1) {
                if(log.getBuilding_id().equals(building_id) && log.getDorm_id().equals(dorm_id)) {
                    logReturn.add(log);
                }
            }
        }
        return logReturn;
    }
}
