/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.KhachHang;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public interface Tai_NvqlLuongPhieuXuatService {

    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc);

    public KhachHang getKhachHangByMa(String ma);

    public NhanVien getNhanVienByMa(String ma);
    List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuat(UUID idPX);
    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPham();
    public boolean addCTPX(Luong_ChiTietPhieuXuatCustom ctpxct);
    public void updateCTSP(LuongBanHang_ChiTietSanPhamCustom ctspct);
    void updateCTPX(Luong_ChiTietPhieuXuatCustom ctpxct);
}
