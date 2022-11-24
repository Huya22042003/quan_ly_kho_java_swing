/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.repositories.Tai_NvqlLuongPhieuXuatRepository;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.KhachHang;
import domainModels.NhanVien;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class Tai_NvqlLuongPhieuXuatServiceImpl implements Tai_NvqlLuongPhieuXuatService{
    private Tai_NvqlLuongPhieuXuatRepository rp;

    public Tai_NvqlLuongPhieuXuatServiceImpl() {
        rp = new Tai_NvqlLuongPhieuXuatRepository();
    }
    
    @Override
    public List<ChiTietSanPham> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc) {
        return rp.getListCTSanPhamBanHang(giaBatDau, giaKetThuc);
    }

    @Override
    public KhachHang getKhachHangByMa(String ma) {
        return rp.getKhachHangByMa(ma);
    }

    @Override
    public NhanVien getNhanVienByMa(String ma) {
        return rp.getNhanVienByMa(ma);
    }

    @Override
    public List<ChiTietPhieuXuat> getListCTPhieuXuat(UUID idPX) {
        return rp.getListCTPhieuXuat(idPX);
    }

    @Override
    public List<ChiTietSanPham> getListCTSanPham() {
        return rp.getListCTSanPham();
    }

    @Override
    public ChiTietPhieuXuat addCTPX(ChiTietPhieuXuat ctpx) {
        return rp.addCTPX(ctpx);
    }

    @Override
    public void updateCTSP(ChiTietSanPham ctsp) {
        rp.updateCTSP(ctsp);
    }



    @Override
    public void updateCTPX(ChiTietPhieuXuat ctpx) {
        rp.updateCTPX(ctpx);
    }
    
}
