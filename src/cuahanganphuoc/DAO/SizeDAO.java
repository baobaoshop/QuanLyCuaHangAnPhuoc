/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.LOAISP;
import cuahanganphuoc.MODAL.LUUTRU;
import cuahanganphuoc.MODAL.SIZE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class SizeDAO {
    public static void loadAll() {
        List<SIZE> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SIZES";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                SIZE ma = new SIZE();
                ma.setMa(resultSet.getString("MASIZE"));
                ma.setTen(resultSet.getString("TENSIZE"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listSize = dsMA;
    }
    
    public static String taoMaKHMoi(){
        SIZE dh = LUUTRU.listSize.get(LUUTRU.listSize.size()-1); //***
        String ma = dh.getMa(); //*
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "SZ00"+nextto; //*
        }
        if(nextto<100){
            return "SZ0"+nextto; //*
        }
        return "SZ"+nextto; //*
    }
    

    public static boolean themCSDL(SIZE m) {
        boolean kq = false;
        String sql = "INSERT INTO SIZES VALUES('" + m.getMa()+ "', N'" + m.getTen()+ "')";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean xoaCSDL(SIZE m) {
        boolean kq = false;
        String sql = "DELETE FROM SIZES where MASIZE='"+ m.getMa()+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    public static boolean capNhatCSDL(SIZE m) {
        boolean kq = false;
        String sql = "UPDATE SIZES SET TENSIZE=N'" + m.getTen()+ "'where MASIZE='" + m.getMa()+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        loadAll();
        return kq;
    }
}
