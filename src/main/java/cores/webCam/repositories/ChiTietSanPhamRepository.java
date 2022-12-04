/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.webCam.repositories;

import cores.webCam.customModels.ChiTietSanPhamCustom;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class ChiTietSanPhamRepository {
    public List<ChiTietSanPhamCustom> getListChiTietSanPham() {
        List<ChiTietSanPhamCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.webCam.customModels.ChiTietSanPhamCustom ("
                + "s.id ,"
                + "s.soLuongTon ,"
                + "s.hinhAnh , "
                + "s.GiaNhap , "
                + "s.GiaBan , "
                + "s.namBaoHanh , "
                + "s.mau , "
                + "s.trangThai, "
                + "s.size,"
                + "s.ngayTao,"
                + "s.sanPham,"
                + "s.donVi"
                + ") FROM domainModels.ChiTietSanPham s");
        list = q.getResultList();
        return list;
    }
    
    public boolean addChiTietPhieuXuat(UUID idPhieuXuat, ChiTietSanPham ctsp, int sl) {
        Transaction tran = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            PhieuXuat px = s.find(PhieuXuat.class, idPhieuXuat);
            ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat(px, ctsp, sl);
            s.save(ctpx);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
