package Dao.Implementation;

import Dao.BaseDao;
import Dao.Interfaces.BuildingDao;
import Po.Building;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingDaoImpl extends BaseDao implements BuildingDao {
    @Override
    public Building selectById(String building_id) {
        Building building = null;
        String sql = "select * from building where building_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building_id);
            rs = pst.executeQuery();
            if(rs.next()) {
                building = new Building();
                building.setBuilding_id(rs.getString("building_id"));
                building.setName(rs.getString("name"));
                building.setAddress(rs.getString("address"));
                building.setManager_id(rs.getString("manager_id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return building;
    }

    @Override
    public List<Building> selectAll() {
        List<Building> buildingList = new ArrayList<>();
        String sql = "select * from building";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Building building = new Building();
                building.setBuilding_id(rs.getString("building_id"));
                building.setName(rs.getString("name"));
                building.setAddress(rs.getString("address"));
                building.setManager_id(rs.getString("manager_id"));
                buildingList.add(building);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return buildingList;
    }

    @Override
    public int addBuilding(Building building) {
        int res = 0;
        String sql = "insert into `building` values (?, ?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building.getName());
            pst.setString(2, building.getBuilding_id());
            pst.setString(3, building.getAddress());
            pst.setString(4, building.getManager_id());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateBuilding(String building_id, Building building) {
        int res = 0;
        String sql = "update `building` set `name` = ?, `address` = ?, `manager_id` = ? where building_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building.getName());
            pst.setString(2, building.getAddress());
            pst.setString(3, building.getManager_id());
            pst.setString(4, building.getBuilding_id());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteBuilding(String building_id) {
        int res = 0;
        String sql = "delete from `building` where `building_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
