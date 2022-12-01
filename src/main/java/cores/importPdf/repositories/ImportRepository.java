package cores.importPdf.repositories;

import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import domainModels.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class ImportRepository {

    public List<DonVi> findDonViByDonViQuyDoi() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM domainModels.DonVi dv");
        List<DonVi> dv = new ArrayList<>();
        try {
            dv = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        s.close();
        return dv;
    }

    public List<SanPham> findSanPhamByTenSanPham() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM domainModels.SanPham sp");
        List<SanPham> sp = new ArrayList<>();
        try {
            sp = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        s.close();
        return sp;
    }

    public boolean insertDonVi(DonVi dv) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = s.beginTransaction();
            s.save(dv);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertSanPham(SanPham sp) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = s.beginTransaction();
            s.save(sp);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertChiTietSanPham(ChiTietSanPham sp) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = s.beginTransaction();
            s.saveOrUpdate(sp.getSanPham());
            s.saveOrUpdate(sp.getDonVi());
            s.save(sp);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
