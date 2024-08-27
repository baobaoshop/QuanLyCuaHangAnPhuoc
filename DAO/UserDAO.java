/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.LUUTRU;
import cuahanganphuoc.MODAL.USER;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserDAO {
    public static String userDangDangNhap="";
    public static String adminDangDangNhap="";
    public static int dangNhap(String user, String pass) {
        int kq = 0;
        String R = "";
        try {
            String sql = String.format("SELECT * FROM USERS WHERE username = '%s' AND password = '%s'", user, pass);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            if (rs.next()) {
                R = rs.getString(3);
                if(R.equals("admin")){
                    kq = 1;
                }
                else if(R.equals("nhanvien")){
                    kq = 2;
                }
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    public static void loadAll() {
        List<USER> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USERS";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                USER ma = new USER();
                ma.setUsername(resultSet.getString("username"));
                ma.setPassword(resultSet.getString("password"));
                ma.setRole(resultSet.getString("role"));

                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listUser = dsMA;
    }
    public static boolean themCSDL(USER m) {
        boolean kq = false;
        String sql = "INSERT INTO USERS VALUES('" + m.getUsername()+ "', N'" + m.getPassword()+ "', '" + m.getRole()+ "')";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean xoaCSDL(USER m) {
        boolean kq = false;
        String sql = "DELETE FROM USERS WHERE username ='"+ m.getUsername()+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
}
