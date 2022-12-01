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

    public List<TpQuanLyChiTietSanPhamCustom> getAll() {
        List<TpQuanLyChiTietSanPhamCustom> ct = new ArrayList<>();
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
                + ") from domainModels.ChiTietSanPham ct");
        ct = q.getResultList();
        s.close();
        return ct;
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

    public boolean deleteCTSanPham(UUID id) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            ChiTietSanPham cs = s.find(ChiTietSanPham.class, id);
            s.delete(cs);
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

    public SanPham findIDSanPham(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        SanPham sp = s.find(SanPham.class, id);
        t.commit();
        s.close();
        return sp;
    }
}
