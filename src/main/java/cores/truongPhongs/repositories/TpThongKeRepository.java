/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class TpThongKeRepository {
    public List<TpTongSoSanPhamTrongKhoCustom> getSoLuongSpTon() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery(" Select SUM(SoLuongTon)\n" +
        "  from ChiTietSanPham");
       List<TpTongSoSanPhamTrongKhoCustom>  list = query.getResultList();
        return list;
    }
      public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanNhap() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("  select  count(Id) from PhieuHoanNhap");
       List<TpTongSoSanPhamTrongKhoCustom>  list = query.getResultList();
        return list;
    }
      public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("  select  count(Id) from PhieuHoanXuat");
       List<TpTongSoSanPhamTrongKhoCustom>  list = query.getResultList();
        return list;
    }
      public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaNhap() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("   select sum(Soluong) from ChiTietPhieuNhap");
       List<TpTongSoSanPhamTrongKhoCustom>  list = query.getResultList();
        return list;
    }
       public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("   select sum(Soluong) from ChiTietPhieuXuat");
       List<TpTongSoSanPhamTrongKhoCustom>  list = query.getResultList();
        return list;
    }
   
}
