/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        System.out.println(list.size());
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
}
