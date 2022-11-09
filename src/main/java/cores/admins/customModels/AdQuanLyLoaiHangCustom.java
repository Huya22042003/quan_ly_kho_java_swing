/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.customModels;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class AdQuanLyLoaiHangCustom {
    private UUID id;
    private String ma;
    private String ten;
    private String moTa;
    private BigDecimal gia;

    public AdQuanLyLoaiHangCustom() {
    }

    public AdQuanLyLoaiHangCustom(UUID id, String ma, String ten, String moTa, BigDecimal gia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
    }

    public AdQuanLyLoaiHangCustom(String ma, String ten, String moTa, BigDecimal gia) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
    
    
}
