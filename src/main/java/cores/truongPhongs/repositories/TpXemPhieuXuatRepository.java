package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpXemPhieuXuatCustom;
import cores.truongPhongs.customModels.TpXemSanPham_PhieuXuat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class TpXemPhieuXuatRepository {

    public List<TpXemPhieuXuatCustom> getListPhieuXuat(String maPhieu,
            String tenKh, String maKh, String diaChiKh, String emailKh, String sdtKh,
            String maSp, String tenSp,
            String maPn,
            String tenNcc, String maNcc, String diaChiNcc, String emailNcc, String sdtNcc
    ) {
        List<TpXemPhieuXuatCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createNativeQuery("""
                                            SELECT 
                                            px.Id,
                                            px.GhiChu,
                                            px.MaPhieu,
                                            px.NgayTao,
                                            px.NgayThanhToan,
                                            px.TrangThai,
                                            kh.Ma,
                                            kh.Ten,
                                            kh.Sdt,
                                            kh.Email,
                                            kh.MatKhau,
                                            kh.NgaySinh,
                                            kh.HinhAnh,
                                            kh.GioiTinh,
                                            kh.DiaChi,
                                            kh.DanhGia
                                            FROM PhieuXuat px 
                                            JOIN KhachHang kh ON px.IdKhachHang = kh.Id
                                            JOIN ChiTietPhieuXuat ctpx ON ctpx.IdPhieuXuat = px.Id
                                            JOIN ChiTietSanPham ctsp ON ctsp.Id = ctpx.IdChiTietSP
                                            JOIN SanPham sp ON sp.Id = ctsp.IdSanPham
                                            JOIN ChiTietPhieuNhap ctpn ON ctpn.IdChiTietSp = ctsp.Id
                                            JOIN PhieuNhap pn ON pn.Id = ctpn.IdPhieuNhap
                                            JOIN NhaCungCap ncc ON ncc.Id = pn.IdNhaCungCap
                                      WHERE px.MaPhieu LIKE CONCAT('%',:maPhieuXuat,'%')
                                       AND kh.Ma LIKE CONCAT('%',:maKh,'%')
                                      AND kh.Ten LIKE CONCAT('%',:tenKh,'%')
                                      AND kh.DiaChi LIKE CONCAT('%',:diaChiKh,'%')
                                      AND kh.Email LIKE CONCAT('%',:emailKh,'%')
                                      AND kh.Sdt LIKE CONCAT('%',:sdtKh,'%')
                                      AND sp.Ten LIKE CONCAT('%',:tenSp,'%')
                                      AND sp.Ma LIKE CONCAT('%',:maSp,'%')
                                      AND pn.MaPhieu LIKE CONCAT('%',:maPhieuNhap,'%')
                                      AND ncc.Ma LIKE CONCAT('%',:maNcc,'%')
                                      AND ncc.Ten LIKE CONCAT('%',:tenNcc,'%')
                                      AND ncc.DiaChi LIKE CONCAT('%',:diaChiNcc,'%')
                                      AND ncc.Email LIKE CONCAT('%',:emailNcc,'%')
                                      AND ncc.Sdt LIKE CONCAT('%',:sdtNcc,'%')
                                      """)
                .setParameter("maPhieuXuat", maPhieu)
                .setParameter("maKh", maKh)
                .setParameter("tenKh", tenKh)
                .setParameter("diaChiKh", diaChiKh)
                .setParameter("emailKh", emailKh)
                .setParameter("sdtKh", sdtKh)
                .setParameter("tenSp", tenSp)
                .setParameter("maSp", maSp)
                .setParameter("maPhieuNhap", maPn)
                .setParameter("maNcc", maNcc)
                .setParameter("tenNcc", tenNcc)
                .setParameter("diaChiNcc", diaChiNcc)
                .setParameter("emailNcc", emailNcc)
                .setParameter("sdtNcc", sdtNcc);

        List<Object[]> listQuery = q.getResultList();
        listQuery.stream().forEach(el -> {
            list.add(new TpXemPhieuXuatCustom(UUID.fromString((String) el[0]), (String) el[1], (String) el[2], Long.valueOf(String.valueOf((BigDecimal) el[3])), Long.valueOf(String.valueOf((BigDecimal) el[4])), (int) el[5],
                    (String) el[6], (String) el[7], (String) el[8], (String) el[9], (String) el[10], Long.valueOf(String.valueOf((BigDecimal) el[11])), (String) el[12], (int) el[13], (String) el[14], (int) el[15]
            ));
        });
        return list;
    }

    public List<TpXemSanPham_PhieuXuat> getListSanPhamByPhieuXuat(String tenSp, String maSp, UUID idPhieuXuat) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = s.createNativeQuery("""
                                                  SELECT 
                                                  sp.Id,
                                                  sp.Ma as maSp,
                                                  sp.Ten as tenSp,
                                                  ctpx.SoLuong,
                                                  ctsp.HinhAnh,
                                                  ctsp.GiaNhap,
                                                  ctsp.GiaBan,
                                                  ctsp.Mau,
                                                  ctsp.namBaoHanh,
                                                  ctsp.Size,
                                                  ctsp.createDate,
                                                  pn.MaPhieu,
                                                  pn.NgayTao,
                                                  pn.GhiChu,
                                                  pn.NgayThanhToan,
                                                  ncc.Ma as maNcc,
                                                  ncc.Ten as tenNcc,
                                                  ncc.DiaChi,
                                                  ncc.Email,
                                                  ncc.Sdt,
                                                  ctpn.MaSanPhamNhaCungCap
                                                  FROM SanPham sp join ChiTietSanPham ctsp ON sp.Id = ctsp.IdSanPham
                                                          join ChiTietPhieuXuat ctpx on ctpx.idChiTietSp = ctsp.id
                                                  		join ChiTietPhieuNhap ctpn on ctpn.IdChiTietSp = ctsp.id
                                                  		join PhieuNhap pn on pn.Id = ctpn.IdPhieuNhap
                                                  		join NhaCungCap ncc on ncc.Id = pn.IdNhaCungCap
                                                            WHERE ctpx.idPhieuXuat = :idPhieuXuat
                                                  """).setParameter("idPhieuXuat", idPhieuXuat.toString());
        List<Object[]> listQuery = query.getResultList();
        List<TpXemSanPham_PhieuXuat> list = new ArrayList<>();
        listQuery.stream().forEach(el -> {
            list.add(new TpXemSanPham_PhieuXuat(UUID.fromString((String) el[0]), (String) el[1], (String) el[2],
                    (int) el[3],
                    (String) el[4], (BigDecimal) el[5], (BigDecimal) el[6], (int) el[7], (int) el[8], (int) el[9],
                    Long.valueOf(String.valueOf((BigDecimal) el[10])), (String) el[11], Long.valueOf(String.valueOf((BigDecimal) el[12])), (String) el[13], Long.valueOf(String.valueOf((BigDecimal) el[14])),
                    (String) el[15], (String) el[16], (String) el[17], (String) el[18], (String) el[19], (String) el[20]
            ));
        });
        return list;
    }
}
