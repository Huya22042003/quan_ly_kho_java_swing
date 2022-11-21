package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TP_NamBaoHanhCustom;
import domainModels.NamBaoHanh;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

public class TP_NamBaoHanhRepository {

    public List<TP_NamBaoHanhCustom> getList() {
        List<TP_NamBaoHanhCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_NamBaoHanhCustom ("
                + "n.id as id, "
                + "n.ma as ma, "
                + "n.ten as ten"
                + ") FROM domainModels.NamBaoHanh n ");
        list = q.getResultList();
        s.close();
        return list;
    }

    public NamBaoHanh addNBH(NamBaoHanh n) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tran = null;
            tran = s.beginTransaction();
            s.save(n);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return null;
        }
        return n;
    }

    public boolean updateNBH(NamBaoHanh n) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(n);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public boolean deleteNBH(UUID id) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            NamBaoHanh n = s.find(NamBaoHanh.class, id);
            System.out.println(id);
            s.delete(n);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public TP_NamBaoHanhCustom findByMa(String ma) {
        TP_NamBaoHanhCustom n = new TP_NamBaoHanhCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_NamBaoHanhCustom ("
                    + "n.id as id, "
                    + "n.ma as ma, "
                    + "n.ten as ten"
                    + ") FROM domainModels.NamBaoHanh n WHERE n.ma = :ma");
            q.setParameter("ma", ma);
            System.out.println(ma);
            n = (TP_NamBaoHanhCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return n;
    }

    public List<TP_NamBaoHanhCustom> findAllByMa(String ma) {
        List<TP_NamBaoHanhCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_NamBaoHanhCustom ("
                + "n.id as id, "
                + "n.ma as ma, "
                + "n.ten as ten"
                + ") FROM domainModels.NamBaoHanh n WHERE n.ma LIKE CONCAT('%',:ma,'%') ");
        q.setParameter("ma", ma);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TP_NamBaoHanhCustom> findAllByTen(String ten) {
        List<TP_NamBaoHanhCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_NamBaoHanhCustom ("
                + "n.id as id, "
                + "n.ma as ma, "
                + "n.ten as ten"
                + ") FROM domainModels.NamBaoHanh n WHERE n.ten LIKE CONCAT('%',:ten,'%') ");
        q.setParameter("ten", ten);
        list = q.getResultList();
        s.close();
        return list;
    }
}
