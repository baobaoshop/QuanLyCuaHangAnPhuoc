/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.MODAL;

/**
 *
 * @author PC
 */
public class USER {

    public String getRole() {
        return role;
    }

    public USER() {
    }
    

    public void setRole(String role) {
        this.role = role;
    }

    public USER(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }
    String username, password, role;
}
