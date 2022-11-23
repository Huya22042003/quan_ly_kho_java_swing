/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtpkRepository {
    public List<NvqlLuongKiemKeCtpkCustom> getAll(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        javax.persistence.Query query = session.createQuery("select "
                + " new cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom("
                + " m.idChiTietSp.sanPham.ma as ma,"
                + " m.idChiTietSp.sanPham.ten as ten,"
                + " m.soLuongTon as soLuongTon,"
                + " m.soLuongThucTon as soLuongThucTon,"
                + " m.idPhieuKiemKe.id as idPhieuKiemKe,"
                + " m.idChiTietSp.id as idChiTietSanPham"
                + " )"
                + " from domainModels.ChiTietPhieuKiemKe m WHERE m.idPhieuKiemKe.id = :id");
        query.setParameter("id", id);
        List<NvqlLuongKiemKeCtpkCustom> list = query.getResultList();
        session.close();
        return list;
    }
}
