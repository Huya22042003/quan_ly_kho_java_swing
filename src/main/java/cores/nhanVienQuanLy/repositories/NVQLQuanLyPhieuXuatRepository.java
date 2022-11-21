/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import domainModels.KhachHang;
import domainModels.NhanVien;
import domainModels.PhieuXuat;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.DateTimeUtil;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class NVQLQuanLyPhieuXuatRepository {

    public List<PhieuXuatCustom> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.PhieuXuatCustom("
                + "px.id as id,"
                + "px.ngayTao as ngayTao,"
                + "px.ghiChu as ghiChu,"
                + "px.ngayThanhToan as ngayThanhToan,"
                + "px.trangThai as trangThai,"
                + "px.nhanVien as nhanVien,"
                + "px.khachHang as khachHang"
                + ") FROM domainModels.PhieuXuat px");
        List<PhieuXuatCustom> list = query.getResultList();
        return list;
    }

    public List<PhieuXuatCustom> getListByNgayTao(Long ngayBatDau, Long ngayKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.PhieuXuatCustom("
                + "px.id as id,"
                + "px.ngayTao as ngayTao,"
                + "px.ghiChu as ghiChu,"
                + "px.ngayThanhToan as ngayThanhToan,"
                + "px.trangThai as trangThai,"
                + "px.nhanVien as nhanVien,"
                + "px.khachHang as khachHang"
                + ") FROM domainModels.PhieuXuat px WHERE px.ngayTao > :ngayBatDau AND px.ngayTao < :ngayKetThuc");
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        List<PhieuXuatCustom> list = query.getResultList();
        return list;
    }
    
        public List<PhieuXuatCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.PhieuXuatCustom("
                + "px.id as id,"
                + "px.ngayTao as ngayTao,"
                + "px.ghiChu as ghiChu,"
                + "px.ngayThanhToan as ngayThanhToan,"
                + "px.trangThai as trangThai,"
                + "px.nhanVien as nhanVien,"
                + "px.khachHang as khachHang"
                + ") FROM domainModels.PhieuXuat px WHERE px.ngayThanhToan > :ngayBatDau AND px.ngayThanhToan < :ngayKetThuc");
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        List<PhieuXuatCustom> list = query.getResultList();
        return list;
    }
    
    public PhieuXuat addPhieuXuat(PhieuXuat px) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.save(px);;
            transaction.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
        return px;
    }

    public boolean updatePhieuXuat(PhieuXuat px) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.update(px);
            transaction.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return false;
        }
        return true;
    }

    public boolean deletePhieuXuat(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            PhieuXuat px = s.find(PhieuXuat.class, id);
            s.delete(px);
            transaction.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return false;
        }
        return true;
    }

    public PhieuXuatCustom findById(UUID id) {
        PhieuXuatCustom pxcs = new PhieuXuatCustom();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.PhieuXuatCustom("
                    + "px.id as id,"
                    + "px.ngayTao as ngayTao,"
                    + "px.ghiChu as ghiChu,"
                    + "px.ngayThanhToan as ngayThanhToan,"
                    + "px.trangThai as trangThai,"
                    + "px.nhanVien as nhanVien,"
                    + "px.khachHang as khachHang"
                    + ") FROM domainModels.PhieuXuat px WHERE px.id =:id");
            query.setParameter("id", id);
            pxcs = (PhieuXuatCustom) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return pxcs;
    }

    public List<NhanVien> getListMaNhanVien() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.NhanVien nv");
        List<NhanVien> listNV = query.getResultList();
        return listNV;
    }

    public List<KhachHang> getListMaKhachHang() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.KhachHang kh");
        List<KhachHang> listKh = query.getResultList();
        return listKh;
    }
}
