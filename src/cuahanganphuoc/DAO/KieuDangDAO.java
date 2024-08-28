/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.KIEUDANG;
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
public class KieuDangDAO {
    public static void loadAll() {
        List<KIEUDANG> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KIEUDANG";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                KIEUDANG ma = new KIEUDANG();
                ma.setMaKD(resultSet.getString("MAKIEUDANG"));
                ma.setTenKD(resultSet.getString("TENKIEUDANG"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listKieDang = dsMA;
    }
    
    public static String taoMaKHMoi(){
        KIEUDANG dh = LUUTRU.listKieDang.get(LUUTRU.listKieDang.size()-1);
        String ma = dh.getMaKD();
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "KD00"+nextto;
        }
        if(nextto<100){
            return "KD0"+nextto;
        }
        return "KD"+nextto;
    }

    public static boolean themKIEUDANG(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO KIEUDANG(MAKIEUDANG, TENKIEUDANG) VALUES(N'%s',N'%s')",
                ma, ten);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capnhatKIEUDANG(KIEUDANG nv) {
        boolean kq = false;
        String sql = String.format("UPDATE KIEUDANG SET TENKIEUDANG=N'%s'WHERE MAKIEUDANG=%d", 
                nv.getTenKD(),nv.getMaKD());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaKIEUDANG(int maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM KIEUDANG WHERE MAKIEUDANG = %d", maNV);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    public ArrayList<KIEUDANG> layDanhSachKieuDang() {
        ArrayList<KIEUDANG> dsKD = new ArrayList<>();
        String sql = "SELECT * FROM KIEUDANG";
        
        try {
            ConnectDatabase con = new ConnectDatabase();
            con.Open();
            ResultSet rs = con.executeQuery(sql);
            while (rs.next()) {
                KIEUDANG kd = new KIEUDANG();
                kd.setMaKD(rs.getString("MaKieuDang"));
                kd.setTenKD(rs.getString("TenKieuDang"));
                dsKD.add(kd);
            }
            con.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsKD;
    }
    public static boolean themKieuDang(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO KIEUDANG(MaKieuDang, TenKieuDang) VALUES(N'%s',N'%s')",
                ma, ten);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public static boolean suaKieuDang(String ten, String ma) {
        boolean kq = false;
        String sql = String.format("UPDATE KIEUDANG SET TenKieuDang=N'%s'WHERE MaKieuDang='%s'", ten,ma);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }

    public static boolean xoaKieuDang(String maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM KIEUDANG WHERE MaKieuDang ='%s'", maNV);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
}
