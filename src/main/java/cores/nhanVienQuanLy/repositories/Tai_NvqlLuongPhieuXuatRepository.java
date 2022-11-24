/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.KhachHang;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class Tai_NvqlLuongPhieuXuatRepository {

    public List<ChiTietSanPham> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.ChiTietSanPham ctsp WHERE ctsp.GiaBan > :giaBatDau AND ctsp.GiaBan < :giaKetThuc");
        query.setParameter("giaBatDau", giaBatDau);
        query.setParameter("giaKetThuc", giaKetThuc);
        List<ChiTietSanPham> listCTSP = query.getResultList();
        return listCTSP;
    }

    public List<ChiTietSanPham> getListCTSanPham() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.ChiTietSanPham ctsp WHERE ctsp.trangThai = :trangThai");
        query.setParameter("trangThai", TrangThaiSanPhamConstanst.DA_MO_BAN);
        List<ChiTietSanPham> listCTSP = query.getResultList();
        return listCTSP;
    }

    public KhachHang getKhachHangByMa(String ma) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.KhachHang kh WHERE kh.ma =:ma");
        query.setParameter("ma", ma);
        KhachHang kh = (KhachHang) query.getSingleResult();
        return kh;
    }

    public NhanVien getNhanVienByMa(String ma) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.NhanVien kh WHERE kh.ma =:ma");
        query.setParameter("ma", ma);
        NhanVien nv = (NhanVien) query.getSingleResult();
        return nv;
    }

    public List<ChiTietPhieuXuat> getListCTPhieuXuat(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM domainModels.ChiTietPhieuXuat ctpx WHERE ctpx.idPhieuXuat.id =:id");
        query.setParameter("id", id);
        List<ChiTietPhieuXuat> list = query.getResultList();
        return list;
    }

    public ChiTietPhieuXuat addCTPX(ChiTietPhieuXuat ctpx) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.save(ctpx);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
        return ctpx;
    }

    public void updateCTPX(ChiTietPhieuXuat ctpx) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.update(ctpx);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }


//    public ChiTietSanPham addCTSP(ChiTietSanPham ctsp) {
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Transaction trans = s.beginTransaction();
//            s.save(ctsp);
//            trans.commit();
//            s.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            s.close();
//        }
//        return ctsp;
//    }
    public void updateCTSP(ChiTietSanPham ctsp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.update(ctsp);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }

}
