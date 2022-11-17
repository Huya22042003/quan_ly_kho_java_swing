/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.customModels;

import domainModels.ChiTietPhieuHoanXuat;
import domainModels.DonVi;
import domainModels.NamBaoHanh;
import domainModels.SanPham;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author MMC
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpQuanLyChiTietSanPhamCustom {
    private UUID id;

    private int soLuongTon;

    private String hinhAnh;

    private BigDecimal GiaNhap;

    private BigDecimal GiaBan;

    private SanPham sanPham;


    private DonVi donVi;


    private NamBaoHanh namBaoHanh;
    
//    @OneToMany(mappedBy = "idChiTietSp")
//    private List<ChiTietPhieuHoanNhap> chiTietPhieuHoanNhaps;
    
    private List<ChiTietPhieuHoanXuat> chiTietPhieuHoanXuats;
}