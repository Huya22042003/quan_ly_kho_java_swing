/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpNhanVienCustom;
import domainModels.NhanVien;
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
 * @author LENOVO
 */
public class TpQuanLyNhanVienRepository {

    public List<TpNhanVienCustom> getList() {
        List<TpNhanVienCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery(" SELECT new customModels.NhanVienCustom ("
                + " nv.id as id, "
                + " nv.ma as ma, "
                + " nv.ten as ten, "
                + " nv.sdt as sdt, "
                + " nv.email as email, "
                + " nv.matKhau as matKhau, "
                + " nv.ngaySinh as ngaySinh, "
                + " nv.hinhAnh as hinhAnh, "
                + " nv.gioiTinh as gioiTinh, "
                + " nv.diaChi as diaChi, "
                + " nv.trangThai as trangThai, "
                + " nv.idChucVu as idChucVu "
                + " ) FROM domainModels.NhanVien nv"
        );
        list = q.getResultList();
        s.close();
        return list;
    }
public NhanVien addNhanVien( NhanVien nv){
    Session s = HibernateUtil.getSessionFactory().openSession();
    try {
        Transaction tran = null;
        tran = s.beginTransaction();
        s.save(nv);
        tran.commit();
        s.close();
    } catch (Exception e) {
        e.printStackTrace();
        s.close();
        return null;
    }
    return nv;
}
public boolean updateNhanVien(NhanVien nv){
        Transaction tran = null;
    try (Session s = HibernateUtil.getSessionFactory().openSession()){
       
        tran = s.beginTransaction();
        s.update(nv);
        tran.commit();
        
    } catch (Exception e) {
        e.printStackTrace();
        tran.rollback();
      return false;
    }
    return true;
}
 public boolean deleteNhanVien(UUID id){
            Transaction tran = null;
    try (Session s = HibernateUtil.getSessionFactory().openSession()){
       
        tran = s.beginTransaction();
       NhanVien nv = s.find(NhanVien.class, id);
       s.delete(nv);
        tran.commit();
        
    } catch (Exception e) {
        e.printStackTrace();
        tran.rollback();
      return false;
    }
    return true;
 }
 
 public TpNhanVienCustom findByMa(String ma){
     TpNhanVienCustom nvc = new TpNhanVienCustom();
     try (Session s = HibernateUtil.getSessionFactory().openSession()) {
             Query q = s.createQuery(" SELECT new customModels.NhanVienCustom ("
                + " nv.id as id, "
                + " nv.ma as ma, "
                + " nv.ten as ten, "
                + " nv.sdt as sdt, "
                + " nv.email as email, "
                + " nv.matKhau as matKhau, "
                + " nv.ngaySinh as ngaySinh, "
                + " nv.hinhAnh as hinhAnh, "
                + " nv.gioiTinh as gioiTinh, "
                + " nv.diaChi as diaChi, "
                + " nv.trangThai as trangThai, "
                + " nv.idChucVu as idChucVu "
                + " ) FROM domainModels.NhanVien nv WHERE nc.ma = :ma"
        );
             q.setParameter("ma", ma);
             nvc = (TpNhanVienCustom) q.getResultList();
     } catch (NoResultException e) {
         e.printStackTrace();
         return null;
     }
     return nvc;
 }
}
