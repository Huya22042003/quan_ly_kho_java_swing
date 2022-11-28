package cores.truongPhongs.repositories;

import domainModels.ChiTietPhieuNhap;
import domainModels.ChiTietSanPham;
import domainModels.PhieuNhap;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class TpPhieuNhapChiTietRepository {
    public ChiTietPhieuNhap addPhieuNhap(ChiTietPhieuNhap pn){
        Transaction tran = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            tran = s.beginTransaction();
            s.save(pn);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
        return pn;
    }
    public PhieuNhap findPnById(UUID id){
        Session s =HibernateUtil.getSessionFactory().openSession();
        PhieuNhap pn = s.find(PhieuNhap.class, id);
        s.close();
        return pn;
    }
      public ChiTietSanPham findSpById(UUID id){
         
        Session s =HibernateUtil.getSessionFactory().openSession();
        ChiTietSanPham pn = s.find(ChiTietSanPham.class, id);
        s.close();
        return pn;
    }
}
