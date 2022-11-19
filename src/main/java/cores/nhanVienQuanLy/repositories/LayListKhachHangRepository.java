/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.LayListKhachHangCustom;
import domainModels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class LayListKhachHangRepository {
    public List<LayListKhachHangCustom> getList() {
        List<LayListKhachHangCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery(" SELECT new cores.nhanVienQuanLy.customModels.LayListKhachHangCustom("
                + " kh.id as id, "
                + " kh.ma as ma, "
                + " kh.ten as ten, "
                + " kh.sdt as sdt, "
                + " kh.email as email, "
                + " kh.matKhau as matKhau, "
                + " kh.ngaySinh as ngaySinh, "
                + " kh.hinhAnh as hinhAnh, "
                + " kh.gioiTinh as gioiTinh,"
                + " kh.diaChi as diaChi,"
                + " kh.danhGia as danhGia, "
                + " kh.trangThai as trangThai "
                + " ) FROM domainModels.KhachHang kh"
        );
        list = q.getResultList();
        s.close();
        return list;
    }
    public KhachHang getListByID(UUID id) {
        KhachHang kh = new KhachHang();
        Session s = HibernateUtil.getSessionFactory().openSession();
        kh = s.find(KhachHang.class, id);
        s.close();
        return kh;
    }
}
