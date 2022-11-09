package repositories;

import customModels.DemoCoSoCustom;
import domainModels.CoSo;
import infrastructures.constant.CoSoConstant;
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
    
    // cách tìm kiếm thứ 2
    public List<DemoCoSoCustom> findAllByMa(String ma, CoSoConstant tt) {
        List<DemoCoSoCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new customModels.DemoCoSoCustom ("
                + "cs.id as id, "
                + "cs.ma as ma, "
                + "cs.ten as ten,"
                + "cs.viTri as viTri,"
                + "cs.trangThai as trangThai"
                + ") FROM domainModels.CoSo cs WHERE cs.ma LIKE CONCAT('%',:ma,'%') AND cs.trangThai = :tt");
        q.setParameter("ma", ma);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }
    
    public List<DemoCoSoCustom> findAllByTen(String ten, CoSoConstant tt) {
        List<DemoCoSoCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new customModels.DemoCoSoCustom ("
                + "cs.id as id, "
                + "cs.ma as ma, "
                + "cs.ten as ten,"
                + "cs.viTri as viTri,"
                + "cs.trangThai as trangThai"
                + ") FROM domainModels.CoSo cs WHERE cs.ten LIKE CONCAT('%',:ten,'%') AND cs.trangThai = :tt");
        q.setParameter("ten", ten);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }
    
    public List<DemoCoSoCustom> findAllByViTri(String vt, CoSoConstant tt) {
        List<DemoCoSoCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new customModels.DemoCoSoCustom ("
                + "cs.id as id, "
                + "cs.ma as ma, "
                + "cs.ten as ten,"
                + "cs.viTri as viTri,"
                + "cs.trangThai as trangThai"
                + ") FROM domainModels.CoSo cs WHERE cs.viTri LIKE CONCAT('%',:vt,'%') AND cs.trangThai = :tt");
        q.setParameter("vt", vt);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }

}
