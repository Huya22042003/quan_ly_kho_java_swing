/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.repositories;

import cores.admins.customModels.AdQuanLyLoaiHangCustom;
import domainModels.LoaiHang;
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
public class AdQuanLyLoaiHangRepository {

    public List<AdQuanLyLoaiHangCustom> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.admins.customModels.AdQuanLyLoaiHangCustom("
                + "lh.id as id,"
                + "lh.ma as ma,"
                + "lh.ten as ten,"
                + "lh.moTa as moTa,"
                + "lh.gia as gia"
                + ") FROM domainModels.LoaiHang lh");
        List<AdQuanLyLoaiHangCustom> list = query.getResultList();
        session.close();
        return list;
    }

    public LoaiHang InsertLoaiHangById(LoaiHang lh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lh);
        transaction.commit();
        session.close();
        return lh;
    }

    public boolean UpdateLoaiHangById(LoaiHang lh) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(lh);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean DeleteLoaiHangById(UUID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            LoaiHang lh = session.find(LoaiHang.class, id);
            session.delete(lh);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
