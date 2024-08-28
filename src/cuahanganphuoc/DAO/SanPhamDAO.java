/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.LUUTRU;
import cuahanganphuoc.MODAL.SANPHAM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author PC
 */
public class SanPhamDAO {
    public static void loadAll() {
        ArrayList<SANPHAM> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SANPHAM";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                SANPHAM ma = new SANPHAM();
                ma.setMa(resultSet.getString("MASANPHAM"));
                ma.setTen(resultSet.getString("TENSANPHAM"));
                 ma.setHinhanh(resultSet.getString("HINHANH"));
                ma.setGiaban(resultSet.getInt("GIABAN"));
                ma.setTrangthai(resultSet.getInt("TRANGTHAI"));
                ma.setLoaisp(resultSet.getString("LOAISANPHAM"));
                ma.setMausac(resultSet.getString("MAUSAC"));
                ma.setSoluong(Integer.parseInt(resultSet.getString("SOLUONG")));
                ma.setChatlieu(resultSet.getString("CHATLIEU"));
                ma.setKieudang(resultSet.getString("KIEUDANG"));
                ma.setSize(resultSet.getString("SIZE"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listSanPham = dsMA;
    }
    public static String taoMaKHMoi(){
        SANPHAM dh = LUUTRU.listSanPham.get(LUUTRU.listSanPham.size()-1); //***
        String ma = dh.getMa(); //*
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "SP00"+nextto; //*
        }
        if(nextto<100){
            return "SP0"+nextto; //*
        }
        return "SP"+nextto; //*
    }
    public static List<SANPHAM> showSANPHAM(String key, int sort) {
        List<SANPHAM> list = LUUTRU.listSanPham;
        List<SANPHAM> newlist = new ArrayList<>();
        for(SANPHAM sp : list){
            if(sp.getMa().contains(key) || sp.getTen().contains(key) || sp.getLoaisp().contains(key)){
                newlist.add(sp);
            }
        }
        
        if(sort==1){
            Collections.sort(newlist, new Comparator<SANPHAM>() {
                @Override
                public int compare(SANPHAM sp1, SANPHAM sp2) {
                    return Double.compare(sp1.getGiaban(), sp2.getGiaban());
                }
            });
        } else if(sort==2){
            Collections.sort(newlist, new Comparator<SANPHAM>() {
                @Override
                public int compare(SANPHAM sp1, SANPHAM sp2) {
                    return Double.compare(sp1.getGiaban(), sp2.getGiaban());
                }
            });
            Collections.reverse(newlist);
        }
        
        return newlist;
//        ArrayList<SANPHAM> dsMA = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM SANPHAM where (MASANPHAM LIKE '%" + key + "%' OR TENSANPHAM LIKE '%" + key + "%' OR LOAISANPHAM LIKE '%" + key + "%')";
//            if(sort == 1){
//                sql = "SELECT * FROM SANPHAM where MASANPHAM LIKE '%" + key + "%' OR TENSANPHAM LIKE '%" + key + "%' order by GIABAN asc ";
//
//            }else if(sort == 2) {
//                sql = "SELECT * FROM SANPHAM where MASANPHAM LIKE '%" + key + "%' OR TENSANPHAM LIKE '%" + key + "%' order by GIABAN desc  ";
//            }
//            SQLServerProvider provider = new SQLServerProvider();
//            provider.open();
//            ResultSet resultSet = provider.executeQuery(sql);
//            while (resultSet.next()) {
//                SANPHAM ma = new SANPHAM();
//                ma.setMa(resultSet.getString("MASANPHAM"));
//                ma.setTen(resultSet.getString("TENSANPHAM"));
//                 ma.setHinhanh(resultSet.getString("HINHANH"));
//                ma.setGiaban(resultSet.getInt("GIABAN"));
//                ma.setTrangthai(resultSet.getInt("TRANGTHAI"));
//                ma.setLoaisp(resultSet.getString("LOAISANPHAM"));
//                ma.setMausac(resultSet.getString("MAUSAC"));
//                ma.setSoluong(Integer.parseInt(resultSet.getString("SOLUONG")));
//                ma.setChatlieu(resultSet.getString("CHATLIEU"));
//                ma.setKieudang(resultSet.getString("KIEUDANG"));
//                ma.setSize(resultSet.getString("SIZE"));
//                dsMA.add(ma);
//            }
//            provider.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dsMA;
    }
    public static SANPHAM getSanPhamByMa(String maSP){
        for(SANPHAM sp : LUUTRU.listSanPham){
            if(sp.getMa().equals(maSP)){
                return sp;
            }
        }
        return null;
    }
    public static String getTenSanPhamByMa(String maSP){
        for(SANPHAM sp : LUUTRU.listSanPham){
            if(sp.getMa().equals(maSP)){
                return sp.getTen();
            }
        }
        return null;
    }
    
    public static int getSoLuongTonTheoMa(String ma){
        for(SANPHAM sp : LUUTRU.listSanPham){
            if(sp.getMa().equals(ma)){
                return sp.getSoluong();
            }
        }
        return -1;
    }

    public static boolean themCSDL(SANPHAM m) {
        boolean kq = false;
        String sql = "INSERT INTO SANPHAM VALUES('" + m.getMa()+ "', N'" + m.getTen()+ "', '" + m.getHinhanh()+ "', '" + m.getGiaban()+ "', N'" + m.getTrangthai()+ "', N'" + m.getLoaisp()+ "', N'" + m.getMausac()+ "', N'" + m.getChatlieu()+ "', N'" + m.getKieudang()+ "', N'" + m.getSoluong()+ "', N'" + m.getSize()+ "')";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capNhatCSDL(SANPHAM m) {
        boolean kq = false;
        String sql = "UPDATE SANPHAM SET TENSANPHAM=N'" + m.getTen()+ "', HINHANH='" + m.getHinhanh()+ "', GIABAN=" + m.getGiaban()+ ", TRANGTHAI=" + m.getTrangthai()+ ", LOAISANPHAM='" + m.getLoaisp()+ "', MAUSAC='" + m.getMausac()+ "', CHATLIEU='" + m.getChatlieu()+ "', KIEUDANG='" + m.getKieudang()+ "', SOLUONG=" + m.getSoluong()+ ", SIZE='" + m.getSize()+ "' where MASANPHAM='" + m.getMa()+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        loadAll();
        return kq;
    }

    public static boolean xoaCSDL(String m) {
        boolean kq = false;
        String sql = "DELETE FROM SANPHAM WHERE MASANPHAM ='" + m+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
}
