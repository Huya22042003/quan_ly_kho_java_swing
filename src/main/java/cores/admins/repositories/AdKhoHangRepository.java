/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.repositories;

import cores.admins.customModels.AdKhoHangCustom;
import domainModels.KhoHang;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class AdKhoHangRepository {
      public List<AdKhoHangCustom> getListKhoHang() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new cores.admins.customModels.AdKhoHangCustom("
                + "kh.id as id,"
                + "kh.ma as ma,"
                + "kh.ten as ten,"
                + "kh.trangThai as trangThai,"
                + "kh.idCoSo.id as id,"
                + "kh.idCoSo.ten as tenCoSo) from domainModels.KhoHang kh");
        List<AdKhoHangCustom> listKhoHang = q.getResultList();
        s.close();
        return listKhoHang;

    }

    public KhoHang saveKhoHang(KhoHang kh) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        s.save(kh);
        s.getTransaction().commit();
        s.close();
        return kh;
    }
    public void updateKhoHang(KhoHang kh){

            Session s = HibernateUtil.getSessionFactory().openSession();
            s.getTransaction().begin();
            s.update(kh);
            s.getTransaction().commit();
            s.close();
  
    }
    public void deleteKhoHangById(UUID id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        KhoHang kh = s.find(KhoHang.class, id);
        s.delete(kh);
        s.getTransaction().commit();
        s.close();
    }
}
