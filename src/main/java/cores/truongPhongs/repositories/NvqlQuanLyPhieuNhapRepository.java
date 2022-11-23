/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.NvqlQuanLyPhieuNhapCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;
import domainModels.PhieuNhap;
import java.util.UUID;
import org.hibernate.Transaction;
/**
 *
 * @author Acer
 */
public class NvqlQuanLyPhieuNhapRepository {
    public List<NvqlQuanLyPhieuNhapCustom> getListPhieuNhap(){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new  cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom ( "
                + "p.id as id,"
                + "p.ghiChu as ghiChu,"
                + "p.ngayThanhToan as ngayThanhToan,"
                + "p.ngayTao as ngayTao,"
                + "p.trangThai as trangThai,"
                + "p.nhanVien.id as idNhanVien,"
                + "p.nhanVien.ten as tenNhanVien,"
                + "p.nhaCungCap.id as idNcc,"
                + "p.nhaCungCap.ten as tenNcc) "
                + "from domainModels.PhieuNhap p");
        List<NvqlQuanLyPhieuNhapCustom> listPn = q.getResultList();
        s.close();
        return listPn;
    }
    public PhieuNhap addPn(PhieuNhap p){
        Transaction tran = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            tran = s.beginTransaction();
            s.save(p);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
        return p;
    }
    public boolean updatePn(PhieuNhap p){
        Transaction tran = null;
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(p);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    public boolean deletePn(UUID id){
        Transaction tran = null;
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            PhieuNhap p = s.find(PhieuNhap.class, id);
            s.delete(p);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    public PhieuNhap findPhieuNhapById(UUID id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        PhieuNhap p = s.find(PhieuNhap.class, id);
        s.close();
        return p;
    }
      public List<NvqlQuanLyPhieuNhapCustom> getListByNgayTao(Long ngayBatDau, Long ngayKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select new  cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom ( "
                + "p.id as id,"
                + "p.ghiChu as ghiChu,"
                + "p.ngayThanhToan as ngayThanhToan,"
                + "p.ngayTao as ngayTao,"
                + "p.trangThai as trangThai,"
                + "p.nhanVien.id as idNhanVien,"
                + "p.nhanVien.ten as tenNhanVien,"
                + "p.nhaCungCap.id as idNcc,"
                + "p.nhaCungCap.ten as tenNcc) "
                + "from domainModels.PhieuNhap p WHERE p.ngayThanhToan > :ngayBatDau AND p.ngayThanhToan < :ngayKetThuc");
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        List<NvqlQuanLyPhieuNhapCustom> list = query.getResultList();
        return list;
    }
    
        public List<NvqlQuanLyPhieuNhapCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select new  cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom ( "
                + "p.id as id,"
                + "p.ghiChu as ghiChu,"
                + "p.ngayThanhToan as ngayThanhToan,"
                + "p.ngayTao as ngayTao,"
                + "p.trangThai as trangThai,"
                + "p.nhanVien.id as idNhanVien,"
                + "p.nhanVien.ten as tenNhanVien,"
                + "p.nhaCungCap.id as idNcc,"
                + "p.nhaCungCap.ten as tenNcc) "
                + "from domainModels.PhieuNhap p WHERE p.ngayThanhToan > :ngayBatDau AND p.ngayThanhToan < :ngayKetThuc");
        query.setParameter("ngayBatDau", ngayBatDau);
        query.setParameter("ngayKetThuc", ngayKetThuc);
        List<NvqlQuanLyPhieuNhapCustom> list = query.getResultList();
        return list;
    }
}
