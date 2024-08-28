/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.CHATLIEU;
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
public class ChatLieuDAO {
    public static void loadAll() {
        List<CHATLIEU> dsMA = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CHATLIEU";
           
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                CHATLIEU ma = new CHATLIEU();
                ma.setMaCL(resultSet.getString("MACHATLIEU"));
                ma.setTenCL(resultSet.getString("TENCHATLIEU"));
                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LUUTRU.listChatLieu = dsMA;
    }
public static String taoMaKHMoi(){
        CHATLIEU dh = LUUTRU.listChatLieu.get(LUUTRU.listChatLieu.size()-1); //***
        String ma = dh.getMaCL(); //*
        String[] arr = ma.split("");
        String socuoi = arr[2] + arr[3] + arr[4];
        int next = Integer.parseInt(socuoi);
        int nextto = next+1;
        if(nextto<10){
            return "CL00"+nextto; //*
        }
        if(nextto<100){
            return "CL0"+nextto; //*
        }
        return "CL"+nextto; //*
    }
    public static boolean themCHATLIEU(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO CHATLIEU(MACHATLIEU, TENCHATLIEU) VALUES(N'%s',N'%s')",
                ma, ten);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capnhatCHATLIEU(CHATLIEU nv) {
        boolean kq = false;
        String sql = String.format("UPDATE CHATLIEU SET TENCHATLIEU=N'%s'WHERE MACHATLIEU=%d", 
                nv.getTenCL(),nv.getMaCL());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaCHATLIEU(int maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM CHATLIEU WHERE MACHATLIEU = %d", maNV);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    public ArrayList<CHATLIEU> layDanhSachChatLieu() {
        ArrayList<CHATLIEU> dsCL = new ArrayList<>();
        String sql = "SELECT * FROM CHATLIEU";
        
        try {
            ConnectDatabase con = new ConnectDatabase();
            con.Open();
            ResultSet rs = con.executeQuery(sql);
            while (rs.next()) {
                CHATLIEU cl = new CHATLIEU();
                cl.setMaCL(rs.getString("MaChatLieu"));
                cl.setTenCL(rs.getString("TenChatLieu"));
                dsCL.add(cl);
            }
            con.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsCL;
    }
    public static boolean themChatLieu(String ma, String ten) {
        boolean kq = false;
        String sql = String.format("INSERT INTO CHATLIEU(MaChatLieu, TenChatLieu) VALUES(N'%s',N'%s')",
                ma, ten);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
    public static boolean suaChatLieu(String ten, String ma) {
        boolean kq = false;
        String sql = String.format("UPDATE CHATLIEU SET TenChatLieu=N'%s'WHERE MaChatLieu='%s'", ten,ma);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }

    public static boolean xoaChatLieu(String maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM CHATLIEU WHERE MaChatLieu ='%s'", maNV);
        ConnectDatabase con = new ConnectDatabase();
        con.Open();
        if (con.executeUpdate(sql)) {
            kq = true;
        }
        con.Close();
        return kq;
    }
}
