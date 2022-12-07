package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamRepository {

    public List<TpQuanLyChiTietSanPhamCustom> getAll(UUID idSp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createNativeQuery("""
                SELECT 
                ctsp.Id,
                ctsp.SoLuongTon,
                ctsp.HinhAnh,
                ctsp.GiaNhap,
                ctsp.GiaBan,
                ctsp.Mau,
                dv.DonViQuyDoi,
                ctsp.namBaoHanh,
                ctsp.TrangThai,
                ctsp.Size,
                ncc.Ten,
                ctpn.MaSanPhamNhaCungCap
                FROM ChiTietSanPham ctsp
                join DonVi dv on ctsp.IdDonVi = dv.Id
                join ChiTietPhieuNhap ctpn on ctpn.IdChiTietSP = ctsp.Id
                join PhieuNhap pn on ctpn.IdPhieuNhap = pn.Id
                join NhaCungCap ncc on ncc.Id = pn.IdNhaCungCap
                WHERE ctsp.IdSanPham = :idSp
            """);
        query.setParameter("idSp", idSp.toString());
        List<Object[]> listQuery = query.getResultList();
        List<TpQuanLyChiTietSanPhamCustom> list = new ArrayList<>();
        listQuery.parallelStream().forEach(el -> {
            list.add(new TpQuanLyChiTietSanPhamCustom(
                    UUID.fromString((String) el[0]),
                    (int) el[1],
                    (String) el[2],
                    (BigDecimal) el[3],
                    (BigDecimal) el[4],
                    (int) el[5],
                    (String) el[6],
                    (int) el[7],
                    (int) el[8],
                    (int) el[9],
                    (String) el[10],
                    (String) el[11]
            ));
        });
        s.close();
        return list;
    }

    public ChiTietSanPham addCTSanPham(ChiTietSanPham sp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tran = null;
            tran = s.beginTransaction();
            s.save(sp);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return null;
        }
        return sp;
    }

    public boolean updateCTSanPham(ChiTietSanPham sp) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(sp);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public TpQuanLyChiTietSanPhamCustom findById(UUID id) {
        TpQuanLyChiTietSanPhamCustom sp = new TpQuanLyChiTietSanPhamCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                    + "ct.id as id,"
                    + "ct.soLuongTon as soLuongTon,"
                    + "ct.hinhAnh as hinhAnh,"
                    + "ct.GiaNhap as GiaNhap,"
                    + "ct.GiaBan as GiaBan,"
                    + "ct.mau as mau,"
                    + "ct.sanPham as ten,"
                    + "ct.donVi as donViGoc,"
                    + "ct.namBaoHanh as namBaoHanh,"
                    + "ct.trangThai as trangThai, "
                    + "ct.size as size,"
                    + "ct.ngayTao as ngayTao"
                    + ") from domainModels.ChiTietSanPham ct WHERE ct.id = :id");
            q.setParameter("id", id);
            sp = (TpQuanLyChiTietSanPhamCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return sp;
    }

    public TpQuanLyChiTietSanPhamCustom findByGia(BigDecimal gia) {
        TpQuanLyChiTietSanPhamCustom sp = new TpQuanLyChiTietSanPhamCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                    + "ct.id as id,"
                    + "ct.soLuongTon as soLuongTon,"
                    + "ct.hinhAnh as hinhAnh,"
                    + "ct.GiaNhap as GiaNhap,"
                    + "ct.GiaBan as GiaBan,"
                    + "ct.mau as mau,"
                    + "ct.sanPham as ten,"
                    + "ct.donVi as donViGoc,"
                    + "ct.namBaoHanh as namBaoHanh,"
                    + "ct.trangThai as trangThai, "
                    + "ct.size as size,"
                    + "ct.ngayTao as ngayTao"
                    + ") from domainModels.ChiTietSanPham ct WHERE ct.GiaBan = :GiaBan");
            q.setParameter("GiaBan", gia);
            sp = (TpQuanLyChiTietSanPhamCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return sp;
    }

    public List<TpQuanLyChiTietSanPhamCustom> findAllByGiaNhap(String giaNhap, MauConstant tt) {
        List<TpQuanLyChiTietSanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.soLuongTon as soLuongTon,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as GiaNhap,"
                + "ct.GiaBan as GiaBan,"
                + "ct.mau as mau,"
                + "ct.sanPham as ten,"
                + "ct.donVi as donViGoc,"
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.trangThai as trangThai, "
                + "ct.size as size,"
                + "ct.ngayTao as ngayTao"
                + ") from domainModels.ChiTietSanPham ct WHERE ct.GiaNhap LIKE CONCAT('%',:GiaNhap,'%') AND ct.mau = :tt");
        q.setParameter("GiaNhap", giaNhap);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TpQuanLyChiTietSanPhamCustom> findAllByGiaBan(String giaBan, MauConstant tt) {
        List<TpQuanLyChiTietSanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.soLuongTon as soLuongTon,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as GiaNhap,"
                + "ct.GiaBan as GiaBan,"
                + "ct.mau as mau,"
                + "ct.sanPham as ten,"
                + "ct.donVi as donViGoc,"
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.trangThai as trangThai, "
                + "ct.size as size,"
                + "ct.ngayTao as ngayTao"
                + ") from domainModels.ChiTietSanPham ct WHERE ct.GiaBan LIKE CONCAT('%',:GiaBan,'%') AND ct.mau = :tt ");
        q.setParameter("GiaBan", giaBan);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TpQuanLyChiTietSanPhamCustom> findAllByTenSanPham(String ten) {
        List<TpQuanLyChiTietSanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.soLuongTon as soLuongTon,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as GiaNhap,"
                + "ct.GiaBan as GiaBan,"
                + "ct.mau as mau,"
                + "ct.sanPham as ten,"
                + "ct.donVi as donViGoc,"
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.trangThai as trangThai, "
                + "ct.size as size,"
                + "ct.ngayTao as ngayTao"
                + ") from domainModels.ChiTietSanPham ct WHERE ct.sanPham.ten LIKE CONCAT('%',:ten,'%') ");
        q.setParameter("ten", ten);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TpQuanLyDonViCustom> getAllDonVi() {
        List<TpQuanLyDonViCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyDonViCustom ("
                + "dv.id as id,"
                + "dv.donViGoc as donViGoc,"
                + "dv.donViQuyDoi as donViQuyDoi,"
                + "dv.soLuong as soLuong"
                + " )from domainModels.DonVi dv");
        list = q.getResultList();
        s.close();
        return list;

    }
    
    public List<TpQuanLyDonViCustom> getAllDonVi1() {
        List<TpQuanLyDonViCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyDonViCustom ("
                + "dv.id as id,"
                + "dv.donViGoc as donViGoc,"
                + "dv.donViQuyDoi as donViQuyDoi,"
                + "dv.soLuong as soLuong"
                + " )from domainModels.DonVi dv");
        list = q.getResultList();
        s.close();
        return list;

    }

    public DonVi findIDDonVi(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        DonVi sp = s.find(DonVi.class, id);
        t.commit();
        s.close();
        return sp;
    }

    public List<TpQuanLySanPhamCustom> getAllSanPham() {
        List<TpQuanLySanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLySanPhamCustom ("
                + "sp.id as id,"
                + "sp.ma as ma,"
                + "sp.ten as ten"
                + ") from domainModels.SanPham sp");
        list = q.getResultList();
        s.close();
        return list;
    }
    
    public List<TpQuanLySanPhamCustom> getAllSanPham1() {
        List<TpQuanLySanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLySanPhamCustom ("
                + "sp.id as id,"
                + "sp.ma as ma,"
                + "sp.ten as ten"
                + ") from domainModels.SanPham sp");
        list = q.getResultList();
        s.close();
        return list;
    }

    public SanPham findIDSanPham(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        SanPham sp = s.find(SanPham.class, id);
        t.commit();
        s.close();
        return sp;
    }
}
