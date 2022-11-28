/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom;
import cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.KhachHang;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class Tai_NvqlLuongPhieuXuatRepository {

    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPhamBanHang(BigDecimal giaBatDau, BigDecimal giaKetThuc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT new cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom("
                + "ctsp.id as id,"
                + "ctsp.soLuongTon as soLuongTon,"
                + "ctsp.hinhAnh as hinhAnh,"
                + "ctsp.GiaNhap as GiaNhap,"
                + "ctsp.GiaBan as GiaBan,"
                + "ctsp.namBaoHanh as namBaoHanh,"
                + "ctsp.mau as mau,"
                + "ctsp.trangThai as trangThai,"
                + "ctsp.sanPham as sanPham,"
                + "ctsp.donVi as donVi"
                + ")FROM domainModels.ChiTietSanPham ctsp WHERE ctsp.GiaBan > :giaBatDau AND ctsp.GiaBan < :giaKetThuc");
        query.setParameter("giaBatDau", giaBatDau);
        query.setParameter("giaKetThuc", giaKetThuc);
        List<LuongBanHang_ChiTietSanPhamCustom> listCTSP = query.getResultList();
        return listCTSP;
    }

    public List<LuongBanHang_ChiTietSanPhamCustom> getListCTSanPham() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("SELECT new cores.nhanVienQuanLy.customModels.LuongBanHang_ChiTietSanPhamCustom("
                + "ctsp.id as id,"
                + "ctsp.soLuongTon as soLuongTon,"
                + "ctsp.hinhAnh as hinhAnh,"
                + "ctsp.GiaNhap as GiaNhap,"
                + "ctsp.GiaBan as GiaBan,"
                + "ctsp.namBaoHanh as namBaoHanh,"
                + "ctsp.mau as mau,"
                + "ctsp.trangThai as trangThai,"
                + "ctsp.sanPham as sanPham,"
                + "ctsp.donVi as donVi"
                + ")FROM domainModels.ChiTietSanPham ctsp WHERE ctsp.trangThai = :trangThai");
        query.setParameter("trangThai", TrangThaiSanPhamConstanst.DA_MO_BAN);
        List<LuongBanHang_ChiTietSanPhamCustom> listCTSP = query.getResultList();
        return listCTSP;
    }


    public NhanVien getNhanVienByMa(String ma) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("FROM domainModels.NhanVien kh WHERE kh.ma =:ma");
        query.setParameter("ma", ma);
        NhanVien nv = (NhanVien) query.getSingleResult();
        return nv;
    }

    public List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuat(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom("
                + "ctpx.idPhieuXuat as idPhieuXuat,"
                + "ctpx.idChiTietSp as idChiTietSp,"
                + "ctpx.soLuong as soLuong"
                + ") FROM domainModels.ChiTietPhieuXuat ctpx WHERE ctpx.idPhieuXuat.id =:id");
        query.setParameter("id", id);
        List<Luong_ChiTietPhieuXuatCustom> list = query.getResultList();
        return list;
    }

    public List<Luong_ChiTietPhieuXuatCustom> getListCTPhieuXuat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienQuanLy.customModels.Luong_ChiTietPhieuXuatCustom("
                + "ctpx.idPhieuXuat as idPhieuXuat,"
                + "ctpx.idChiTietSp as idChiTietSp,"
                + "ctpx.soLuong as soLuong"
                + ") FROM domainModels.ChiTietPhieuXuat ctpx");
        List<Luong_ChiTietPhieuXuatCustom> list = query.getResultList();
        return list;
    }

    public boolean addCTPX(ChiTietPhieuXuat ctpx) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.save(ctpx);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return false;
        }
        return true;
    }

    public void updateCTPX(ChiTietPhieuXuat ctpx) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.update(ctpx);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }

//    public ChiTietSanPham addCTSP(ChiTietSanPham ctsp) {
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Transaction trans = s.beginTransaction();
//            s.save(ctsp);
//            trans.commit();
//            s.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            s.close();
//        }
//        return ctsp;
//    }
    public void updateCTSP(ChiTietSanPham ctsp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction trans = s.beginTransaction();
            s.update(ctsp);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }

}
