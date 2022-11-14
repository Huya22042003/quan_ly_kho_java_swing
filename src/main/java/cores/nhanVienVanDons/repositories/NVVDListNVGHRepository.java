/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienVanDons.repositories;

import cores.nhanVienVanDons.customModels.NVVDListNVGHCustom;
import domainModels.NhanVienGiaoHang;
import domainModels.NhanVien;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class NVVDListNVGHRepository {
    public List<NVVDListNVGHCustom> getListNVGHByMa(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT new cores.nhanVienVanDons.customModels.NVVDListNVGHCustom("
                + "nvgh.id as id,"
                + "nvgh.ma as ma,"
                + "nvgh.ten as ten,"
                + "nvgh.sdt as sdt,"
                + "nvgh.email as email,"
                + "nvgh.matKhau as matKhau,"
                + "nvgh.ngaySinh as ngaySinh,"
                + "nvgh.hinhAnh as hinhAnh,"
                + "nvgh.gioiTinh as gioiTinh,"
                + "nvgh.trangThai as trangThai, "
                + "nvgh.idKhoHang.ma as idKhoHang,"
                + "nvgh.idKhoGiao.ma as idKhoGiao"
                + ") FROM domainModels.NhanVienGiaoHang nvgh");
        List<NVVDListNVGHCustom> list = query.getResultList();
        session.close();
        return list;
    }

}
