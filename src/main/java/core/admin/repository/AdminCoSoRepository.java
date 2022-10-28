/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.admin.repository;

import domainModel.CoSo;
import java.util.UUID;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utilit.HibernateUtil;

/**
 *
 * @author Acer
 */
public class AdminCoSoRepository {
    public CoSo findCoSoById(UUID id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        CoSo cs = s.find(CoSo.class, id);
        s.close();
        return cs;
    }
}
