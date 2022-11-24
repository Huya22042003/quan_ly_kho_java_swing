/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import java.util.List;
import org.hibernate.Session;
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
                + " m.donVi.donViGoc as donVi,"
                + " m.mau as mau,"
                + " m.namBaoHanh as namBaoHanh,"
                + " m.GiaBan as giaBan) "
                + " from domainModels.ChiTietSanPham m ORDER BY m.sanPham.ma DESC");
        List<NvqlLuongKiemKeCtspCustom> list = query.getResultList();
        System.out.println(list.size());
        session.close();
        return list;
    }
}
