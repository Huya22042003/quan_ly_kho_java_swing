/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import domainModels.ChucVu;
import domainModels.CoSo;
import domainModels.NhanVien;
import infrastructures.constant.CoSoConstant;
import infrastructures.constant.GioiTinhConstant;
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
        
        // Chức vụ
        ChucVu chucVu = new ChucVu();
        chucVu.setMa("CV0001");
        chucVu.setTen("Trưởng Phòng");
        session.save(chucVu);
        
        ChucVu chucVu1 = new ChucVu();
        chucVu1.setMa("CV0002");
        chucVu1.setTen("Nhân viên quản lý");
        session.save(chucVu1);
        
        ChucVu chucVu2 = new ChucVu();
        chucVu2.setMa("CV0003");
        chucVu2.setTen("Nhân viên");
        session.save(chucVu2);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("NV00001");
        nhanVien.setTen("Nguyễn Quốc Huy");
        nhanVien.setDiaChi("Hà Nội");
        nhanVien.setEmail("huynqph26782@fpt.edu.vn");
        nhanVien.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien.setHinhAnh(null);
        nhanVien.setIdChucVu(chucVu);
        nhanVien.setMatKhau("1");
        nhanVien.setNgaySinh(Long.valueOf(100000000));
        
        

        trans.commit();
        session.close();
    }
}
