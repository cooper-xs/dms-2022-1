package com.dms.Dao.Interfaces;

import com.dms.Po.Dorm;

import java.util.List;

public interface DormDao {
    // note 通过id查找
    public Dorm selectById(String building_id, String dorm_id);
    // note 查找全部宿舍
    public List<Dorm> selectAll();
    // note 添加dorm到表中
    public int addDorm(Dorm dorm);
    // note 通过id修改为新的dorm
    public int updateDorm(String building_id, String dorm_id, Dorm dorm);
    // note 通过id删除
    public int deleteDorm(String building_id, String dorm_id);
}
