package Dao.Implementation;

import Dao.BaseDao;
import Dao.Interfaces.RegisterDao;
import Po.Register;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDaoImpl extends BaseDao implements RegisterDao {
    @Override
    public Register selectById(String account) {
        Register register = null;
        String sql = "select * from `register` where `account` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, account);
            rs = pst.executeQuery();
            if(rs.next()) {
                register = new Register();
                register.setIdentity(rs.getInt("identity"));
                register.setAccount(rs.getString("account"));
                register.setPassword(rs.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return register;
    }

    @Override
    public List<Register> selectAll() {
        List<Register> registerList = new ArrayList<>();
        String sql = "select * from `register`";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Register register = new Register();
                register.setIdentity(rs.getInt("identity"));
                register.setAccount(rs.getString("account"));
                register.setPassword(rs.getString("password"));
                registerList.add(register);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return registerList;
    }

    @Override
    public int addRegister(Register register) {
        int res = 0;
        String sql = "insert into `register` values (?, ?, ?)";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, register.getIdentity());
            pst.setString(2, register.getAccount());
            pst.setString(3, register.getPassword());
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateRegister(String account, String password) {
        int res = 0;
        String sql = "update `register` set `password` = ? where account = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, account);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteRegister(String account) {
        int res = 0;
        String sql = "delete from `register` where `account` = ?";
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, account);
            res = pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


}
