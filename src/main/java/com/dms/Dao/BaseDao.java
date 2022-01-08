package com.dms.Dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement pst;
    protected ResultSet rs;

    // 获得数据库连接
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/java/db.properties");
            properties.load(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String url = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("jdbcUser");
        String password = properties.getProperty("jdbcPassword");
        String Driver = properties.getProperty("jdbcDriver");
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        closeAll();
        return conn;
    }

    // 关闭对象
    public void closeAll() throws SQLException {
        if(rs != null) {
            rs.close();
        }
        if(pst != null) {
            pst.close();
        }
        if(conn != null) {
            conn.close();
        }
    }
}
