/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienGiaoHangs.repositories;

import cores.khachHangs.customModels.NvghXemThongTinCaNhanCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvghXemThongTinCaNhanRepository {

    public List<NvghXemThongTinCaNhanCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.khachHangs.customModels.NvghXemThongTinCaNhanCustom("
                + " m.id,"
                + " m.ma as ma,"
                + " m.ten as ten,"
                + " m.email as email,"
                + " m.sdt as sdt,"
                + " m.matKhau as matKhau,"
                + " m.ngaySinh as ngaySinh,"
                + " m.gioiTinh as gioiTinh,"
                + " m.diaChi as diaChi"
                + " )"
                + " from domainModels.NhanVienGiaoHang m where m.id = 'C63B9A29-B6B5-CA47-A92F-38354C216504' ");
//        query.setParameter("id", id);
        List<NvghXemThongTinCaNhanCustom> list = query.getResultList();
        session.close();
        return list;
    }
    
    public NvghXemThongTinCaNhanCustom findByMatKhau(String matKhau) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.khachHangs.customModels.NvghXemThongTinCaNhanCustom("
                + " m.id,"
                + " m.ma as ma,"
                + " m.ten as ten,"
                + " m.email as email,"
                + " m.sdt as sdt,"
                + " m.matKhau as matKhau,"
                + " m.ngaySinh as ngaySinh,"
                + " m.gioiTinh as gioiTinh,"
                + " m.diaChi as diaChi"
                + " )"
                + " from domainModels.NhanVienGiaoHang m where m.id = 'C63B9A29-B6B5-CA47-A92F-38354C216504' AND m.matKhau = :matKhau ");
        query.setParameter("matKhau", matKhau);
        NvghXemThongTinCaNhanCustom kh = null;
        try {
            kh = (NvghXemThongTinCaNhanCustom) query.getSingleResult();
        } catch (Exception e) {
        }
        session.close();
        if(kh == null){
            return null;
        }
        return kh;
    }
    
     public boolean checkMatKhau(String matKhau){
        NvghXemThongTinCaNhanCustom ql = findByMatKhau(matKhau);
        if(ql != null){
            return true;
        }
        return false;
    }


    public void doiMatKhau(String matKhau) {
        Transaction transaction = null;
        String hql = "UPDATE NhanVienGiaoHang m SET MatKhau = :matKhau where m.id = 'C63B9A29-B6B5-CA47-A92F-38354C216504'";
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            transaction = session.beginTransaction();
            query.setParameter("matKhau", matKhau);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
