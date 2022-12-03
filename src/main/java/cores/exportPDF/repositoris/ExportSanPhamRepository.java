package cores.exportPDF.repositoris;

import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class ExportSanPhamRepository {
    public ChiTietSanPham findChiTietSanPham(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        ChiTietSanPham ctsp = s.find(ChiTietSanPham.class, id);
        s.close();
        return ctsp;
    }
    
    public PhieuXuat findPhieuXuat(UUID id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        PhieuXuat px = s.find(PhieuXuat.class, id);
        s.close();
        return px;
    }
    
    public List<ChiTietPhieuXuat> findChiTietSanPhamByIdPhieuXuat(UUID id) {
        List<ChiTietPhieuXuat> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM domainModels.ChiTietPhieuXuat ctsp WHERE ctsp.idPhieuXuat.id = :id");
        q.setParameter("id", id);
        list = q.getResultList();
        s.close();
        return list;
    }

}
