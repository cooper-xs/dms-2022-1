package com.dms.Dao.Interfaces;

import com.dms.Ex.InputValueException;
import com.dms.Po.Log;

import java.util.List;

public interface LogDao {
    // note 查找全部
    List<Log> selectAll();
    // note 添加log到表中
    int addLog(Log log);
    // note 签到
    int signIn(String student_id);
    // note 签退
    int signOut(String student_id);
    // note 缴费
    int saveMoney(String id, String building_id, String dorm_id, double value) throws InputValueException;
}
