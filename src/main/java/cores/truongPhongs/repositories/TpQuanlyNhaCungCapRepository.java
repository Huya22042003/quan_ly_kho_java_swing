/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.NhaCungCapCustom;
import domainModels.NhaCungCap;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class TpQuanlyNhaCungCapRepository {

    public List<NhaCungCapCustom> getListByMa(String ma) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.truongPhongs.customModels.NhaCungCapCustom("
                + "ncc.id as id,"
                + "ncc.ma as ma,"
                + "ncc.ten as ten,"
                + "ncc.diaChi as diaChi,"
                + "ncc.email as email,"
                + "ncc.sdt as sdt,"
                + "ncc.danhGia as danhGia,"
                + "ncc.trangThai as trangThai"
                + ") FROM domainModels.NhaCungCap ncc WHERE ncc.ma like CONCAT ('%',:ma,'%')");
        query.setParameter("ma", ma);
        List<NhaCungCapCustom> list = query.getResultList();
        return list;
    }

    public List<NhaCungCapCustom> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.truongPhongs.customModels.NhaCungCapCustom("
                + "ncc.id as id,"
                + "ncc.ma as ma,"
                + "ncc.ten as ten,"
                + "ncc.diaChi as diaChi,"
                + "ncc.email as email,"
                + "ncc.sdt as sdt,"
                + "ncc.danhGia as danhGia,"
                + "ncc.trangThai as trangThai"
                + ") FROM domainModels.NhaCungCap ncc");
        List<NhaCungCapCustom> list = query.getResultList();
        return list;
    }

    public NhaCungCap addNhaCungCap(NhaCungCap ncc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ncc);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
        session.close();
        return ncc;
    }

    public boolean updateNhaCungCap(NhaCungCap ncc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.update(ncc);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return false;
        }
        return true;
    }

    public boolean deleteNhaCungCap(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            NhaCungCap ncc = session.find(NhaCungCap.class, id);
            session.delete(ncc);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return false;
        }
        return true;
    }

    public NhaCungCapCustom findByNCC(String ma) {
        NhaCungCapCustom nccs = new NhaCungCapCustom();
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query query = s.createQuery("SELECT new cores.truongPhongs.customModels.NhaCungCapCustom("
                    + "ncc.id as id,"
                    + "ncc.ma as ma,"
                    + "ncc.ten as ten,"
                    + "ncc.diaChi as diaChi,"
                    + "ncc.email as email,"
                    + "ncc.sdt as sdt,"
                    + "ncc.danhGia as danhGia,"
                    + "ncc.trangThai as trangThai"
                    + ") FROM domainModels.NhaCungCap ncc WHERE ncc.ma =:ma");
            query.setParameter("ma", ma);
            nccs = (NhaCungCapCustom) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return nccs;
    }

}
