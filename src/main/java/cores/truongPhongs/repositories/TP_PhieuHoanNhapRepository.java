package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TP_HoanNhap_PhieuNhapCustom;
import cores.truongPhongs.customModels.TP_HoanNhap_ctpCusTom;
import cores.truongPhongs.customModels.TP_HoanNhap_spCustom;
import cores.truongPhongs.customModels.TP_PhieuHoanNhapCustom;
import domainModels.ChiTietPhieuHoanNhap;
import domainModels.ChiTietPhieuHoanNhapId;
import domainModels.ChiTietSanPham;
import domainModels.PhieuHoanNhap;
import domainModels.PhieuNhap;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class TP_PhieuHoanNhapRepository {

    public List<TP_HoanNhap_PhieuNhapCustom> getListPhieuNhap() {
        List<TP_HoanNhap_PhieuNhapCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_HoanNhap_PhieuNhapCustom ("
                + " pn.id as id, "
                + " pn.ngayTao as ngayTao, "
                + " pn.ghiChu as ghiChu, "
                + " pn.ngayThanhToan as ngayThanhToan, "
                + " pn.trangThai as trangThai, "
                + " pn.nhanVien as nhanhVien, "
                + " pn.nhaCungCap as nhaCungCap"
                + ") FROM domainModels.PhieuNhap pn WHERE pn.ngayThanhToan IS NULL");
        list = q.getResultList();
        return list;
    }

    public List<TP_PhieuHoanNhapCustom> getListPhieuHoanNhap() {
        List<TP_PhieuHoanNhapCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_PhieuHoanNhapCustom ("
                + " p.id, "
                + " p.ngayTao, "
                + " p.ghiChu, "
                + " p.liDo, "
                + " p.ngayThanhToan,"
                + " p.trangThai, "
                + " p.phieuNhap"
                + ") FROM domainModels.PhieuHoanNhap p");
        list = q.getResultList();
        return list;
    }

    public List<TP_HoanNhap_spCustom> getListSpByPhieuNhap(UUID idPhieuNhap) {
        List<TP_HoanNhap_spCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        PhieuNhap pn = s.find(PhieuNhap.class, idPhieuNhap);
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_HoanNhap_spCustom ("
                + " pn.idChiTietSp.id as id, "
                + " pn.idChiTietSp.soLuongTon as soLuongTon, "
                + " pn.idChiTietSp.hinhAnh as hinhAnh, "
                + " pn.idChiTietSp.GiaNhap as GiaNhap, "
                + " pn.idChiTietSp.GiaBan as GiaBan, "
                + " pn.idChiTietSp.namBaoHanh as namBaoHanh, "
                + " pn.idChiTietSp.mau as mau, "
                + " pn.idChiTietSp.sanPham as sanPham, "
                + " pn.idChiTietSp.donVi as donVi"
                + ") FROM domainModels.ChiTietPhieuNhap pn WHERE pn.idPhieuNhap = :idPhieuNhap");
        q.setParameter("idPhieuNhap", pn);
        list = q.getResultList();
        return list;
    }

    public boolean addPhieuHoanNhap(PhieuHoanNhap phn) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = s.beginTransaction();
            s.save(phn);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addChiTietPhieuHoanNhap(UUID sp, UUID idPhieuHoanNhap, int soLuongHoan) {
        System.out.println(soLuongHoan);
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            PhieuHoanNhap phn = s.find(PhieuHoanNhap.class, idPhieuHoanNhap);
            ChiTietSanPham ctsp = s.find(ChiTietSanPham.class, sp);
            Transaction tran = s.beginTransaction();
            ChiTietPhieuHoanNhap ctphn = new ChiTietPhieuHoanNhap();
            ctphn.setIdChiTietSp(ctsp);
            ctphn.setIdPhieuHoanNhap(phn);
            ctphn.setSoLuong(soLuongHoan);
            s.save(ctphn);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soLuongHoan);
            s.update(ctsp);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
        public boolean removeChiTietPhieuHoanNhap(UUID sp, UUID idPhieuHoanNhap, int soLuongHoan) {
//        System.out.println(soLuongHoan);
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            PhieuHoanNhap phn = s.find(PhieuHoanNhap.class, idPhieuHoanNhap);
            ChiTietSanPham ctsp = s.find(ChiTietSanPham.class, sp);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() + soLuongHoan);
            s.update(ctsp);            
            Transaction tran = s.beginTransaction();
            ChiTietPhieuHoanNhapId chiTietPhieuHoanNhapId = new ChiTietPhieuHoanNhapId(phn, ctsp);
            ChiTietPhieuHoanNhap ctphn = s.find(ChiTietPhieuHoanNhap.class, chiTietPhieuHoanNhapId);
            ctphn.setSoLuong(ctphn.getSoLuong() - soLuongHoan);
            s.update(ctphn);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<TP_HoanNhap_ctpCusTom> getListCtpByPhieuHoanNhap(UUID idPhieuHoanNhap) {
        List<TP_HoanNhap_ctpCusTom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        PhieuHoanNhap pn = s.find(PhieuHoanNhap.class, idPhieuHoanNhap);
        Query q = s.createQuery("SELECT new cores.truongPhongs.customModels.TP_HoanNhap_ctpCusTom ("
                + " pn.idChiTietSp.id as id, "
                + " pn.idChiTietSp.soLuongTon as soLuongTon, "
                + " pn.idChiTietSp.hinhAnh as hinhAnh, "
                + " pn.idChiTietSp.GiaNhap as GiaNhap, "
                + " pn.idChiTietSp.GiaBan as GiaBan, "
                + " pn.idChiTietSp.namBaoHanh as namBaoHanh, "
                + " pn.idChiTietSp.mau as mau, "
                + " pn.idChiTietSp.sanPham as sanPham, "
                + " pn.idChiTietSp.donVi as donVi, "
                + " pn.soLuong"
                + ") FROM domainModels.ChiTietPhieuHoanNhap pn WHERE pn.idPhieuHoanNhap = :idPhieuNhap");
        q.setParameter("idPhieuNhap", pn);
        list = q.getResultList();
        return list;
    }

}