/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.KHACHHANG;
import cuahanganphuoc.MODAL.LOAISP;
import cuahanganphuoc.MODAL.LUUTRU;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LoaiSPDAO {
    public static void loadAll() {
        ArrayList<LOAISP> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM LOAISANPHAM";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                LOAISP ma = new LOAISP();
                ma.setMaLoai(resultSet.getString("MALOAI"));
                ma.setTenLoai(resultSet.getString("TENLOAI"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listLoaiSp = dsMA;
    }
    public static String taoMaKHMoi(){
        LOAISP dh = LUUTRU.listLoaiSp.get(LUUTRU.listLoaiSp.size()-1);
        String ma = dh.getMaLoai();
        String[] arr = ma.split("");
        String socuoi = arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "LSP0"+nextto;
        }
        return "LSP"+nextto;
    }
    
    public ArrayList<LOAISP> layDanhSachLoaiSanPham() {
        ArrayList<LOAISP> dsLoai = new ArrayList<>();
        String sql = "SELECT * FROM LOAISANPHAM";
        
        try {
            ConnectDatabase con = new ConnectDatabase();
            con.Open();
            ResultSet rs = con.executeQuery(sql);
            while (rs.next()) {
                LOAISP lsp = new LOAISP();
                lsp.setMaLoai(rs.getString("MaLoai"));
                lsp.setTenLoai(rs.getString("TenLoai"));
                dsLoai.add(lsp);
            }
            con.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsLoai;
    }
    public static boolean themLoaiSanPham(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO LOAISANPHAM(MaLoai, TenLoai) VALUES(N'%s',N'%s')",
                ma, ten);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public static boolean suaLoaiSanPham(String ten, String ma) {
        boolean kq = false;
        String sql = String.format("UPDATE LOAISANPHAM SET TenLoai=N'%s'WHERE MaLoai='%s'", ten,ma);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }

    public static boolean xoaLoaiSanPham(String maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM LOAISANPHAM WHERE MaLoai ='%s'", maNV);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    
}
