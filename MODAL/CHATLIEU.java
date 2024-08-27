/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class CHATLIEU {

    public String getMaCL() {
        return maCL;
    }

    public CHATLIEU() {
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public CHATLIEU(String maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }
    String maCL, tenCL;

    @Override
    public String toString() {
        return tenCL;
    }
    
}
