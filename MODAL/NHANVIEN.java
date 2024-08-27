/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class NHANVIEN {

    public NHANVIEN(String maNV, String tenNV, String email, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.email = email;
        this.sdt = sdt;
    }

    public NHANVIEN() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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
    String maNV, tenNV, email, sdt;
}
