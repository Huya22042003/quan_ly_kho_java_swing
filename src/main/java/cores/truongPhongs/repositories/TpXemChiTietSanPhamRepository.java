/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class TpXemChiTietSanPhamRepository {
      public List<TpXemChiTietSanPhamCustom> getAll() {
        List<TpXemChiTietSanPhamCustom> ct = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.GiaNhap as giaNhap,"
                + "ct.GiaBan as giaBan," 
                + "ct.namBaoHanh as namBaoHanh,"
                + "ct.mau as mau,"
                + "ct.sanPham as sanPham,"
                + "ct.donVi.donViGoc as donVi,"
                + "ct.trangThai as trangThai,"
                + "ct.soLuongTon as soLuongTon"
                + ") from domainModels.ChiTietSanPham ct");
        ct = q.getResultList();
        s.close();
        return ct;
    }
}
