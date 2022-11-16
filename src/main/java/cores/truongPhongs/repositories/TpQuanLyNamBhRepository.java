/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpQuanLyNamBhCustom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;
import domainModels.NamBaoHanh;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author Acer
 */

public class TpQuanLyNamBhRepository {

    public List<TpQuanLyNamBhCustom> getListNamBh() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new cores.truongPhongs.customModels.TpQuanLyNamBhCustom( "
                + "n.id as id,"
                + "n.ma as ma,"
                + "n.ten as ten "
                + ") from domainModels.NamBaoHanh");
        List<TpQuanLyNamBhCustom> listNBH = q.getResultList();
        return listNBH;
    }

    public NamBaoHanh addNamBh(NamBaoHanh n) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = s.beginTransaction();
            s.save(n);
            t.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
            return null;
        }
        return n;
    }

    public boolean updateNamBh(NamBaoHanh n) {
        Transaction tran = null;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            s.update(n);
            tran.commit();
            s.close();
        } catch (Exception e) {

            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    public boolean deleteNamBh(UUID id){
        Transaction tran = null;
        try(Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            NamBaoHanh n = s.find(NamBaoHanh.class, id);
            s.delete(n);
            tran.commit();
            s.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
        return true;
    }
    
}
