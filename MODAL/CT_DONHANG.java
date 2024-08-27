/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class CT_DONHANG {

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public CT_DONHANG() {
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public CT_DONHANG(String maDH, String maSP, int SoLuong, int ThanhTien) {
        this.maDH = maDH;
        this.maSP = maSP;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }
    String maDH, maSP;
    int SoLuong, ThanhTien;
}
