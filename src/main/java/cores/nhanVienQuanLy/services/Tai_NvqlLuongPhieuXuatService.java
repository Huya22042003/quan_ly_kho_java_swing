/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

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

    public List<ChiTietSanPham> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc);

    public KhachHang getKhachHangByMa(String ma);

    public NhanVien getNhanVienByMa(String ma);
    List<ChiTietPhieuXuat> getListCTPhieuXuat(UUID idPX);
    public List<ChiTietSanPham> getListCTSanPham();
    public ChiTietPhieuXuat addCTPX(ChiTietPhieuXuat ctpx);
    public void updateCTSP(ChiTietSanPham ctsp);
    void updateCTPX(ChiTietPhieuXuat ctpx);
}
