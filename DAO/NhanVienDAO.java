/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.NHANVIEN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhanVienDAO {
     public static ArrayList<NHANVIEN> layDanhSachNhanVien(String keys) {
        ArrayList<NHANVIEN> dsNV = new ArrayList<>();
        String sql;
        try {
            if (keys.isEmpty()) {
                sql = "SELECT * FROM NHANVIEN nv, BOPHAN bp WHERE nv.MABP = bp.MABP";
            } 
            else if(keys == "0") {
                sql = "SELECT * FROM NHANVIEN nv, BOPHAN bp WHERE nv.MABP = bp.MABP and nv.MABP = 3";
            }
            else {
                sql = "SELECT * FROM NHANVIEN nv, BOPHAN bp WHERE nv.MABP = bp.MABP AND (MANV LIKE N'%" + keys + "%' OR HOTENNV LIKE N'%" + keys + "%' OR TENBP LIKE N'%" + keys + "%')";
            }
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                NHANVIEN nv = new NHANVIEN();
                nv.setMaNV(rs.getString("MANV"));
                nv.setTenNV(rs.getString("TENNV"));
                nv.setSdt(rs.getString("SDT"));
                nv.setEmail(rs.getString("email"));
                dsNV.add(nv);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNV;
    }

    public static boolean themNhanVien(int maBP, String hinh, String ten, String sdt, String ngaysinh, String gioitinh, String dc) {
        boolean kq = false;
        String sql = String.format("INSERT INTO NHANVIEN(MABP,HINH,HOTENNV,SDT,NGAYSINH,GIOITINH,DIACHI) VALUES(%d,N'%s',N'%s','%s','%s',N'%s',N'%s')",
                maBP, hinh, ten, sdt, ngaysinh, gioitinh, dc);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capnhatNhanVien(NHANVIEN nv) {
        boolean kq = false;
        String sql = String.format("UPDATE NHANVIEN SET TENNV=N'%s', SDT='%s', EMAIL = N'%s' WHERE MANV=%d", 
                nv.getTenNV(), nv.getSdt(), nv.getEmail(),nv.getMaNV());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaNhanVien(int maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM NHANVIEN WHERE MANV = %d", maNV);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static String getTenNV(String ma) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "SELECT HOTENNV FROM NHANVIEN WHERE MANV='" + ma + "'";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("HOTENNV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
