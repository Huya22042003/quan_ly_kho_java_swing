/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.services.serviceImpl;

import com.mycompany.utilities.HibernateUtil;
import com.mycompany.viewModels.CoSoViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author QUOC HUY
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<CoSoViewModel> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("SELECT new com.mycompany.viewModels.CoSoViewModel("
                + " cs.id as id, "
                + " cs.ma as ma, "
                + " cs.ten as ten, "
                + " cs.viTri as viTri, "
                + " cs.trangThai as tinhTrang"
                + ") FROM com.mycompany.domainModels.CoSo cs");
        list = q.getResultList();
        s.close();
        System.out.println(list.size());
    }
    
}
