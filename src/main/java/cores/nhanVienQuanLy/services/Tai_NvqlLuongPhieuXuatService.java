package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import domainModels.NhanVien;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public interface Tai_NvqlLuongPhieuXuatService {

    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc);
    public NhanVien getNhanVienByMa(String ma);
    List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuatByID(UUID idPX);
    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPham();
    public boolean addCTPX(Luong_ChiTietPhieuXuatCustom ctpxct);
    public void updateCTSP(LuongBanHang_ChiTietSanPhamCustom ctspct);
    void updateCTPX(Luong_ChiTietPhieuXuatCustom ctpxct);
    List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuat();
}
