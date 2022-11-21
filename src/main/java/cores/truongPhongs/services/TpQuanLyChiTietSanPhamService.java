/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLyNamBHCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import domainModels.DonVi;
import domainModels.NamBaoHanh;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author MMC
 */
public interface TpQuanLyChiTietSanPhamService {

    public List<TpQuanLyChiTietSanPhamCustom> getAll();

    TpQuanLyChiTietSanPhamCustom addCTSanPham(TpQuanLyChiTietSanPhamCustom custom);

    boolean updateCTSanPham(TpQuanLyChiTietSanPhamCustom custom);

    boolean deleteCTSanPham(UUID id);

    TpQuanLyChiTietSanPhamCustom findCTSanPhamById(UUID id);

    TpQuanLyChiTietSanPhamCustom findCTSanPhamGia(BigDecimal gia);

    List<TpQuanLyChiTietSanPhamCustom> findAllByRadio(int rdo,MauConstant tt, String tk);

    //TpQuanLyChiTietSanPhamCustom checkValidate(TpQuanLyChiTietSanPhamCustom sp, JLabel erroGiaNhap, JLabel erroGiaBan, JLabel erroSoLuong);
    TpQuanLyChiTietSanPhamCustom checkValidate(UUID donVi,UUID namBH, UUID sanPham,String hinhAnh,String giaNhap, String giaBan, String soLuong,JLabel erroHinhAnh,JLabel erroGiaNhap, JLabel erroGiaBan, JLabel erroSoLuong ,MauConstant mau);
    
    public List<TpQuanLyDonViCustom> getAllDonVi();
    
    public DonVi findIDDonVi(UUID id);
    
    public List<TpQuanLyNamBHCustom> getAllNamBH();
    
    public NamBaoHanh findIDBaoHanh(UUID id);
    
    public List<TpQuanLySanPhamCustom> getAllSanPham();
    
    public SanPham findIDSanPham(UUID id);
    
    MauConstant loc(int a);
    
    void loadCombobox(Combobox cbb);
}
