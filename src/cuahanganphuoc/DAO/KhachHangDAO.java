/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.DONHANG;
import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.LUUTRU;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class KhachHangDAO {
    public static void loadAll() {
        List<KHACHHANG> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KHACHHANG";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                KHACHHANG ma = new KHACHHANG();
                ma.setMa(resultSet.getString("MaKhachHang"));
                ma.setTen(resultSet.getString("TenKhachHang"));
                ma.setEmail(resultSet.getString("Email"));
                ma.setSdt(resultSet.getString("SoDienThoai"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listKhachHang = dsMA;
    }
    public static KHACHHANG getKhachHangBySDT(String sdt){
        for(KHACHHANG kh : LUUTRU.listKhachHang){
            if(kh.getSdt().equals(sdt)){
                return kh;
            }
        }
        return null;
    }
    public static String getTENKHbyMAKH(String Ma){
        for(KHACHHANG item:LUUTRU.listKhachHang){
            if(item.getMa().equals(Ma)){
                return item.getTen();
            }
        }
        return null;
    }
    
    public static String taoMaKHMoi(){
        KHACHHANG dh = LUUTRU.listKhachHang.get(LUUTRU.listKhachHang.size()-1); //***
        String ma = dh.getMa(); //*
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "KH00"+nextto; //*
        }
        if(nextto<100){
            return "KH0"+nextto; //*
        }
        return "KH"+nextto; //*
    }
    
    public static boolean ktSdtTrung(String sdt){
        for(KHACHHANG item:LUUTRU.listKhachHang){
            if(item.getSdt().equals(sdt)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean themKH(KHACHHANG kh) {
        boolean kq = false;
        String sql = String.format("INSERT INTO KHACHHANG VALUES('%s',N'%s', '%s', '%s')",
                kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capnhatKH(KHACHHANG nv) {
        boolean kq = false;
        String sql = String.format("UPDATE KHACHHANG SET Tenkhachhang=N'%s', email='%s', sodienthoai='%s' WHERE makhachhang='%s'", 
                nv.getTen(),nv.getEmail(), nv.getSdt(), nv.getMa());
        System.out.println(sql);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

//    public static boolean xoaMAUSAC(int maNV) {
//        boolean kq = false;
//        String sql = String.format("DELETE FROM MAUSAC WHERE MAMAUSAC = %d", maNV);
//        SQLServerProvider provider = new SQLServerProvider();
//        provider.open();
//        if (provider.executeUpdate(sql)) {
//            kq = true;
//        }
//        provider.close();
//        return kq;
//    }
    public static boolean themKhachHang(String ma, String ten, String email, String sdt) {
        boolean kq = false;
        String sql = String.format("INSERT INTO KHACHHANG(MaKhachHang, TenKhachHang,Email,SoDienThoai) VALUES(N'%s',N'%s',N'%s',N'%s')",
                ma, ten, email,sdt);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public static boolean suaKhachHang(String ten, String ma, String email, String sdt) {
        boolean kq = false;
        String sql = String.format("UPDATE KHACHHANG SET TenKhachHang=N'%s', Email =N'%s',SoDienThoai = N'%s'  WHERE MaKhachHang='%s'", ten, email,sdt,ma);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }

    public static boolean xoaKhachHang(String maKH) {
        boolean kq = false;
        String sql = String.format("DELETE FROM KHACHHANG WHERE MaKhachHang ='%s'", maKH);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public ArrayList<KHACHHANG> layDanhSachKhachHang() {
        ArrayList<KHACHHANG> dsKH = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        
        try {
            ConnectDatabase con = new ConnectDatabase();
            con.Open();
            ResultSet rs = con.executeQuery(sql);
            while (rs.next()) {
                KHACHHANG kh = new KHACHHANG();
                kh.setMa(rs.getString("MaKhachHang"));
                kh.setTen(rs.getString("TenKhachHang"));
                kh.setEmail(rs.getString("Email"));
                kh.setSdt(rs.getString("SoDienThoai"));
                dsKH.add(kh);
            }
            con.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsKH;
    }
}
