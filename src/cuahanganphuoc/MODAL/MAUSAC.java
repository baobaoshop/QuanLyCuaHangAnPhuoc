/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class MAUSAC {

    public MAUSAC() {
    }

    
    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public MAUSAC(String maMS, String tenMS) {
        this.maMS = maMS;
        this.tenMS = tenMS;
    }
    String maMS, tenMS;

    @Override
    public String toString() {
        return tenMS;
    }
    
}
