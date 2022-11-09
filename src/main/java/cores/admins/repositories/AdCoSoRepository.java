/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.repositories;

import cores.admins.customModels.AdGetTenCoSoCustom;
import domainModels.CoSo;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import utilities.HibernateUtil;

/**
 *
 * @author Acer
 */
public class AdCoSoRepository {
     public CoSo findCoSoById(UUID id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        CoSo cs = s.find(CoSo.class, id);
        s.close();
        return cs;
    }
    public List<AdGetTenCoSoCustom>  getCBBCoSo(){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("Select new  cores.admins.customModels.AdGetTenCoSoCustom("
                + "cs.id as id,"
                + "cs.ten as ten"
                + ") from domainModels.CoSo cs");
        List<AdGetTenCoSoCustom> list = q.getResultList();
        s.close();
        return list;
    }
}
