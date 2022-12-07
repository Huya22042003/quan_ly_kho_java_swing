package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TP_KhachHangCustom;
import domainModels.KhachHang;
import infrastructures.constant.KhachHangConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;


public class TP_KhachHangRepository {

    public List<TP_KhachHangCustom> getList() {
        List<TP_KhachHangCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom ("
                + "k.id as id, "
                + "k.ma as ma, "
                + "k.ten as ten,"
                + "k.sdt as sdt,"
                + "k.email as email,"
                + "k.matKhau as matKhau,"
                + "k.ngaySinh as ngaySinh,"
                + "k.hinhAnh as hinhAnh,"
                + "k.gioiTinh as gioiTinh,"
                + "k.diaChi as diaChi,"
                + "k.danhGia as danhGia,"
                + "k.trangThai as trangThai"
                + ") FROM domainModels.KhachHang k ");
        list = q.getResultList();
        s.close();
        return list;
    }

    public KhachHang addKH(KhachHang kh) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tran = null;
            tran = s.beginTransaction();
            s.save(kh);
            tran.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return null;
        }
        return kh;
    }

    public boolean updateKH(KhachHang kh) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(kh);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public boolean deleteKH(UUID id) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            KhachHang kh = s.find(KhachHang.class, id);
            s.delete(kh);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }

    public TP_KhachHangCustom findByMa(String ma) {
        TP_KhachHangCustom csc = new TP_KhachHangCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom ("
                    + "k.id as id, "
                    + "k.ma as ma, "
                    + "k.ten as ten,"
                    + "k.sdt as sdt,"
                    + "k.email as email,"
                    + "k.matKhau as matKhau,"
                    + "k.ngaySinh as ngaySinh,"
                    + "k.hinhAnh as hinhAnh,"
                    + "k.gioiTinh as gioiTinh,"
                    + "k.diaChi as diaChi,"
                    + "k.danhGia as danhGia,"
                    + "k.trangThai as trangThai"
                    + ") FROM domainModels.KhachHang k WHERE k.ma = :ma");
            q.setParameter("ma", ma);
            csc = (TP_KhachHangCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return csc;
    }
    public TP_KhachHangCustom findByEmail(String email) {
        TP_KhachHangCustom csc = new TP_KhachHangCustom();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom ("
                    + "k.id as id, "
                    + "k.ma as ma, "
                    + "k.ten as ten,"
                    + "k.sdt as sdt,"
                    + "k.email as email,"
                    + "k.matKhau as matKhau,"
                    + "k.ngaySinh as ngaySinh,"
                    + "k.hinhAnh as hinhAnh,"
                    + "k.gioiTinh as gioiTinh,"
                    + "k.diaChi as diaChi,"
                    + "k.danhGia as danhGia,"
                    + "k.trangThai as trangThai"
                    + ") FROM domainModels.KhachHang k WHERE k.email = :email");
            q.setParameter("email", email);
            csc = (TP_KhachHangCustom) q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return csc;
    }

    // cách tìm kiếm thứ 2
    public List<TP_KhachHangCustom> findAllByTen(String ten, KhachHangConstant tt) {
        List<TP_KhachHangCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom("
                + "k.id as id, "
                + "k.ma as ma, "
                + "k.ten as ten,"
                + "k.sdt as sdt,"
                + "k.email as email,"
                + "k.matKhau as matKhau,"
                + "k.ngaySinh as ngaySinh,"
                + "k.hinhAnh as hinhAnh,"
                + "k.gioiTinh as gioiTinh,"
                + "k.diaChi as diaChi,"
                + "k.danhGia as danhGia,"
                + "k.trangThai as trangThai"
                + ") FROM domainModels.KhachHang k WHERE k.ten LIKE CONCAT('%',:ten,'%') AND k.trangThai = :tt");
        q.setParameter("ten", ten);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TP_KhachHangCustom> findAllBySDT(String sdt, KhachHangConstant tt) {
        List<TP_KhachHangCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom ("
                + "k.id as id, "
                + "k.ma as ma, "
                + "k.ten as ten,"
                + "k.sdt as sdt,"
                + "k.email as email,"
                + "k.matKhau as matKhau,"
                + "k.ngaySinh as ngaySinh,"
                + "k.hinhAnh as hinhAnh,"
                + "k.gioiTinh as gioiTinh,"
                + "k.diaChi as diaChi,"
                + "k.danhGia as danhGia,"
                + "k.trangThai as trangThai"
                + ") FROM domainModels.KhachHang k WHERE k.sdt LIKE CONCAT('%',:sdt,'%') AND k.trangThai = :tt");
        q.setParameter("sdt", sdt);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }

    public List<TP_KhachHangCustom> findAllByDiaChi(String diaChi, KhachHangConstant tt) {
        List<TP_KhachHangCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_KhachHangCustom ("
                + "k.id as id, "
                + "k.ma as ma, "
                + "k.ten as ten,"
                + "k.sdt as sdt,"
                + "k.email as email,"
                + "k.matKhau as matKhau,"
                + "k.ngaySinh as ngaySinh,"
                + "k.hinhAnh as hinhAnh,"
                + "k.gioiTinh as gioiTinh,"
                + "k.diaChi as diaChi,"
                + "k.danhGia as danhGia,"
                + "k.trangThai as trangThai"
                + ") FROM domainModels.KhachHang k WHERE k.diaChi LIKE CONCAT('%',:diaChi,'%') AND k.trangThai = :tt");
        q.setParameter("diaChi", diaChi);
        q.setParameter("tt", tt);
        list = q.getResultList();
        s.close();
        return list;
    }
    
}
