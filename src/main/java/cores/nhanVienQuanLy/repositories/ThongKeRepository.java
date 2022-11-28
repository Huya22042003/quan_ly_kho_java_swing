/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.ThongKeCustom;
import domainModels.ChiTietSanPham;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class ThongKeRepository {

    public List<ThongKeCustom> thongKeSoLuongTonNhieuNhat() {
        Transaction tran = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        tran = s.beginTransaction();
        javax.persistence.Query query = s.createNativeQuery("SELECT TOP 1"
                + " * "
                + " FROM ChiTietSanPham ctsp order by ctsp.soLuongTon DESC");
        List<ThongKeCustom> tkc = query.getResultList();
        s.close();
        return tkc;
    }
}
