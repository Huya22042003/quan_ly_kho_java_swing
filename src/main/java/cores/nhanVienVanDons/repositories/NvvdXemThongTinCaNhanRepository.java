/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienVanDons.repositories;

import cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvvdXemThongTinCaNhanRepository {

    public List<NvvdXemThongTinCaNhanCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom("
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
                + " from domainModels.NhanVienVanDon m where m.id = '14F90D40-CC91-1342-8935-351794FD7DE9' ");
//        query.setParameter("id", id);
        List<NvvdXemThongTinCaNhanCustom> list = query.getResultList();
        session.close();
        return list;
    }
    
    public NvvdXemThongTinCaNhanCustom findByMatKhau(String matKhau) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom("
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
                + " from domainModels.NhanVienVanDon m where m.id = '14F90D40-CC91-1342-8935-351794FD7DE9' AND m.matKhau = :matKhau ");
        query.setParameter("matKhau", matKhau);
        NvvdXemThongTinCaNhanCustom kh = null;
        try {
            kh = (NvvdXemThongTinCaNhanCustom) query.getSingleResult();
        } catch (Exception e) {
        }
        session.close();
        if(kh == null){
            return null;
        }
        return kh;
    }
    
     public boolean checkMatKhau(String matKhau){
        NvvdXemThongTinCaNhanCustom ql = findByMatKhau(matKhau);
        if(ql != null){
            return true;
        }
        return false;
    }


    public void doiMatKhau(String matKhau) {
        Transaction transaction = null;
        String hql = "UPDATE NhanVienVanDon m SET MatKhau = :matKhau where m.id = '14F90D40-CC91-1342-8935-351794FD7DE9'";
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
