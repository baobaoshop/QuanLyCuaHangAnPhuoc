/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;

/**
 *
 * @author DNT
 */
public class SQLServerProvider {

    private Connection connection;

    public void open() {
        String strDatabase = "CuaHangAnPhuoc";
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + strDatabase + ";user=sa;password=Password.1;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionURL);

//            if (connection != null) {
//                System.out.println("Kết nối thành công");
//            } else {
//                System.out.println("Kết nối không thành công");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean executeUpdate(String sql) {
        try {
            Statement statement = connection.createStatement();
            int n = statement.executeUpdate(sql);
            if (n > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excuteCallable(String sql) {
        try {
            CallableStatement callStatement = connection.prepareCall(sql);
//            if (callStatement.execute()) {
//                return true;
//            } else {
//                return false;
//            }
            callStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
