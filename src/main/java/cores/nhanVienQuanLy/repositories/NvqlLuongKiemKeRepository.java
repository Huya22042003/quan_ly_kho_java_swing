package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import domainModels.PhieuKiemKe;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeRepository {

    public List<NvqlLuongKiemKeCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom("
                + " m.id,"
                + " m.ma as maPhieuKiem,"
                + " m.ngayTao as ngayTao,"
                + " m.nhanVien as idNV,"
                + " m.trangThai as trangThai) "
                + " from domainModels.PhieuKiemKe m ORDER BY m.ngayTao DESC");
        List<NvqlLuongKiemKeCustom> list = query.getResultList();
        session.close();
        return list;
    }

    public void them(PhieuKiemKe phieuKiemKe) {
        Transaction t = null;
        String check;
        try ( Session session = new HibernateUtil().getSessionFactory().openSession();) {
            t = session.beginTransaction();
            session.save(phieuKiemKe);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback(); //hoàn lại kết quả
        }
    }
    public boolean updateTrangThai(PhieuKiemKe phieuKiemKe){
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = null;
            transaction = s.beginTransaction();
            s.update(phieuKiemKe);
            transaction.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return false;
        }
        return true;
    }
}
