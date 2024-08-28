/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.CT_DONHANG;
import cuahanganphuoc.MODAL.LUUTRU;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class CTDHDAO {
    public static void loadAll() {
        List<CT_DONHANG> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CHITIETDONHANG";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                CT_DONHANG ma = new CT_DONHANG();
                ma.setMaDH(resultSet.getString("MaDonHang"));
                ma.setMaSP(resultSet.getString("MaSanPham"));
                ma.setSoLuong(Integer.parseInt(resultSet.getString("SoLuong")));
                ma.setThanhTien(Integer.parseInt(resultSet.getString("ThanhTien")));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listCTDH = dsMA;
    }
    public static boolean themCTHoaDon(CT_DONHANG x) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "insert into CHITIETDONHANG values('" + x.getMaDH()+ "','" + x.getMaSP()+ "','" + x.getSoLuong() + "','" + x.getThanhTien()+ "')";
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
}
