/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlXemThongTinCaNhanCustom;
import domainModels.NhanVien;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvqlXemThongTinCaNhanRepository {

    public List<NvqlXemThongTinCaNhanCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienQuanLy.customModels.NvqlXemThongTinCaNhanCustom("
                + " m.id,"
                + " m.ma as ma,"
                + " m.ten as ten,"
                + " m.sdt as sdt,"
                + " m.email as email,"
                + " m.matKhau as matKhau,"
                + " m.ngaySinh as ngaySinh,"
                + " m.gioiTinh as gioiTinh,"
                + " m.diaChi as diaChi"
                + " )"
                + " from domainModels.NhanVien m where m.id = 'C63B9A29-B6B5-CA47-A92F-38354C216504' ");
//        query.setParameter("id", id);
        List<NvqlXemThongTinCaNhanCustom> list = query.getResultList();
        session.close();
        return list;
    }

    public NvqlXemThongTinCaNhanCustom findByMatKhau(String matKhau) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienQuanLy.customModels.NvqlXemThongTinCaNhanCustom("
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
                + " from domainModels.NhanVien m where m.id = 'C63B9A29-B6B5-CA47-A92F-38354C216504' AND m.matKhau = :matKhau ");
        query.setParameter("matKhau", matKhau);
        NvqlXemThongTinCaNhanCustom kh = null;
        try {
            kh = (NvqlXemThongTinCaNhanCustom) query.getSingleResult();
        } catch (Exception e) {
        }
        session.close();
        if (kh == null) {
            return null;
        }
        return kh;
    }

    public boolean checkMatKhau(String matKhau) {
        NvqlXemThongTinCaNhanCustom ql = findByMatKhau(matKhau);
        if (ql != null) {
            return true;
        }
        return false;
    }

    public void doiMatKhau(NhanVien nv) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
