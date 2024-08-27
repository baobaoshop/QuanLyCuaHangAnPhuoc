/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class KHACHHANG {

    public KHACHHANG() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public KHACHHANG(String ma, String ten, String email, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
    }
    String ma, ten, email, sdt;
}
