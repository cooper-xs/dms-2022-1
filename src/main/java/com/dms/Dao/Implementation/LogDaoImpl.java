package com.dms.Dao.Implementation;

import com.dms.Dao.BaseDao;
import com.dms.Dao.Interfaces.LogDao;
import com.dms.Ex.InputValueException;
import com.dms.Po.Log;
import com.dms.DmsUtils.DateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDaoImpl extends BaseDao implements LogDao {
    @Override
    public List<Log> selectAll() {
        List<Log> logList = new ArrayList<>();
        String sql = "select * from `log`";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Log log = new Log();
                log.setLog_id(rs.getInt("log_id"));
                log.setAccount_id(rs.getString("account_id"));
                log.setType(rs.getInt("type"));
                log.setBuilding_id(rs.getString("building_id"));
                log.setDorm_id(rs.getString("dorm_id"));
                log.setDate(rs.getString("date"));
                logList.add(log);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return logList;
    }

    @Override
    public int addLog(Log log) {
        int res = 0;
        String sql1 = "insert into `log` values (null, ?, ?, ?, ?, ?, ?)";
        String sql2 = "insert into `log` (log_id, account_id, type, date) values (null, ?, ?, ?)";
        try {
            conn = getConnection();
            if(log.getType() == 1) {
                pst = conn.prepareStatement(sql1);
                pst.setString(1, log.getAccount_id());
                pst.setInt(2, log.getType());
                pst.setString(3, log.getBuilding_id());
                pst.setString(4, log.getDorm_id());
                pst.setDouble(5, log.getPayment_account());
                pst.setString(6, DateUtil.nowToDateTime());
                res = pst.executeUpdate();
            } else if(log.getType() == 2 || log.getType() == 3) {
                pst = conn.prepareStatement(sql2);
                pst.setString(1, log.getAccount_id());
                pst.setInt(2, log.getType());
                pst.setString(3, DateUtil.nowToDateTime());
                res = pst.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int signIn(String student_id) {
        int res1 = 0, res2 = 0;
        String sql = "update `student` set `status` = 1 where `student_id` = ?";
        String sql2 = "insert into `log` (`log_id`, `account_id`, `type`, `date`) values (null, ?, ?, ?)";
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res1 = pst.executeUpdate();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, student_id);
            pst.setInt(2, 2);
            pst.setString(3, DateUtil.nowToDateTime());
            res2 = pst.executeUpdate();
            System.out.println("res1 = " + res1 + "   res2 = " + res2);
            if(res1 * res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res1 * res2;
    }

    @Override
    public int signOut(String student_id) {
        int res1 = 0, res2 = 0;
        String sql = "update `student` set `status` = 0 where `student_id` = ?";
        String sql2 = "insert into `log` (`log_id`, `account_id`, `type`, `date`) values (null, ?, ?, ?)";
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, student_id);
            res1 = pst.executeUpdate();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, student_id);
            pst.setInt(2, 3);
            pst.setString(3, DateUtil.nowToDateTime());
            res2 = pst.executeUpdate();
            System.out.println("res1 = " + res1 + "   res2 = " + res2);
            if(res1 * res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res1 * res2;
    }

    @Override
    public int saveMoney(String id, String building_id, String dorm_id, double value) throws InputValueException {
        if(value < 0) {
            throw new InputValueException(value);
        }
        int res1 = 0, res2 = 0;
        String sql = "update `dorm` set `deposit` = deposit + ? where `building_id` = ? and `dorm_id` = ?";
        String sql2 = "insert into `log` (log_id, account_id, type, building_id, dorm_id, payment_account, date)values (null, ?, 1, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, value);
            pst.setString(2, building_id);
            pst.setString(3, dorm_id);
            res1 = pst.executeUpdate();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, id);
            pst.setString(2, building_id);
            pst.setString(3, dorm_id);
            pst.setDouble(4, value);
            pst.setString(5, DateUtil.nowToDateTime());
            res2 = pst.executeUpdate();
            if(res1 * res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res1 * res2;
    }
}
