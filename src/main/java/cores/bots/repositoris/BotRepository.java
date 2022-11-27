/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.bots.repositoris;

import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.DateTimeUtil;
import utilities.HibernateUtil;

/**
 *
 * @author QUOC HUY
 */
public class BotRepository {

    public boolean updateTrangThai() {
        Transaction tran = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tran = s.beginTransaction();
            Query q = s.createNativeQuery("UPDATE [dbo].[PhieuXuat] "
                    + "   SET [TrangThai] = :trangThai "
                    + " WHERE [NgayThanhToan] IS NULL AND [NgayTao] <= :ngayHienTai AND [TrangThai] != 1", PhieuXuat.class);
            q.setParameter("ngayHienTai", DateTimeUtil.convertDateToTimeStampSecond() - 172804492);
            q.setParameter("trangThai", 1);
            System.out.println(q.executeUpdate());
            if(q.executeUpdate() == 0) {
                return false;
            }
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
    }
    
}
