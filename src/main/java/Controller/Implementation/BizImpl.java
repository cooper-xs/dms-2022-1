package Controller.Implementation;

import Controller.Interfaces.Biz;
import Dao.Implementation.*;
import Dao.Interfaces.*;
import Ex.InputValueException;
import Ex.NoSuchAccountException;
import Ex.PasswordWrongException;
import Po.*;

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
    public int Login(String account, String password) throws NoSuchAccountException, PasswordWrongException {
        int identity;
        Register register = registerDao.selectById(account);
        if(register == null) {
            throw new NoSuchAccountException(account);
        }
        if(register.getPassword().equals(password)) {
            identity = register.getIdentity();
        } else {
            throw new PasswordWrongException();
        }
        return identity;
    }

    /**
     * 直接找到学生
     */
    @Override
    public Student selectStudentById(String student_id) {
        return studentDao.selectById(student_id);
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

    /**
     * 展示宿舍信息（在学生table上）
     */
    @Override
    public void dormShowOnStudent(String building_id, String dorm_id) throws NoSuchAccountException {
        Dorm dorm = dormDao.selectById(building_id, dorm_id);
        if(dorm == null) {
            throw new NoSuchAccountException(building_id + "#" + dorm_id);
        }
        System.out.println(dorm);
    }

    /**
     * 展示楼宇信息（在学生table上）
     */
    @Override
    public void buildingShowOnStudent(Student student) throws NoSuchAccountException {
        String building_id = student.getBuilding_id();
        Building building = buildingDao.selectById(building_id);
        if(building == null) {
            throw new NoSuchAccountException(building_id);
        }
        System.out.println(building);
        int cnt = 0;
        List<Student> studentList = studentDao.selectAll();
        for(Student student0 : studentList) {
            if(student0.getBuilding_id().equals(building_id)) {
                cnt ++;
            }
        }
        System.out.println("与你住在一栋楼的还有：" + cnt + " 位同学");
        List<Manager> managerList = managerDao.selectAll();
        Manager manager = null;
        for(Manager manager0 : managerList) {
            if(manager0.getManager_id().equals(building.getManager_id())) {
                manager = manager0;
                break;
            }
        }
        if(manager != null) {
            System.out.println("你的宿管阿姨是：" + manager.getName() + " 联系方式：" + manager.getContact());
        }
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
    public List<Building> searchBuildingsByManager_id(String manager_id) {
        List<Building> buildingList = new ArrayList<>();
        for(Building building : buildingDao.selectAll()) {
            if(Objects.equals(building.getManager_id(), manager_id)) {
                buildingList.add(building);
            }
        }
        return buildingList;
    }

    /**
     * 返回一栋楼的全部宿舍
     */
    @Override
    public List<Dorm> searchDormsByBuilding_id(List<Building> buildingList) {
        List<Dorm> dormList = new ArrayList<>();
        for(Dorm dorm : dormDao.selectAll()) {
            for(Building building : buildingList) {
                if(Objects.equals(building.getBuilding_id(), dorm.getBuilding_id())) {
                    dormList.add(dorm);
                }
            }
        }
        return dormList;
    }

    /**
     * 返回全部日志信息
     */
    @Override
    public List<Log> searchAllLog() {
        return logDao.selectAll();
    }
}
