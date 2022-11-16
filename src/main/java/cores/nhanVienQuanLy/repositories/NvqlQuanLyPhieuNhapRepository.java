/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom;
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
                + "p.ngayNhan as ngayNhan,"
                + "p.ngayTao as ngayTao,"
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
}
