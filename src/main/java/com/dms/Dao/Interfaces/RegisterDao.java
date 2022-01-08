package com.dms.Dao.Interfaces;

import com.dms.Po.Register;

import java.util.List;

public interface RegisterDao {
    // note 通过id查找
    public Register selectById(String account);
    // note 查找全部
    public List<Register> selectAll();
    // note 添加register到表中
    public int addRegister(Register register);
    // note 通过id修改密码
    public int updateRegister(String account, String password);
    // note 通过id删除
    public int deleteRegister(String account);
}
