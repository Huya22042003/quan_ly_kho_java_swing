/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.repositories;

import cores.nhanVienQuanLy.customModels.LayListNhanVienCustom;
import domainModels.NhanVien;
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
public class LayListNhanVienRepository {

    public List<LayListNhanVienCustom> getList() {
        List<LayListNhanVienCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery(" SELECT new cores.nhanVienQuanLy.customModels.LayListNhanVienCustom("
                + " nv.id as id, "
                + " nv.ma as ma, "
                + " nv.ten as ten, "
                + " nv.sdt as sdt, "
                + " nv.email as email, "
                + " nv.matKhau as matKhau, "
                + " nv.ngaySinh as ngaySinh, "
                + " nv.hinhAnh as hinhAnh, "
                + " nv.gioiTinh as gioiTinh, "
                + " nv.diaChi as diaChi, "
                + " nv.trangThai as trangThai, "
                + " nv.idChucVu as idChucVu "
                + " ) FROM domainModels.NhanVien nv"
        );
        list = q.getResultList();
        s.close();
        return list;
    }

    public NhanVien getListByID(UUID id) {
        NhanVien nv = new NhanVien();
        Session s = HibernateUtil.getSessionFactory().openSession();
        nv = s.find(NhanVien.class, id);
        s.close();
        return nv;
    }
}
