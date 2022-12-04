package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
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

    TpQuanLyChiTietSanPhamCustom findCTSanPhamById(UUID id);

    TpQuanLyChiTietSanPhamCustom findCTSanPhamGia(BigDecimal gia);

    List<TpQuanLyChiTietSanPhamCustom> findAllByRadio(int rdo, MauConstant tt, String tk);

    TpQuanLyChiTietSanPhamCustom checkValidate(UUID donVi, String namBH, UUID sanPham, String hinhAnh, String giaNhap, String giaBan, String soLuong, String size,
                                               int trangThai, JLabel erroHinhAnh, JLabel erroGiaNhap, JLabel erroGiaBan, JLabel erroSoLuong, JLabel erroSize, JLabel erroNamBH, MauConstant mau);

    public List<TpQuanLyDonViCustom> getAllDonVi();

    public DonVi findIDDonVi(UUID id);

    public List<TpQuanLySanPhamCustom> getAllSanPham();

    public SanPham findIDSanPham(UUID id);

    MauConstant loc(int a);

    void loadCombobox(Combobox cbb);

    TpXemChiTietSanPhamCustom checkValidate1(UUID donVi, String namBH, UUID sanPham, String hinhAnh, String giaNhap, String soLuong, String size,
              MauConstant mau, Long ngayTao, String trangThai, JLabel erroSoLuongNhap, JLabel erroGiaNhap, JLabel erroSize, JLabel erroNamBH);

    public List<TpQuanLyDonViCustom> getAllDonVi1();

    public List<TpQuanLySanPhamCustom> getAllSanPham1();

    List<TpQuanLyChiTietSanPhamCustom> phanTrang(List<TpQuanLyChiTietSanPhamCustom> list, int offset, int limit);

    public TrangThaiSanPhamConstanst tt(int item);
}
