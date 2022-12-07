package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import domainModels.ChiTietSanPham;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.util.List;
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
                + " m.GiaBan as giaBan,"
                + " m.size as size, "
                + " m.ngayTao as ngayTao) "
                + " from domainModels.ChiTietSanPham m "
                + " WHERE m.trangThai = :trangThai "
                + " ORDER BY m.sanPham.ma DESC");
        query.setParameter("trangThai", TrangThaiSanPhamConstanst.DA_MO_BAN);
        List<NvqlLuongKiemKeCtspCustom> list = query.getResultList();
        session.close();
        return list;
    }

    public void updateSoLuong(ChiTietSanPham nvqlLuongKiemKeCtspCustom) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            ChiTietSanPham c = s.find(ChiTietSanPham.class, nvqlLuongKiemKeCtspCustom.getId());
            c.setSoLuongTon(nvqlLuongKiemKeCtspCustom.getSoLuongTon());
            c.setTrangThai(TrangThaiSanPhamConstanst.CHO_XAC_NHAN);
            s.update(c);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }
    public void updateTrangThaiSp(ChiTietSanPham nvqlLuongKiemKeCtspCustom) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            ChiTietSanPham c = s.find(ChiTietSanPham.class, nvqlLuongKiemKeCtspCustom.getId());
            c.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
            s.update(c);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }
}
