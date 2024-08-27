/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahanganphuoc.DAO;

import cuahanganphuoc.MODAL.CHATLIEU;
import cuahanganphuoc.MODAL.KIEUDANG;
import cuahanganphuoc.MODAL.LOAISP;
import cuahanganphuoc.MODAL.LUUTRU;
import cuahanganphuoc.MODAL.MAUSAC;
import cuahanganphuoc.MODAL.SIZE;

/**
 *
 * @author user
 */
public class ThamChieuDAO {

    
    
    public static String getTENSIZEbyMASIZE(String Ma){
        
        for(SIZE item:LUUTRU.listSize){
            if(item.getMa().equals(Ma)){
                return item.getTen();
            }
        }
        return null;
    }
    public static String getTENKIEUDANGbyMAKIEUDANG(String Ma){
        
        for(KIEUDANG item:LUUTRU.listKieDang){
            if(item.getMaKD().equals(Ma)){
                return item.getTenKD();
            }
        }
        return null;
    }
    public static String getTENCHATLIEUbyMACHATLIEU(String Ma){
        for(CHATLIEU item:LUUTRU.listChatLieu){
            if(item.getMaCL().equals(Ma)){
                return item.getTenCL();
            }
        }
        return null;
    }
    public static String getTENMAUSACbyMAMAUSAC(String Ma){
        for(MAUSAC item:LUUTRU.listMauSac){
            if(item.getMaMS().equals(Ma)){
                return item.getTenMS();
            }
        }
        return null;
    }
    
    public static String getTENLOAIbyMALOAI(String Ma){
        
        for(LOAISP item:LUUTRU.listLoaiSp){
            if(item.getMaLoai().equals(Ma)){
                return item.getTenLoai();
            }
        }
        return null;
    }
    
    public static SIZE getSIZEbyTENSIZE(String Ma){
        
        for(SIZE item:LUUTRU.listSize){
            if(item.getTen().equals(Ma)){
                return item;
            }
        }
        return null;
    }
    public static KIEUDANG getKIEUDANGbyTENKIEUDANG(String Ma){
        
        for(KIEUDANG item:LUUTRU.listKieDang){
            if(item.getTenKD().equals(Ma)){
                return item;
            }
        }
        return null;
    }
    public static CHATLIEU getCHATLIEUbyTENCHATLIEU(String Ma){
        for(CHATLIEU item:LUUTRU.listChatLieu){
            if(item.getTenCL().equals(Ma)){
                return item;
            }
        }
        return null;
    }
    public static MAUSAC getMAUSACbyTENMAUSAC(String Ma){
        for(MAUSAC item:LUUTRU.listMauSac){
            if(item.getTenMS().equals(Ma)){
                return item;
            }
        }
        return null;
    }
    public static LOAISP getLOAISPCbyTENLOAISP(String Ma){
        for(LOAISP item:LUUTRU.listLoaiSp){
            if(item.getTenLoai().equals(Ma)){
                return item;
            }
        }
        return null;
    }
    
}
