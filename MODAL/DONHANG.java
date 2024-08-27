/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

import java.util.Date;

/**
 *
 * @author PC
 */
public class DONHANG {

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public DONHANG() {
    }


    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public DONHANG(String maDH, String maKH, Date NgayMua, int TongTien) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.NgayMua = NgayMua;
        this.TongTien = TongTien;
    }
    String maDH, maKH;
    Date NgayMua;
    int TongTien;
}
