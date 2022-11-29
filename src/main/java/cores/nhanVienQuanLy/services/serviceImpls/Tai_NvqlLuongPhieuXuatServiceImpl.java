package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import cores.nhanVienQuanLy.repositories.Tai_NvqlLuongPhieuXuatRepository;
import cores.nhanVienQuanLy.services.Tai_NvqlLuongPhieuXuatService;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.NhanVien;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class Tai_NvqlLuongPhieuXuatServiceImpl implements Tai_NvqlLuongPhieuXuatService {

    private Tai_NvqlLuongPhieuXuatRepository rp;

    public Tai_NvqlLuongPhieuXuatServiceImpl() {
        rp = new Tai_NvqlLuongPhieuXuatRepository();
    }

    @Override
    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc) {
        return rp.getListCTSanPhamBanHang(giaBatDau, giaKetThuc);
    }


    @Override
    public List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuatByID(UUID idPX) {
        return rp.getListCTPhieuXuat(idPX);
    }

    @Override
    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPham() {
        return rp.getListCTSanPham();
    }

    @Override
    public boolean addCTPX(Luong_ChiTietPhieuXuatCustom ctpxct) {
        ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
        ctpx.setIdChiTietSp(ctpxct.getIdChiTietSp());
        ctpx.setIdPhieuXuat(ctpxct.getIdPhieuXuat());
        ctpx.setSoLuong(ctpxct.getSoLuong());
        return rp.addCTPX(ctpx);
    }

    @Override
    public void updateCTSP(LuongBanHang_ChiTietSanPhamCustom ctspct) {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setDonVi(ctspct.getDonVi());
        ctsp.setGiaBan(ctspct.getGiaBan());
        ctsp.setGiaNhap(ctspct.getGiaNhap());
        ctsp.setHinhAnh(ctspct.getHinhAnh());
        ctsp.setMau(ctspct.getMau());
        ctsp.setNamBaoHanh(ctspct.getNamBaoHanh());
        ctsp.setSanPham(ctspct.getSanPham());
        ctsp.setSoLuongTon(ctspct.getSoLuongTon());
        ctsp.setTrangThai(ctspct.getTrangThai());
        ctsp.setId(ctspct.getId());
        rp.updateCTSP(ctsp);
    }

    @Override
    public void updateCTPX(Luong_ChiTietPhieuXuatCustom ctpxct) {
        ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
        ctpx.setIdChiTietSp(ctpxct.getIdChiTietSp());
        ctpx.setIdPhieuXuat(ctpxct.getIdPhieuXuat());
        ctpx.setSoLuong(ctpxct.getSoLuong());
        rp.updateCTPX(ctpx);
    }

    @Override
    public List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuat() {
        return rp.getListCTPhieuXuat();
    }

    @Override
    public NhanVien getNhanVienByMa(String ma) {
        return rp.getNhanVienByMa(ma);
    }

}
