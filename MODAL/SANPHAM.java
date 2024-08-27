/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class SANPHAM {
    String ma, ten, loaisp, mausac, chatlieu, kieudang, hinhanh, size;
    int giaban, trangthai, soluong;

    public SANPHAM() {
    }

    public SANPHAM(String ma, String ten, String loaisp, String mausac, String chatlieu, String kieudang, String hinhanh, String size, int giaban, int trangthai, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.loaisp = loaisp;
        this.mausac = mausac;
        this.chatlieu = chatlieu;
        this.kieudang = kieudang;
        this.hinhanh = hinhanh;
        this.size = size;
        this.giaban = giaban;
        this.trangthai = trangthai;
        this.soluong = soluong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getKieudang() {
        return kieudang;
    }

    public void setKieudang(String kieudang) {
        this.kieudang = kieudang;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
public void truSoLuong(int sl){
    soluong -= sl;
}
    
}
