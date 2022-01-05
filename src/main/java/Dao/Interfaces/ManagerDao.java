package Dao.Interfaces;

import Po.Manager;

import java.util.List;

public interface ManagerDao {
    // note 通过id查找
    public Manager selectById(String manager_id);
    // note 查找全部学生
    public List<Manager> selectAll();
    // note 添加student到表中
    public int addManager(Manager manager);
    // note 通过id修改为新的student
    public int updateManager(String manager_id, Manager manager);
    // note 通过id删除
    public int deleteManager(String manager_id);
}
