/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.LUUTRU;
import cuahanganphuoc.MODAL.MAUSAC;
import cuahanganphuoc.MODAL.SIZE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class MauSacDAO {
    public static void loadAll() {
        List<MAUSAC> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MAUSAC";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                MAUSAC ma = new MAUSAC();
                ma.setMaMS(resultSet.getString("MAMAU"));
                ma.setTenMS(resultSet.getString("TENMAU"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listMauSac = dsMA;
    }
    public static String taoMaKHMoi(){
        MAUSAC dh = LUUTRU.listMauSac.get(LUUTRU.listMauSac.size()-1); //***
        String ma = dh.getMaMS(); //*
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "MS00"+nextto; //*
        }
        if(nextto<100){
            return "MS0"+nextto; //*
        }
        return "MS"+nextto; //*
    }

    public static boolean themMAUSAC(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO MAUSAC(MAMAUSAC, TENMAUSAC) VALUES(N'%s',N'%s')",
                ma, ten);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capnhatMAUSAC(MAUSAC nv) {
        boolean kq = false;
        String sql = String.format("UPDATE MAUSAC SET TENMAUSAC=N'%s'WHERE MAMAUSAC=%d", 
                nv.getTenMS(),nv.getMaMS());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaMAUSAC(int maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM MAUSAC WHERE MAMAUSAC = %d", maNV);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    public ArrayList<MAUSAC> layDanhSachMAUSAC() {
        ArrayList<MAUSAC> dsMauSac = new ArrayList<>();
        String sql = "SELECT * FROM MAUSAC";
        
        try {
            ConnectDatabase con = new ConnectDatabase();
            con.Open();
            ResultSet rs = con.executeQuery(sql);
            while (rs.next()) {
                MAUSAC mauSac = new MAUSAC();
                mauSac.setMaMS(rs.getString("MaMau"));
                mauSac.setTenMS(rs.getString("TenMau"));
                dsMauSac.add(mauSac);
            }
            con.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsMauSac;
    }
    public static boolean themMauSac(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO MAUSAC(MaMau, TenMau) VALUES(N'%s',N'%s')",
                ma, ten);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public static boolean suaMauSac(String ten, String ma) {
        boolean kq = false;
        String sql = String.format("UPDATE MAUSAC SET TenMau=N'%s'WHERE MaMau='%s'", ten,ma);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }

    public static boolean xoaMauSac(String maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM MAUSAC WHERE MaMau ='%s'", maNV);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public MAUSAC timMauSacTheoMa(String maMau) {
        MAUSAC mauSac = null;
        String sql = String.format("SELECT * FROM MAUSAC WHERE MaMau = '%s'", maMau);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        ResultSet rs = con.executeQuery(sql);
        try {
            if (rs.next()) {
                mauSac = new MAUSAC();
                mauSac.setMaMS(rs.getString("MaMau"));
                mauSac.setTenMS(rs.getString("TenMau"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.Close();
        }
        return mauSac;
    }
}
