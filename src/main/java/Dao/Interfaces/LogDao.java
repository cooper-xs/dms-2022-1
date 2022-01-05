package Dao.Interfaces;

import Ex.InputValueException;
import Po.Log;

import java.util.List;

public interface LogDao {
    // note 查找全部
    public List<Log> selectAll();
    // note 添加log到表中
    public int addLog(Log log);
    // note 签到
    public int signIn(String student_id);
    // note 签退
    public int signOut(String student_id);
    // note 缴费
    public int saveMoney(String id, String building_id, String dorm_id, double value) throws InputValueException;
}
