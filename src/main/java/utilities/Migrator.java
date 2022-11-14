/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import domainModels.CoSo;
<<<<<<< HEAD
import domainModels.DonHang;
import domainModels.HoaDon;
import domainModels.KhachHang;
import domainModels.KhoHang;
import domainModels.LoaiHang;
import domainModels.NhaCungCap;
import domainModels.NhanVienGiaoHang;
import domainModels.NhanVienVanDon;
import domainModels.TruongPhong;
import infrastructures.NhaCungCapConstant;
=======
>>>>>>> 4191a03e1bae23f0cbd8ef8df15668152f42b328
import infrastructures.constant.CoSoConstant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Phong
 */
public class Migrator {

    //Tạo DB trong SQL SERVER = SOFT2041_PTPM
    //Sau đó tiến hành chạy đển zen bảng
    public static void main(String[] args) {
        // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("META-INF/hibernate.cfg.xml")
                .applySetting("hibernate.hbm2ddl.auto", "create")
                .build();

        // Tạo nguồn siêu dữ liệu (metadata) từ ServiceRegistry
        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        // insert database
        // insert Nhà cung cấp
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMa("CS001");
        ncc.setTen("Phạm Xuân Hải");
        ncc.setDiaChi("Hải Dương");
        ncc.setSdt("0339821695");
        ncc.setEmail("hai@gmail.com");
        ncc.setKhuVuc("Hà Nội");
        ncc.setTrangThai(NhaCungCapConstant.DANG_SU_DUNG);
        session.save(ncc);
        NhaCungCap ncc1 = new NhaCungCap();
        ncc.setMa("CS002");
        ncc.setTen("Vũ Thị Tuyết");
        ncc.setDiaChi("Hải Dương");
        ncc.setSdt("0339821695");
        ncc.setEmail("tuyet@gmail.com");
        ncc.setKhuVuc("HCM");
        ncc.setTrangThai(NhaCungCapConstant.DANG_SU_DUNG);
        session.save(ncc1);
        NhaCungCap ncc2 = new NhaCungCap();
        ncc.setMa("CS003");
        ncc.setTen("Nguyễn Quốc Huy");
        ncc.setDiaChi("Hải Dương");
        ncc.setSdt("0339821695");
        ncc.setEmail("huy@gmail.com");
        ncc.setKhuVuc("Đà Nẵng");
        ncc.setTrangThai(NhaCungCapConstant.DANG_SU_DUNG);
        session.save(ncc2);
        // insert Cơ sở
        CoSo cs = new CoSo();
        cs.setMa("CS001");
        cs.setTen("Hà Nội");
        cs.setViTri("Hà Nội");
        cs.setTrangThai(CoSoConstant.DANG_HOAT_DONG);
        session.save(cs);

        CoSo cs1 = new CoSo();
        cs1.setMa("CS002");
        cs1.setTen("HCM");
        cs1.setViTri("TP. HCM");
        cs1.setTrangThai(CoSoConstant.DANG_HOAT_DONG);
        session.save(cs1);

        CoSo cs2 = new CoSo();
        cs2.setMa("CS003");
        cs2.setTen("Hải Phòng");
        cs2.setViTri("Hải Phòng");
        cs2.setTrangThai(CoSoConstant.DANG_HOAT_DONG);
        session.save(cs2);

        CoSo cs3 = new CoSo();
        cs3.setMa("CS004");
        cs3.setTen("Quảng Ninh");
        cs3.setViTri("Quảng Ninh");
        cs3.setTrangThai(CoSoConstant.DANG_HOAT_DONG);
        session.save(cs3);

        trans.commit();
        session.close();
    }
}
