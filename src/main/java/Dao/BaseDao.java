package Dao;

import java.sql.*;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement pst;
    protected ResultSet rs;

    // 获得数据库连接
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/apartment" +
                "?serverTimezone=Asia/Shanghai" +
                "&useSSL=false" +
                "&allowPublicKeyRetrieval=true" +
                "&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
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
