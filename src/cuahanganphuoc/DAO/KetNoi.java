/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class KetNoi {
    public  static Connection OpenConnection()
    {
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
            String url ="jdbc:sqlserver://localhost:1433;databaseName=CuaHangAnPhuoc;instance=SQLSERVER;encrypt=true;TrustServerCertificate=true;";
            String user="sa";
            String password="Password.1";

            con = DriverManager.getConnection(url, user, password);
            
        }catch(Exception E)
        {
            E.printStackTrace();
        }
        return con;
    }
}
