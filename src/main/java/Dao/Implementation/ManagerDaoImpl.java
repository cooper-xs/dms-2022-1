package Dao.Implementation;

import Dao.BaseDao;
import Dao.Interfaces.ManagerDao;
import Po.Manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager selectById(String manager_id) {
        Manager manager = null;
        String sql = "select * from manager where manager_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, manager_id);
            rs = pst.executeQuery();
            if(rs.next()) {
                manager = new Manager();
                manager.setName(rs.getString("name"));
                manager.setManager_id(rs.getString("manager_id"));
                manager.setContact(rs.getString("contact"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public List<Manager> selectAll() {
        List<Manager> managerList = new ArrayList<>();
        String sql = "select * from manager";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Manager manager = new Manager();
                manager.setName(rs.getString("name"));
                manager.setManager_id(rs.getString("manager_id"));
                manager.setContact(rs.getString("contact"));
                managerList.add(manager);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public int addManager(Manager manager) {
        int res = 0;
        String sql = "insert into `manager` values (?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, manager.getName());
            pst.setString(2, manager.getManager_id());
            pst.setString(3, manager.getContact());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateManager(String manager_id, Manager manager) {
        int res = 0;
        String sql = "update `manager` set `name` = ?, `contact` = ? where manager_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, manager_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteManager(String manager_id) {
        int res = 0;
        String sql = "delete from manager where `manager_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, manager_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
