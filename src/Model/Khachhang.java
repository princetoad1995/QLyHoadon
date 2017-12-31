/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PRINCE D. TOAD
 */
public class Khachhang extends Nguoi{
    private int maKH;
    private String loaiKhachhang;

    public Khachhang() {
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getLoaiKhachhang() {
        return loaiKhachhang;
    }

    public void setLoaiKhachhang(String loaiKhachhang) {
        this.loaiKhachhang = loaiKhachhang;
    }

    @Override
    public String toString() {
        return hoten; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
