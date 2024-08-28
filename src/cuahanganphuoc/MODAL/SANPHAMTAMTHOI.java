/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author user
 */
public class SANPHAMTAMTHOI {
    String MaString, TenString;
    int SoLuong, DonGia, ThanhTien;

    public SANPHAMTAMTHOI() {
    }

    public SANPHAMTAMTHOI(String MaString, String TenString, int SoLuong, int DonGia) {
        this.MaString = MaString;
        this.TenString = TenString;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = SoLuong*DonGia;
    }

    public String getMaString() {
        return MaString;
    }

    public void setMaString(String MaString) {
        this.MaString = MaString;
    }

    public String getTenString() {
        return TenString;
    }

    public void setTenString(String TenString) {
        this.TenString = TenString;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien() {
        this.ThanhTien = SoLuong*DonGia;
    }
    
}
