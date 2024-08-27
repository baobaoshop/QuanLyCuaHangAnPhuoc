/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.CT_DONHANG;
import cuahanganphuoc.MODAL.DONHANG;
import cuahanganphuoc.MODAL.KIEUDANG;
import cuahanganphuoc.MODAL.LUUTRU;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DonHangDAO {
    public static void loadAll() {
        List<DONHANG> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DONHANG";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                DONHANG ma = new DONHANG();
                ma.setMaDH(resultSet.getString("MaDonHang"));
                ma.setMaKH(resultSet.getString("MaKhachHang"));
                ma.setNgayMua(resultSet.getDate("NgayMua"));
                ma.setTongTien(Integer.parseInt(resultSet.getString("TongTien")));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listDonHang = dsMA;
    }
    public static String taoMaDHMoi(){
        DONHANG dh = LUUTRU.listDonHang.get(LUUTRU.listDonHang.size()-1);
        String ma = dh.getMaDH();
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "DH00"+nextto;
        }
        if(nextto<100){
            return "DH0"+nextto;
        }
        return "DH"+nextto;
    }
    public static boolean themHoaDon(DONHANG x) {
        try {
            Date currentDay = new Date();
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "insert into DONHANG values('" + x.getMaDH()+ "','" + x.getMaKH()+ "','" + new SimpleDateFormat("yyyy/MM/dd").format(currentDay) + "','" + x.getTongTien() + "')";
            if (serverProvider.executeUpdate(sql)) {
                serverProvider.close();
                return true;
            }
            serverProvider.close();
            loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getLastInsertMaHoaDon() {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "select * from DONHANG";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.last()) {
                return resultSet.getString("MAHD");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<DONHANG> layDanhSachHoaDon() {
        ArrayList<DONHANG> dsDH = new ArrayList<>();
        try {
            String sql = "Select * from DONHANG";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                DONHANG hd = new DONHANG();
                hd.setMaDH(resultSet.getString(1));
                hd.setMaKH(resultSet.getString(2));
                hd.setNgayMua(resultSet.getDate(4));
                hd.setTongTien(resultSet.getInt(5));
                dsDH.add(hd);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDH;
    }
   
    
}
