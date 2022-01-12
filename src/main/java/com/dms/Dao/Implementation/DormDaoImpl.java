package com.dms.Dao.Implementation;

import com.dms.Dao.BaseDao;
import com.dms.Dao.Interfaces.DormDao;
import com.dms.Po.Dorm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DormDaoImpl extends BaseDao implements DormDao {
    @Override
    public Dorm selectById(String building_id, String dorm_id) {
        Dorm dorm = null;
        String sql = "select * from dorm where building_id = ? and dorm_id = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building_id);
            pst.setString(2, dorm_id);
            rs = pst.executeQuery();
            if(rs.next()) {
                dorm = new Dorm();
                dorm.setName(rs.getString("name"));
                dorm.setBuilding_id(rs.getString("building_id"));
                dorm.setDorm_id(rs.getString("dorm_id"));
                dorm.setBed_num(rs.getInt("bed_num"));
                dorm.setPeople_num(rs.getInt("people_num"));
                dorm.setDeposit(rs.getDouble("deposit"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dorm;
    }

    @Override
    public List<Dorm> selectAll() {
        List<Dorm> dormList = new ArrayList<>();
        String sql = "select * from dorm";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Dorm dorm = new Dorm();
                dorm.setName(rs.getString("name"));
                dorm.setBuilding_id(rs.getString("building_id"));
                dorm.setDorm_id(rs.getString("dorm_id"));
                dorm.setBed_num(rs.getInt("bed_num"));
                dorm.setPeople_num(rs.getInt("people_num"));
                dorm.setDeposit(rs.getDouble("deposit"));
                dormList.add(dorm);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dormList;
    }

    @Override
    public int addDorm(Dorm dorm) {
        int res = 0;
        String sql = "insert into `dorm` values (?, ?, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, dorm.getName());
            pst.setString(2, dorm.getBuilding_id());
            pst.setString(3, dorm.getDorm_id());
            pst.setInt(4, dorm.getBed_num());
            pst.setInt(5, dorm.getPeople_num());
            pst.setDouble(6, dorm.getDeposit());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据楼宇号与宿舍号精确修改宿舍信息
     * @param building_id
     * @param dorm_id
     * @param dorm
     * @return
     */
    @Override
    public int updateDorm(String building_id, String dorm_id, Dorm dorm) {
        int res = 0;
        String sql = "update `dorm` set `name` = ?, `bed_num` = ?, `people_num` = ?, `deposit` = ? where `building_id` = ? and `dorm_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, dorm.getName());
            pst.setInt(2, dorm.getBed_num());
            pst.setInt(3, dorm.getPeople_num());
            pst.setDouble(4, dorm.getDeposit());
            pst.setString(5, building_id);
            pst.setString(6, dorm_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteDorm(String building_id, String dorm_id) {
        int res = 0;
        String sql = "delete from `dorm` where `building_id` = ? and `dorm_id` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, building_id);
            pst.setString(2, dorm_id);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
