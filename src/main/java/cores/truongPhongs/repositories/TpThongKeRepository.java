/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import cores.truongPhongs.customModels.TpThongKeSpCustom;
import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import domainModels.ChiTietPhieuXuat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class TpThongKeRepository {

    public List<TpThongKeSpCustom> getListSanPham() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new cores.truongPhongs.customModels.TpThongKeSpCustom( "
                + "m.idPhieuXuat as idPhieuXuat,"
                + "m.idChiTietSp as idCtsp,"
                + "m.soLuong as soLuong "
                + ") from domainModels.ChiTietPhieuXuat m");
        List<TpThongKeSpCustom> listSP = q.getResultList();
        s.close();
        return listSP;
    }

    public List<Integer> getSoLuongSpTon() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery(" Select SUM(SoLuongTon)\n"
                + "  from ChiTietSanPham");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoLuongSpHoanNhap() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("SELECT sum(Soluong)\n"
                + "     \n"
                + "  FROM [DU_AN_MOT].[dbo].[ChiTietPhieuHoanNhap]");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoLuongSpHoanXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("SELECT sum(Soluong)\n"
                + "     \n"
                + "  FROM [DU_AN_MOT].[dbo].[ChiTietPhieuHoanXuat]");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoDonHoanNhap() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("  select  count(Id) from PhieuHoanNhap");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoDonHoanXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("  select  count(Id) from PhieuHoanXuat");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoSanPhamDaNhap() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("   select sum(Soluong) from ChiTietPhieuNhap");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<Integer> getSoSanPhamDaXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("   select sum(Soluong) from ChiTietPhieuXuat");
        List<Integer> list = query.getResultList();
        return list;
    }

    public List<TpThongKeSpCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("Select new cores.truongPhongs.customModels.TpThongKeSpCustom( "
                + "m.idPhieuXuat as idPhieuXuat,"
                + "m.idChiTietSp as idCtsp,"
                + "m.soLuong as soLuong "
                + ") from domainModels.ChiTietPhieuXuat m WHERE m.idPhieuXuat.ngayThanhToan >= :ngayBatDau AND m.idPhieuXuat.ngayThanhToan <= :ngayKetThuc  ORDER BY m.idPhieuXuat.ngayThanhToan DESC");
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        List<TpThongKeSpCustom> list = query.getResultList();
        return list;
    }

    public List<TpThongKeSpCustom> getListByMaNv(String ma) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select new cores.truongPhongs.customModels.TpThongKeSpCustom( "
                + "m.idPhieuXuat as idPhieuXuat,"
                + "m.idChiTietSp as idCtsp,"
                + "m.soLuong as soLuong "
                + ") from domainModels.ChiTietPhieuXuat m WHERE m.idPhieuXuat.nhanVien.ma like CONCAT ('%',:ma,'%') "
                + "order by m.soLuong DESC");
        query.setParameter("ma", ma);

        List<TpThongKeSpCustom> list = query.getResultList();
        return list;
    }
    public List<TpThongKeSpCustom> getListByMaHd(String ma) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select new cores.truongPhongs.customModels.TpThongKeSpCustom( "
                + "m.idPhieuXuat as idPhieuXuat,"
                + "m.idChiTietSp as idCtsp,"
                + "m.soLuong as soLuong "
                + ") from domainModels.ChiTietPhieuXuat m WHERE m.idPhieuXuat.maPhieu like CONCAT ('%',:ma,'%') "
                + "order by m.soLuong DESC");
        query.setParameter("ma", ma);

        List<TpThongKeSpCustom> list = query.getResultList();
        return list;
    }

    public List<TpThongKeSpCustom> getListByTenNv(String ma) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select new cores.truongPhongs.customModels.TpThongKeSpCustom( "
                + "m.idPhieuXuat as idPhieuXuat,"
                + "m.idChiTietSp as idCtsp,"
                + "m.soLuong as soLuong "
                + ") from domainModels.ChiTietPhieuXuat m WHERE m.idPhieuXuat.nhanVien.ten like CONCAT ('%',:ma,'%') "
                + "order by m.soLuong DESC");
        query.setParameter("ma", ma);

        List<TpThongKeSpCustom> list = query.getResultList();
        return list;
    }
}
