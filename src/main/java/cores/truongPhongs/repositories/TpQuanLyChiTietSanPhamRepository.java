/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import domainModels.ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamRepository {
    public List<TpQuanLyChiTietSanPhamCustom> getAll(){
        List<TpQuanLyChiTietSanPhamCustom> ct = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("select new cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom ("
                + "ct.id as id,"
                + "ct.giaBan as giaBan,"
                + "ct.giaNhap as giaNhap,"
                + "ct.hinhAnh as hinhAnh,"
                + "ct.soLuongTon as soLuongTon"
                + ") from domainModels.ChiTietSanPham ct");
        ct = q.getResultList();
        s.close();
        return ct;
    }
}
