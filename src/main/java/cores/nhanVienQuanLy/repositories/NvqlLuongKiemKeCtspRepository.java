/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import domainModels.ChiTietPhieuKiemKe;
import domainModels.ChiTietSanPham;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtspRepository {

    public List<NvqlLuongKiemKeCtspCustom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom("
                + " m.id,"
                + " m.sanPham.ma as ma,"
                + " m.sanPham.ten as ten,"
                + " m.soLuongTon as soLuongTon,"
                + " m.donVi as donVi,"
                + " m.mau as mau,"
                + " m.namBaoHanh as namBaoHanh,"
                + " m.GiaBan as giaBan) "
                + " from domainModels.ChiTietSanPham m ORDER BY m.sanPham.ma DESC");
        List<NvqlLuongKiemKeCtspCustom> list = query.getResultList();
        System.out.println(list.size());
        session.close();
        return list;
    }

    public void updateSoLuong(ChiTietSanPham nvqlLuongKiemKeCtspCustom) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            ChiTietSanPham c = s.find(ChiTietSanPham.class, nvqlLuongKiemKeCtspCustom.getId());
            c.setSoLuongTon(nvqlLuongKiemKeCtspCustom.getSoLuongTon());
            s.update(c);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }
}
