package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class TpXemChiTietSanPhamRepository {

    public List<TpXemChiTietSanPhamCustom> getAll() {
        List<TpXemChiTietSanPhamCustom> ct = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as giaNhap,"
                + "ct.GiaBan as giaBan,"
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.mau as mau,"
                + "ct.sanPham as sanPham,"
                + "ct.donVi as donVi,"
                + "ct.trangThai as trangThai,"
                + "ct.soLuongTon as soLuongTon"
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

    public DonVi findByTen(String donViGoc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpDonViCustom ("
                + "ct.id as id,"
                + "ct.donViGoc as donViGoc,"
                + "ct.donViQuyDoi as donViQuyDoi,"
                + "ct.soLuong as soLuong "
                + ") from domainModels.DonVi ct where ct.donViGoc like CONCAT ('%',:donViGoc,'%')");
        q.setParameter("donViGoc", donViGoc);
        DonVi d = (DonVi) q.getResultList();
        return d;
    }
     public List<TpXemChiTietSanPhamCustom> getListByGiaNhap(BigDecimal giaBatDau, BigDecimal giaKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select new cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as giaNhap,"
                + "ct.GiaBan as giaBan,"
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.mau as mau,"
                + "ct.sanPham as sanPham,"
                + "ct.donVi as donVi,"
                + "ct.trangThai as trangThai,"
                + "ct.soLuongTon as soLuongTon"
                + ") from domainModels.ChiTietSanPham ct WHERE ct.GiaNhap > :giaBatDau AND ct.GiaNhap < :giaKetThuc  ORDER BY ct.GiaNhap DESC");
        query.setParameter("giaBatDau", giaBatDau);
        query.setParameter("giaKetThuc", giaKetThuc);
        List<TpXemChiTietSanPhamCustom> list = query.getResultList();
        return list;
    }
}
