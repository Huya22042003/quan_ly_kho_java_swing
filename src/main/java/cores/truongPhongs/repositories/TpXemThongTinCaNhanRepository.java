/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpXemThongTinCaNhanCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class TpXemThongTinCaNhanRepository {

    public List<TpXemThongTinCaNhanCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.truongPhongs.customModels.TpXemThongTinCaNhanCustom("
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
                + " from domainModels.TruongPhong m where m.id = '15A60E6E-D644-E941-B227-020ED133EE00' ");
//        query.setParameter("id", id);
        List<TpXemThongTinCaNhanCustom> list = query.getResultList();
        session.close();
        return list;
    }
    
    public TpXemThongTinCaNhanCustom findByMatKhau(String matKhau) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.truongPhongs.customModels.TpXemThongTinCaNhanCustom("
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
                + " from domainModels.TruongPhong m where m.id = '15A60E6E-D644-E941-B227-020ED133EE00' AND m.matKhau = :matKhau ");
        query.setParameter("matKhau", matKhau);
        TpXemThongTinCaNhanCustom kh = null;
        try {
            kh = (TpXemThongTinCaNhanCustom) query.getSingleResult();
        } catch (Exception e) {
        }
        session.close();
        if(kh == null){
            return null;
        }
        return kh;
    }
    
     public boolean checkMatKhau(String matKhau){
        TpXemThongTinCaNhanCustom ql = findByMatKhau(matKhau);
        if(ql != null){
            return true;
        }
        return false;
    }


    public void doiMatKhau(String matKhau) {
        Transaction transaction = null;
        String hql = "UPDATE TruongPhong m SET MatKhau = :matKhau where m.id = '15A60E6E-D644-E941-B227-020ED133EE00'";
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
