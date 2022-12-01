package cores.qrCode.repositories;

import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import domainModels.SanPham;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class importRepository {

    public DonVi findDonViByDonViQuyDoi(String donViQuyDoi) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM domainModels.DonVi dv WHERE dv.donViQuyDoi = :doViQuyDoi");
        q.setParameter("doViQuyDoi", donViQuyDoi);
        DonVi dv = null;
        try {
            dv = (DonVi) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        s.close();
        return dv;
    }

    public SanPham findSanPhamByTenSanPham(String tenSp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM domainModels.SanPham sp WHERE sp.ten = :tenSp");
        q.setParameter("tenSp", tenSp);
        SanPham dv = null;
        try {
            dv = (SanPham) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        s.close();
        return dv;
    }
    
    public boolean insertDonVi(DonVi dv) {
        Transaction tran = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.save(dv);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    
    public boolean insertSanPham(SanPham sp) {
        Transaction tran = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.save(sp);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    
     public boolean insertChiTietSanPham(ChiTietSanPham sp) {
        Transaction tran = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.save(sp);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    
}
