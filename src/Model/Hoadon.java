/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author PRINCE D. TOAD
 */
public class Hoadon {

    private int maHD;
    private Khachhang khachhang;
    private String ngaytao;
    private List<Pair<Mathang, Integer>> listMH;
    private float tongTien;

    public Hoadon() {
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public List<Pair<Mathang, Integer>> getListMH() {
        return listMH;
    }

    public void setListMH(List<Pair<Mathang, Integer>> listMH) {
        this.listMH = listMH;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

}
