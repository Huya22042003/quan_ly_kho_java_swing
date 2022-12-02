package cores.exportPDF.repositoris;

import domainModels.ChiTietSanPham;
import java.util.UUID;
import org.hibernate.Session;
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
}
