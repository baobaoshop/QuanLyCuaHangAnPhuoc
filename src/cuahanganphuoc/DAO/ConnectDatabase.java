/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import java.sql.*;

/**
 *
 * @author user
 */
public class ConnectDatabase {
    private Connection connection;
    public void Open() {
        String strDatabase = "CuaHangAnPhuoc";
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + strDatabase + ";user=sa;password=Password.1;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void Close() {
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
}
