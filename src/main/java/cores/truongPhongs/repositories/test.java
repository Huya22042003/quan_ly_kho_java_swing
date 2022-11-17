/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cores.truongPhongs.repositories;

import cores.truongPhongs.customModels.TpDonViCustom;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author LENOVO
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<TpDonViCustom> list = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery(" SELECT new cores.truongPhongs.customModels.TpDonViCustom ("
                + " dv.id as id, "
                + " dv.donViGoc as donViGoc, "
                + " dv.donViQuyDoi as donViQuyDoi, "
                + " dv.soLuong as soLuong "
                + " ) FROM domainModels.DonVi dv"
        );
        list = q.getResultList();
        s.close();
        System.out.println(list.size());
    }

}
