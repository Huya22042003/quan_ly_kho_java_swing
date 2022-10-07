/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilities;

import com.mycompany.domainModels.CoSo;
import com.mycompany.domainModels.DonHang;
import com.mycompany.domainModels.HoaDon;
import com.mycompany.domainModels.KhachHang;
import com.mycompany.domainModels.KhoHang;
import com.mycompany.domainModels.LoaiHang;
import com.mycompany.domainModels.NhanVienGiaoHang;
import com.mycompany.domainModels.NhanVienVanDon;
import com.mycompany.domainModels.TruongPhong;
import java.math.BigDecimal;
import java.sql.Date;
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
        cs.setTrangThai(1);
        session.save(cs);

        CoSo cs1 = new CoSo();
        cs1.setMa("CS002");
        cs1.setTen("HCM");
        cs1.setViTri("TP. HCM");
        cs1.setTrangThai(0);
        session.save(cs1);

        CoSo cs2 = new CoSo();
        cs2.setMa("CS003");
        cs2.setTen("Hải Phòng");
        cs2.setViTri("Hải Phòng");
        cs2.setTrangThai(0);
        session.save(cs2);

        CoSo cs3 = new CoSo();
        cs3.setMa("CS004");
        cs3.setTen("Quảng Ninh");
        cs3.setViTri("Quảng Ninh");
        cs3.setTrangThai(1);
        session.save(cs3);

        // insert Loại Hàng
        LoaiHang lh = new LoaiHang();
        lh.setMa("LH001");
        lh.setTen("Hàng nặng");
        lh.setMoTa("Hàng lớn hơn 100 kg");
        lh.setGia(new BigDecimal("100000"));
        session.save(lh);

        LoaiHang lh1 = new LoaiHang();
        lh1.setMa("LH002");
        lh1.setTen("Hàng Cấm");
        lh1.setMoTa("Bị nhà nước cấm");
        lh1.setGia(new BigDecimal("100000000000000"));
        session.save(lh1);

        LoaiHang lh2 = new LoaiHang();
        lh2.setMa("LH003");
        lh2.setTen("Hàng nhẹ");
        lh2.setMoTa("Hàng nhẹ hơn 10 kg");
        lh2.setGia(new BigDecimal("100"));
        session.save(lh2);

        LoaiHang lh3 = new LoaiHang();
        lh3.setMa("LH004");
        lh3.setTen("Hàng bình thường");
        lh3.setMoTa("Hàng ok");
        lh3.setGia(new BigDecimal("10000"));
        session.save(lh3);

        // insert Kho Hàng
        KhoHang kh = new KhoHang();
        kh.setMa("KHO01");
        kh.setTen("Kho " + cs.getTen());
        kh.setTrangThai(1);
        kh.setIdCoSo(cs);
        session.save(kh);

        KhoHang kh1 = new KhoHang();
        kh1.setMa("KHO02");
        kh1.setTen("Kho " + cs1.getTen());
        kh1.setTrangThai(1);
        kh1.setIdCoSo(cs1);
        session.save(kh1);

        KhoHang kh2 = new KhoHang();
        kh2.setMa("KHO03");
        kh2.setTen("Kho " + cs2.getTen());
        kh2.setTrangThai(0);
        kh2.setIdCoSo(cs2);
        session.save(kh2);

        KhoHang kh3 = new KhoHang();
        kh3.setMa("KHO04");
        kh3.setTen("Kho " + cs3.getTen());
        kh3.setTrangThai(1);
        kh3.setIdCoSo(cs3);
        session.save(kh3);

        // Nhân Viên
        TruongPhong tp = new TruongPhong();
        tp.setMa("TP001");
        tp.setTen("Nguyễn Quốc Huy");
        tp.setSdt("0328843156");
        tp.setEmail("huynqph26782@fpt.edu.vn");
        tp.setMatKhau("1");
        tp.setNgaySinh(Date.valueOf("2003-04-22"));
        tp.setGioiTinh(0);
        tp.setTrangThai(1);
        tp.setIdKhoHang(kh);
        session.save(tp);

        TruongPhong tp1 = new TruongPhong();
        tp1.setMa("TP002");
        tp1.setTen("Nguyễn Quốc Huy");
        tp1.setSdt("0328843156");
        tp1.setEmail("huynqph26782@fpt.edu.vn");
        tp1.setMatKhau("1");
        tp1.setNgaySinh(Date.valueOf("2003-04-22"));
        tp1.setGioiTinh(0);
        tp1.setTrangThai(1);
        tp1.setIdKhoHang(kh1);
        session.save(tp1);

        TruongPhong tp2 = new TruongPhong();
        tp2.setMa("TP003");
        tp2.setTen("Nguyễn Quốc Huy");
        tp2.setSdt("0328843156");
        tp2.setEmail("huynqph26782@fpt.edu.vn");
        tp2.setMatKhau("1");
        tp2.setNgaySinh(Date.valueOf("2003-04-22"));
        tp2.setGioiTinh(0);
        tp2.setTrangThai(1);
        tp2.setIdKhoHang(kh2);
        session.save(tp2);

        TruongPhong tp3 = new TruongPhong();
        tp3.setMa("TP004");
        tp3.setTen("Nguyễn Quốc Huy");
        tp3.setSdt("0328843156");
        tp3.setEmail("huynqph26782@fpt.edu.vn");
        tp3.setMatKhau("1");
        tp3.setNgaySinh(Date.valueOf("2003-04-22"));
        tp3.setGioiTinh(0);
        tp3.setTrangThai(1);
        tp3.setIdKhoHang(kh3);
        session.save(tp3);

        NhanVienVanDon nvvd = new NhanVienVanDon();
        nvvd.setMa("VD001");
        nvvd.setTen("Nguyễn Quốc Huy");
        nvvd.setSdt("0328843156");
        nvvd.setEmail("huynqph26782@fpt.edu.vn");
        nvvd.setMatKhau("1");
        nvvd.setNgaySinh(Date.valueOf("2003-04-22"));
        nvvd.setGioiTinh(0);
        nvvd.setTrangThai(1);
        nvvd.setIdKhoHang(kh1);
        session.save(nvvd);

        NhanVienVanDon nvvd1 = new NhanVienVanDon();
        nvvd1.setMa("VD002");
        nvvd1.setTen("Nguyễn Quốc Huy");
        nvvd1.setSdt("0328843156");
        nvvd1.setEmail("huynqph26782@fpt.edu.vn");
        nvvd1.setMatKhau("1");
        nvvd1.setNgaySinh(Date.valueOf("2003-04-22"));
        nvvd1.setGioiTinh(0);
        nvvd1.setTrangThai(1);
        nvvd1.setIdKhoHang(kh1);
        session.save(nvvd1);

        NhanVienVanDon nvvd2 = new NhanVienVanDon();
        nvvd2.setMa("VD003");
        nvvd2.setTen("Nguyễn Quốc Huy");
        nvvd2.setSdt("0328843156");
        nvvd2.setEmail("huynqph26782@fpt.edu.vn");
        nvvd2.setMatKhau("1");
        nvvd2.setNgaySinh(Date.valueOf("2003-04-22"));
        nvvd2.setGioiTinh(0);
        nvvd2.setTrangThai(1);
        nvvd2.setIdKhoHang(kh1);
        session.save(nvvd2);

        NhanVienVanDon nvvd3 = new NhanVienVanDon();
        nvvd3.setMa("VD004");
        nvvd3.setTen("Nguyễn Quốc Huy");
        nvvd3.setSdt("0328843156");
        nvvd3.setEmail("huynqph26782@fpt.edu.vn");
        nvvd3.setMatKhau("1");
        nvvd3.setNgaySinh(Date.valueOf("2003-04-22"));
        nvvd3.setGioiTinh(0);
        nvvd3.setTrangThai(1);
        nvvd3.setIdKhoHang(kh1);
        session.save(nvvd3);

        NhanVienGiaoHang nvgh = new NhanVienGiaoHang();
        nvgh.setMa("GH001");
        nvgh.setTen("Nguyễn Quốc Huy");
        nvgh.setSdt("0328843156");
        nvgh.setEmail("huynqph26782@fpt.edu.vn");
        nvgh.setMatKhau("1");
        nvgh.setNgaySinh(Date.valueOf("2003-04-22"));
        nvgh.setGioiTinh(0);
        nvgh.setTrangThai(1);
        nvgh.setIdKhoHang(kh1);
        nvgh.setIdKhoGiao(kh3);
        session.save(nvgh);

        NhanVienGiaoHang nvgh1 = new NhanVienGiaoHang();
        nvgh1.setMa("GH002");
        nvgh1.setTen("Nguyễn Quốc Huy");
        nvgh1.setSdt("0328843156");
        nvgh1.setEmail("huynqph26782@fpt.edu.vn");
        nvgh1.setMatKhau("1");
        nvgh1.setNgaySinh(Date.valueOf("2003-04-22"));
        nvgh1.setGioiTinh(0);
        nvgh1.setTrangThai(1);
        nvgh1.setIdKhoHang(kh1);
        nvgh1.setIdKhoGiao(kh3);
        session.save(nvgh1);

        NhanVienGiaoHang nvgh2 = new NhanVienGiaoHang();
        nvgh2.setMa("GH003");
        nvgh2.setTen("Nguyễn Quốc Huy");
        nvgh2.setSdt("0328843156");
        nvgh2.setEmail("huynqph26782@fpt.edu.vn");
        nvgh2.setMatKhau("1");
        nvgh2.setNgaySinh(Date.valueOf("2003-04-22"));
        nvgh2.setGioiTinh(0);
        nvgh2.setTrangThai(1);
        nvgh2.setIdKhoHang(kh1);
        nvgh2.setIdKhoGiao(kh);
        session.save(nvgh2);

        NhanVienGiaoHang nvgh3 = new NhanVienGiaoHang();
        nvgh3.setMa("GH004");
        nvgh3.setTen("Nguyễn Quốc Huy");
        nvgh3.setSdt("0328843156");
        nvgh3.setEmail("huynqph26782@fpt.edu.vn");
        nvgh3.setMatKhau("1");
        nvgh3.setNgaySinh(Date.valueOf("2003-04-22"));
        nvgh3.setGioiTinh(0);
        nvgh3.setTrangThai(1);
        nvgh3.setIdKhoHang(kh1);
        nvgh3.setIdKhoGiao(kh2);
        session.save(nvgh3);

        NhanVienGiaoHang nvgh4 = new NhanVienGiaoHang();
        nvgh4.setMa("GH005");
        nvgh4.setTen("Nguyễn Quốc Huy");
        nvgh4.setSdt("0328843156");
        nvgh4.setEmail("huynqph26782@fpt.edu.vn");
        nvgh4.setMatKhau("1");
        nvgh4.setNgaySinh(Date.valueOf("2003-04-22"));
        nvgh4.setGioiTinh(0);
        nvgh4.setTrangThai(1);
        nvgh4.setIdKhoHang(kh1);
        nvgh4.setIdKhoGiao(kh3);
        session.save(nvgh4);

// insert Khách Hàng
        KhachHang khachHang = new KhachHang();
        khachHang.setMa("KH0001");
        khachHang.setTen("Nguyễn Quốc Huy");
        khachHang.setSdt("0328843156");
        khachHang.setEmail("huynqph26782@fpt.edu.vn");
        khachHang.setMatKhau("1");
        khachHang.setNgaySinh(Date.valueOf("2003-04-22"));
        khachHang.setGioiTinh(0);
        khachHang.setDiaChi("Hà Nội");
        session.save(khachHang);

        KhachHang khachHang1 = new KhachHang();
        khachHang1.setMa("KH0002");
        khachHang1.setTen("Nguyễn Quốc Huy");
        khachHang1.setSdt("0328843156");
        khachHang1.setEmail("huynqph26782@fpt.edu.vn");
        khachHang1.setMatKhau("1");
        khachHang1.setNgaySinh(Date.valueOf("2003-04-22"));
        khachHang1.setGioiTinh(0);
        khachHang1.setDiaChi("Hà Nội");
        session.save(khachHang1);

        DonHang dh = new DonHang();
        dh.setNgayDat(Date.valueOf("2022-07-10"));
        dh.setHinhThucTT(0);
        dh.setHinhAnh("Chưa có hình ảnh");
        dh.setTenNguoiNhan("Nguyễn Văn A");
        dh.setSdtNguoiNhan("0328843156");
        dh.setIdLoaiHang(lh3);
        dh.setIdKhachHang(khachHang);
        dh.setIdKhoHangGui(kh1);
        dh.setIdKhoHangNhan(kh2);
        session.save(dh);

        DonHang dh1 = new DonHang();
        dh1.setNgayDat(Date.valueOf("2022-07-10"));
        dh1.setHinhThucTT(0);
        dh1.setHinhAnh("Chưa có hình ảnh");
        dh1.setTenNguoiNhan("Nguyễn Văn A");
        dh1.setSdtNguoiNhan("0328843156");
        dh1.setIdLoaiHang(lh3);
        dh1.setIdKhachHang(khachHang);
        dh1.setIdKhoHangGui(kh1);
        dh1.setIdKhoHangNhan(kh2);
        session.save(dh1);

        DonHang dh2 = new DonHang();
        dh2.setNgayDat(Date.valueOf("2022-07-10"));
        dh2.setHinhThucTT(0);
        dh2.setHinhAnh("Chưa có hình ảnh");
        dh2.setTenNguoiNhan("Nguyễn Văn A");
        dh2.setSdtNguoiNhan("0328843156");
        dh2.setIdLoaiHang(lh3);
        dh2.setIdKhachHang(khachHang);
        dh2.setIdKhoHangGui(kh1);
        dh2.setIdKhoHangNhan(kh2);
        session.save(dh2);

        DonHang dh3 = new DonHang();
        dh3.setNgayDat(Date.valueOf("2022-07-10"));
        dh3.setHinhThucTT(0);
        dh3.setHinhAnh("Chưa có hình ảnh");
        dh3.setTenNguoiNhan("Nguyễn Văn A");
        dh3.setSdtNguoiNhan("0328843156");
        dh3.setIdLoaiHang(lh3);
        dh3.setIdKhachHang(khachHang);
        dh3.setIdKhoHangGui(kh1);
        dh3.setIdKhoHangNhan(kh2);
        session.save(dh3);

        DonHang dh4 = new DonHang();
        dh4.setNgayDat(Date.valueOf("2022-07-10"));
        dh4.setHinhThucTT(0);
        dh4.setHinhAnh("Chưa có hình ảnh");
        dh4.setTenNguoiNhan("Nguyễn Văn A");
        dh4.setSdtNguoiNhan("0328843156");
        dh4.setIdLoaiHang(lh3);
        dh4.setIdKhachHang(khachHang);
        dh4.setIdKhoHangGui(kh1);
        dh4.setIdKhoHangNhan(kh2);
        session.save(dh4);

        DonHang dh5 = new DonHang();
        dh5.setNgayDat(Date.valueOf("2022-07-10"));
        dh5.setHinhThucTT(0);
        dh5.setHinhAnh("Chưa có hình ảnh");
        dh5.setTenNguoiNhan("Nguyễn Văn A");
        dh5.setSdtNguoiNhan("0328843156");
        dh5.setIdLoaiHang(lh3);
        dh5.setIdKhachHang(khachHang);
        dh5.setIdKhoHangGui(kh1);
        dh5.setIdKhoHangNhan(kh2);
        session.save(dh5);

        HoaDon hd1 = new HoaDon();
        hd1.setIdDonHang(dh1);
        hd1.setIdNguoiGiaoHang(nvgh3);
        hd1.setDonGia(dh1.getIdLoaiHang().getGia());
        hd1.setTrangThai(0);
        session.save(hd1);

        HoaDon hd2 = new HoaDon();
        hd2.setIdDonHang(dh2);
        hd2.setIdNguoiGiaoHang(nvgh3);
        hd2.setDonGia(dh2.getIdLoaiHang().getGia());
        hd2.setTrangThai(0);
        session.save(hd2);

        HoaDon hd3 = new HoaDon();
        hd3.setIdDonHang(dh3);
        hd3.setIdNguoiGiaoHang(nvgh3);
        hd3.setDonGia(dh3.getIdLoaiHang().getGia());
        hd3.setTrangThai(0);
        session.save(hd3);

        HoaDon hd4 = new HoaDon();
        hd4.setIdDonHang(dh4);
        hd4.setIdNguoiGiaoHang(nvgh3);
        hd4.setDonGia(dh4.getIdLoaiHang().getGia());
        hd4.setTrangThai(0);
        session.save(hd4);

        HoaDon hd5 = new HoaDon();
        hd5.setIdDonHang(dh5);
        hd5.setIdNguoiGiaoHang(nvgh3);
        hd5.setDonGia(dh5.getIdLoaiHang().getGia());
        hd5.setTrangThai(0);
        session.save(hd5);

        trans.commit();
        session.close();
    }
}
