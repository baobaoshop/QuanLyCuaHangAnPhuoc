/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class KIEUDANG {

    public String getMaKD() {
        return maKD;
    }

    public void setMaKD(String maKD) {
        this.maKD = maKD;
    }

    public KIEUDANG() {
    }

    public String getTenKD() {
        return tenKD;
    }

    public void setTenKD(String tenKD) {
        this.tenKD = tenKD;
    }

    public KIEUDANG(String maKD, String tenKD) {
        this.maKD = maKD;
        this.tenKD = tenKD;
    }
    String maKD, tenKD;

    @Override
    public String toString() {
        return tenKD;
    }
    
}
