/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class GIAMGIA {

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSotiengiam() {
        return sotiengiam;
    }

    public void setSotiengiam(int sotiengiam) {
        this.sotiengiam = sotiengiam;
    }

    public float getChietkhau() {
        return chietkhau;
    }

    public void setChietkhau(float chietkhau) {
        this.chietkhau = chietkhau;
    }

    public GIAMGIA(String masp, int sotiengiam, float chietkhau) {
        this.masp = masp;
        this.sotiengiam = sotiengiam;
        this.chietkhau = chietkhau;
    }
    String masp;
    int sotiengiam;
    float chietkhau;
}
