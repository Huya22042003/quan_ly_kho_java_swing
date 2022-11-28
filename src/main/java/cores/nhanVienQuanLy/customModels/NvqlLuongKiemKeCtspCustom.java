/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author window
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NvqlLuongKiemKeCtspCustom {
    private UUID id;
    private String ma;
    private String ten;
    private int soLuongTon;
    private DonVi donVi;
    private MauConstant mau;
    private int namBaoHanh;
    private BigDecimal giaBan;
    private String hinhAnh; 
    private BigDecimal giaNhap;
    private TrangThaiSanPhamConstanst trangThai;
    private SanPham sanPham;

    public NvqlLuongKiemKeCtspCustom(UUID id, String ma, String ten, int soLuongTon, DonVi donVi, MauConstant mau, int namBaoHanh, BigDecimal giaBan) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
        this.donVi = donVi;
        this.mau = mau;
        this.namBaoHanh = namBaoHanh;
        this.giaBan = giaBan;
    }
    
    
}

