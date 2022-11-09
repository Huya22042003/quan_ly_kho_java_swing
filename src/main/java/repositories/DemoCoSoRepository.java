/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import customModels.DemoCoSoCustom;
import domainModels.CoSo;
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
 * @author QUOC HUY
 */
public class DemoCoSoRepository {

    public List<DemoCoSoCustom> getList() {
        List<DemoCoSoCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new customModels.DemoCoSoCustom ("
                + "cs.id as id, "
                + "cs.ma as ma, "
                + "cs.ten as ten,"
                + "cs.viTri as viTri,"
                + "cs.trangThai as trangThai"
                + ") FROM domainModels.CoSo cs ");
        list = q.getResultList();
        s.close();
        return list;
    }

    public CoSo addCoSo(CoSo cs) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tran = null;
            tran = s.beginTransaction();
            s.save(cs);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return null;
        }
        return cs;
    }

    public boolean updateCoSo(CoSo cs) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(cs);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public boolean deleteCoSo(UUID id) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            CoSo cs = s.find(CoSo.class, id);
            s.delete(cs);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public DemoCoSoCustom findByMa(String ma) {
        DemoCoSoCustom csc = new DemoCoSoCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("SELECT new customModels.DemoCoSoCustom ("
                    + "cs.id as id, "
                    + "cs.ma as ma, "
                    + "cs.ten as ten,"
                    + "cs.viTri as viTri,"
                    + "cs.trangThai as trangThai"
                    + ") FROM domainModels.CoSo cs WHERE cs.ma = :ma");
            q.setParameter("ma", ma);
            csc = (DemoCoSoCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return csc;
    }

}
