/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.NvqlQuanLyPhieuNhapCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;
import domainModels.PhieuNhap;
/**
 *
 * @author Acer
 */
public class NvqlQuanLyPhieuNhapRepository {
    public List<NvqlQuanLyPhieuNhapCustom> getListPhieuNhap(){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new  cores.truongPhongs.customModels.NvqlQuanLyPhieuNhapCustom( "
                + "p.id as id,"
                + "p.ghiChu as ghiChu,"
                + "p.ngayNhan as ngayNhan,"
                + "p.ngayTao as ngayTao,"
                + "p.idNhanVien.id as idNhanVien,"
                + "p.idNhanVien.ten as tenNhanVien,"
                + "p.idNhaCungCap.id as idNcc,"
                + "p.idNhaCungCap.ten as tenNcc "
                + "from domainModels.PhieuNhap ");
        List<NvqlQuanLyPhieuNhapCustom> listPn = q.getResultList();
        s.close();
        return listPn;
    }
    public static void main(String[] args) {
        
    }
}
