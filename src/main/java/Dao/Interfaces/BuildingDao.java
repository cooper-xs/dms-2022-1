package Dao.Interfaces;

import Po.Building;

import java.util.List;

public interface BuildingDao {
    // note 通过id查找
    public Building selectById(String building_id);
    // note 查找全部宿舍
    public List<Building> selectAll();
    // note 添加building到表中
    public int addBuilding(Building building);
    // note 通过id修改为新的Building
    public int updateBuilding(String building_id, Building building);
    // note 通过id删除
    public int deleteBuilding(String building_id);
}
