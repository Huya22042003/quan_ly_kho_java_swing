/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import domainModels.ChiTietPhieuHoanNhap;
import domainModels.ChiTietPhieuHoanXuat;
import domainModels.ChiTietPhieuNhap;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.ChucVu;
import domainModels.CoSo;
import domainModels.DonVi;
import domainModels.KhachHang;
import domainModels.NamBaoHanh;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import domainModels.PhieuHoanNhap;
import domainModels.PhieuHoanXuat;
import domainModels.PhieuNhap;
import domainModels.PhieuXuat;
import domainModels.SanPham;
import infrastructures.constant.CoSoConstant;
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhachHangConstant;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import static utilities.DateTimeUtil.convertDateToTimeStampSecond;

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
        nhanVien.setTen("Phạm Xuân Hải");
        nhanVien.setDiaChi("Hà Nội");
        nhanVien.setEmail("a");
        nhanVien.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien.setHinhAnh(null);
        nhanVien.setIdChucVu(chucVu);
        nhanVien.setMatKhau("a");
        nhanVien.setNgaySinh(convertDateToTimeStampSecond());
        nhanVien.setSdt("0328843156");
        nhanVien.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien);
        
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setMa("NV00002");
        nhanVien1.setTen("Nguyễn Quốc Huy");
        nhanVien1.setDiaChi("Hà Nội");
        nhanVien1.setEmail("b");
        nhanVien1.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien1.setHinhAnh(null);
        nhanVien1.setIdChucVu(chucVu);
        nhanVien1.setMatKhau("1");
        nhanVien1.setNgaySinh(convertDateToTimeStampSecond());
        nhanVien1.setSdt("0328843156");
        nhanVien1.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien1);
        
        NhanVien nhanVien2 = new NhanVien();
        nhanVien2.setMa("NV00003");
        nhanVien2.setTen("Nguyễn Quốc Huy");
        nhanVien2.setDiaChi("Hà Nội");
        nhanVien2.setEmail("c");
        nhanVien2.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien2.setHinhAnh(null);
        nhanVien2.setIdChucVu(chucVu1);
        nhanVien2.setMatKhau("1");
        nhanVien2.setNgaySinh(convertDateToTimeStampSecond());
        nhanVien2.setSdt("0328843156");
        nhanVien2.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien2);
        
        NhanVien nhanVien3 = new NhanVien();
        nhanVien3.setMa("NV00004");
        nhanVien3.setTen("Nguyễn Quốc Huy");
        nhanVien3.setDiaChi("Hà Nội");
        nhanVien3.setEmail("huynqph26782@fpt.edu.vn");
        nhanVien3.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien3.setHinhAnh(null);
        nhanVien3.setIdChucVu(chucVu2);
        nhanVien3.setMatKhau("1");
        nhanVien3.setNgaySinh(convertDateToTimeStampSecond());
        nhanVien3.setSdt("0328843156");
        nhanVien3.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien3);
        
        NhanVien nhanVien4 = new NhanVien();
        nhanVien4.setMa("NV00005");
        nhanVien4.setTen("Nguyễn Quốc Huy");
        nhanVien4.setDiaChi("Hà Nội");
        nhanVien4.setEmail("huynqph26782@fpt.edu.vn");
        nhanVien4.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien4.setHinhAnh(null);
        nhanVien4.setIdChucVu(chucVu2);
        nhanVien4.setMatKhau("1");
        nhanVien4.setNgaySinh(convertDateToTimeStampSecond());
        nhanVien4.setSdt("0328843156");
        nhanVien4.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien4);
        
        KhachHang khachHang = new KhachHang();
        khachHang.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang.setDiaChi("Hà Nội");
        khachHang.setEmail("huynqph26782@fpt.edu.vn");
        khachHang.setGioiTinh(GioiTinhConstant.NAM);
        khachHang.setHinhAnh(null);
        khachHang.setMa("KH000001");
        khachHang.setMatKhau("1");
        khachHang.setNgaySinh(convertDateToTimeStampSecond());
        khachHang.setSdt("0328843156");
        khachHang.setTen("Nguyễn Quốc Huy");
        khachHang.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang);
        
        KhachHang khachHang1 = new KhachHang();
        khachHang1.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang1.setDiaChi("Hà Nội");
        khachHang1.setEmail("huynqph26782@fpt.edu.vn");
        khachHang1.setGioiTinh(GioiTinhConstant.NAM);
        khachHang1.setHinhAnh(null);
        khachHang1.setMa("KH000002");
        khachHang1.setMatKhau("1");
        khachHang1.setNgaySinh(convertDateToTimeStampSecond());
        khachHang1.setSdt("0328843156");
        khachHang1.setTen("Nguyễn Quốc Huy");
        khachHang1.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang1);
        
        KhachHang khachHang2 = new KhachHang();
        khachHang2.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang2.setDiaChi("Hà Nội");
        khachHang2.setEmail("huynqph26782@fpt.edu.vn");
        khachHang2.setGioiTinh(GioiTinhConstant.NAM);
        khachHang2.setHinhAnh(null);
        khachHang2.setMa("KH000003");
        khachHang2.setMatKhau("1");
        khachHang2.setNgaySinh(convertDateToTimeStampSecond());
        khachHang2.setSdt("0328843156");
        khachHang2.setTen("Nguyễn Quốc Huy");
        khachHang2.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang2);
        
        KhachHang khachHang3 = new KhachHang();
        khachHang3.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang3.setDiaChi("Hà Nội");
        khachHang3.setEmail("huynqph26782@fpt.edu.vn");
        khachHang3.setGioiTinh(GioiTinhConstant.NAM);
        khachHang3.setHinhAnh(null);
        khachHang3.setMa("KH000004");
        khachHang3.setMatKhau("1");
        khachHang3.setNgaySinh(convertDateToTimeStampSecond());
        khachHang3.setSdt("0328843156");
        khachHang3.setTen("Nguyễn Quốc Huy");
        khachHang3.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang3);
        
        KhachHang khachHang4 = new KhachHang();
        khachHang4.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang4.setDiaChi("Hà Nội");
        khachHang4.setEmail("huynqph26782@fpt.edu.vn");
        khachHang4.setGioiTinh(GioiTinhConstant.NAM);
        khachHang4.setHinhAnh(null);
        khachHang4.setMa("KH000005");
        khachHang4.setMatKhau("1");
        khachHang4.setNgaySinh(convertDateToTimeStampSecond());
        khachHang4.setSdt("0328843156");
        khachHang4.setTen("Nguyễn Quốc Huy");
        khachHang4.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang4);
        
        KhachHang khachHang5 = new KhachHang();
        khachHang5.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang5.setDiaChi("Hà Nội");
        khachHang5.setEmail("huynqph26782@fpt.edu.vn");
        khachHang5.setGioiTinh(GioiTinhConstant.NAM);
        khachHang5.setHinhAnh(null);
        khachHang5.setMa("KH000006");
        khachHang5.setMatKhau("1");
        khachHang5.setNgaySinh(convertDateToTimeStampSecond());
        khachHang5.setSdt("0328843156");
        khachHang5.setTen("Nguyễn Quốc Huy");
        khachHang5.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang5);
        
        KhachHang khachHang6 = new KhachHang();
        khachHang6.setDanhGia(DanhGiaConstant.TAM_ON);
        khachHang6.setDiaChi("Hà Nội");
        khachHang6.setEmail("huynqph26782@fpt.edu.vn");
        khachHang6.setGioiTinh(GioiTinhConstant.NAM);
        khachHang6.setHinhAnh(null);
        khachHang6.setMa("KH000007");
        khachHang6.setMatKhau("1");
        khachHang6.setNgaySinh(convertDateToTimeStampSecond());
        khachHang6.setSdt("0328843156");
        khachHang6.setTen("Nguyễn Quốc Huy");
        khachHang6.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(khachHang6);
        
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap.setDiaChi("Hà Nội");
        nhaCungCap.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap.setMa("NCC00001");
        nhaCungCap.setSdt("0328843156");
        nhaCungCap.setTen("Nguyễn Quốc Huy");
        nhaCungCap.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap);
        
        NhaCungCap nhaCungCap1 = new NhaCungCap();
        nhaCungCap1.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap1.setDiaChi("Hà Nội");
        nhaCungCap1.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap1.setMa("NCC00002");
        nhaCungCap1.setSdt("0328843156");
        nhaCungCap1.setTen("Nguyễn Quốc Huy");
        nhaCungCap1.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap1);
        
        NhaCungCap nhaCungCap2 = new NhaCungCap();
        nhaCungCap2.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap2.setDiaChi("Hà Nội");
        nhaCungCap2.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap2.setMa("NCC00003");
        nhaCungCap2.setSdt("0328843156");
        nhaCungCap2.setTen("Nguyễn Quốc Huy");
        nhaCungCap2.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap2);
        
        NhaCungCap nhaCungCap3 = new NhaCungCap();
        nhaCungCap3.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap3.setDiaChi("Hà Nội");
        nhaCungCap3.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap3.setMa("NCC00004");
        nhaCungCap3.setSdt("0328843156");
        nhaCungCap3.setTen("Nguyễn Quốc Huy");
        nhaCungCap3.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap3);
        
        NhaCungCap nhaCungCap4 = new NhaCungCap();
        nhaCungCap4.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap4.setDiaChi("Hà Nội");
        nhaCungCap4.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap4.setMa("NCC00005");
        nhaCungCap4.setSdt("0328843156");
        nhaCungCap4.setTen("Nguyễn Quốc Huy");
        nhaCungCap4.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap4);
        
        NhaCungCap nhaCungCap5 = new NhaCungCap();
        nhaCungCap5.setDanhGia(DanhGiaConstant.TAM_ON);
        nhaCungCap5.setDiaChi("Hà Nội");
        nhaCungCap5.setEmail("huynqph26782@fpt.edu.vn");
        nhaCungCap5.setMa("NCC00006");
        nhaCungCap5.setSdt("0328843156");
        nhaCungCap5.setTen("Nguyễn Quốc Huy");
        nhaCungCap5.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(nhaCungCap5);
        
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setGhiChu("");
        phieuNhap.setNgayTao(convertDateToTimeStampSecond());
        phieuNhap.setNhaCungCap(nhaCungCap);
        phieuNhap.setNhanVien(nhanVien);
        phieuNhap.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuNhap.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(phieuNhap);
        
        PhieuNhap phieuNhap1 = new PhieuNhap();
        phieuNhap1.setGhiChu("");
        phieuNhap.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuNhap.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuNhap1.setNgayTao(convertDateToTimeStampSecond());
        phieuNhap1.setNhaCungCap(nhaCungCap);
        phieuNhap1.setNhanVien(nhanVien1);
        session.save(nhanVien);
        
        PhieuNhap phieuNhap2 = new PhieuNhap();
        phieuNhap2.setGhiChu("");
        phieuNhap.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuNhap.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuNhap2.setNgayTao(convertDateToTimeStampSecond());
        phieuNhap2.setNhaCungCap(nhaCungCap);
        phieuNhap2.setNhanVien(nhanVien);
        session.save(phieuNhap2);
        
        PhieuNhap phieuNhap3 = new PhieuNhap();
        phieuNhap3.setGhiChu("");
        phieuNhap.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuNhap.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuNhap3.setNgayTao(convertDateToTimeStampSecond());
        phieuNhap3.setNhaCungCap(nhaCungCap);
        phieuNhap3.setNhanVien(nhanVien);
        session.save(phieuNhap3);
        
        PhieuNhap phieuNhap4 = new PhieuNhap();
        phieuNhap4.setGhiChu("");
        phieuNhap.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuNhap.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuNhap4.setNgayTao(convertDateToTimeStampSecond());
        phieuNhap4.setNhaCungCap(nhaCungCap);
        phieuNhap4.setNhanVien(nhanVien);
        session.save(phieuNhap4);
        
        PhieuXuat phieuXuat = new PhieuXuat();
        phieuXuat.setGhiChu("");
        phieuXuat.setKhachHang(khachHang);
        phieuXuat.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuXuat.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuat.setNgayTao(convertDateToTimeStampSecond());
        phieuXuat.setNhanVien(nhanVien1);
        session.save(phieuXuat);
        
        PhieuXuat phieuXuat1 = new PhieuXuat();
        phieuXuat1.setGhiChu("");
        phieuXuat1.setKhachHang(khachHang);
        phieuXuat1.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuXuat1.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuat1.setNgayTao(convertDateToTimeStampSecond());
        phieuXuat1.setNhanVien(nhanVien1);
        session.save(phieuXuat1);
        
        PhieuXuat phieuXuat2 = new PhieuXuat();
        phieuXuat2.setGhiChu("");
        phieuXuat2.setKhachHang(khachHang);
        phieuXuat2.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuXuat2.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuat2.setNgayTao(convertDateToTimeStampSecond());
        phieuXuat2.setNhanVien(nhanVien1);
        session.save(phieuXuat2);
        
        PhieuXuat phieuXuat3 = new PhieuXuat();
        phieuXuat3.setGhiChu("");
        phieuXuat3.setKhachHang(khachHang);
        phieuXuat3.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuXuat3.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuat3.setNgayTao(convertDateToTimeStampSecond());
        phieuXuat3.setNhanVien(nhanVien1);
        session.save(phieuXuat3);
        
        PhieuXuat phieuXuat4 = new PhieuXuat();
        phieuXuat4.setGhiChu("");
        phieuXuat4.setKhachHang(khachHang);
        phieuXuat4.setNgayThanhToan(convertDateToTimeStampSecond());
        phieuXuat4.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        phieuXuat4.setNgayTao(convertDateToTimeStampSecond());
        phieuXuat4.setNhanVien(nhanVien1);
        session.save(phieuXuat4);
        
        DonVi donVi = new DonVi();
        donVi.setSoLuong(0);
        donVi.setDonViGoc("VND");
        donVi.setDonViQuyDoi("VND");
        session.save(donVi);
        
        DonVi donVi1 = new DonVi();
        donVi1.setSoLuong(0);
        donVi1.setDonViGoc("CM3");
        donVi1.setDonViQuyDoi("M3");
        session.save(donVi1);
        
        DonVi donVi2 = new DonVi();
        donVi2.setSoLuong(0);
        donVi2.setDonViGoc("CM2");
        donVi2.setDonViQuyDoi("M2");
        session.save(donVi2);
        
        NamBaoHanh namBaoHanh = new NamBaoHanh();
        namBaoHanh.setMa("NBH00001");
        namBaoHanh.setTen("Năm 1");
        session.save(namBaoHanh);
        
        NamBaoHanh namBaoHanh1 = new NamBaoHanh();
        namBaoHanh1.setMa("NBH00002");
        namBaoHanh1.setTen("Năm 2");
        session.save(namBaoHanh1);
        
        SanPham sanPham = new SanPham();
        sanPham.setMa("SP00001");
        sanPham.setTen("Giày a di đát");
        session.save(sanPham);
        
        SanPham sanPham1 = new SanPham();
        sanPham1.setMa("SP00002");
        sanPham1.setTen("Giày Gucci");
        session.save(sanPham1);
        
        SanPham sanPham2 = new SanPham();
        sanPham2.setMa("SP00003");
        sanPham2.setTen("Tông Lào");
        session.save(sanPham2);
        
        SanPham sanPham3 = new SanPham();
        sanPham3.setMa("SP00004");
        sanPham3.setTen("Giày Ba ta");
        session.save(sanPham3);
        
        SanPham sanPham4 = new SanPham();
        sanPham4.setMa("SP00005");
        sanPham4.setTen("Giày da");
        session.save(sanPham4);
        
        SanPham sanPham5 = new SanPham();
        sanPham5.setMa("SP00006");
        sanPham5.setTen("Giày lười");
        session.save(sanPham5);
        
        SanPham sanPham6 = new SanPham();
        sanPham6.setMa("SP00007");
        sanPham6.setTen("Giày Deadline");
        session.save(sanPham6);
        
        SanPham sanPham7 = new SanPham();
        sanPham7.setMa("SP00008");
        sanPham7.setTen("Giày giấy");
        session.save(sanPham7);
        
        SanPham sanPham8 = new SanPham();
        sanPham8.setMa("SP00009");
        sanPham8.setTen("Giày bao hỏng");
        session.save(sanPham8);
        
        SanPham sanPham9 = new SanPham();
        sanPham9.setMa("SP00010");
        sanPham9.setTen("Giày kiên cường");
        session.save(sanPham9);
        
        SanPham sanPham10 = new SanPham();
        sanPham10.setMa("SP00011");
        sanPham10.setTen("Giày cơ động");
        session.save(sanPham10);
        
        SanPham sanPham11 = new SanPham();
        sanPham11.setMa("SP00012");
        sanPham11.setTen("Giày khai sáng lonia");
        session.save(sanPham11);
        
        SanPham sanPham12 = new SanPham();
        sanPham12.setMa("SP00013");
        sanPham12.setTen("Giày cuồng nộ");
        session.save(sanPham12);
        
        SanPham sanPham13 = new SanPham();
        sanPham13.setMa("SP00014");
        sanPham13.setTen("Giày bạc");
        session.save(sanPham13);
        
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setDonVi(donVi);
        ctsp.setGiaBan(new BigDecimal(10000000));
        ctsp.setGiaNhap(new BigDecimal(100000000));
        ctsp.setHinhAnh(null);
        ctsp.setNamBaoHanh(namBaoHanh);
        ctsp.setMau(MauConstant.DEN);
        ctsp.setSanPham(sanPham);
        ctsp.setSoLuongTon(100);
        session.save(ctsp);

        ChiTietSanPham ctsp1 = new ChiTietSanPham();
        ctsp1.setDonVi(donVi);
        ctsp1.setGiaBan(new BigDecimal(10000000));
        ctsp1.setGiaNhap(new BigDecimal(100000000));
        ctsp1.setHinhAnh(null);
        ctsp1.setNamBaoHanh(namBaoHanh);
        ctsp1.setSanPham(sanPham);
        ctsp.setMau(MauConstant.DEN);
        ctsp1.setSoLuongTon(100);
        session.save(ctsp1);
        
        ChiTietSanPham ctsp2 = new ChiTietSanPham();
        ctsp2.setDonVi(donVi);
        ctsp2.setGiaBan(new BigDecimal(10000000));
        ctsp2.setGiaNhap(new BigDecimal(100000000));
        ctsp2.setHinhAnh(null);
        ctsp.setMau(MauConstant.DEN);
        ctsp2.setNamBaoHanh(namBaoHanh);
        ctsp2.setSanPham(sanPham12);
        ctsp2.setSoLuongTon(100);
        session.save(ctsp2);
        
        ChiTietSanPham ctsp3 = new ChiTietSanPham();
        ctsp3.setDonVi(donVi);
        ctsp3.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp3.setGiaNhap(new BigDecimal(100000000));
        ctsp3.setHinhAnh(null);
        ctsp3.setNamBaoHanh(namBaoHanh);
        ctsp3.setSanPham(sanPham3);
        ctsp3.setSoLuongTon(100);
        session.save(ctsp3);
        
        ChiTietSanPham ctsp4 = new ChiTietSanPham();
        ctsp4.setDonVi(donVi);
        ctsp4.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp4.setGiaNhap(new BigDecimal(100000000));
        ctsp4.setHinhAnh(null);
        ctsp4.setNamBaoHanh(namBaoHanh);
        ctsp4.setSanPham(sanPham6);
        ctsp4.setSoLuongTon(100);
        session.save(ctsp4);
        
        ChiTietSanPham ctsp5 = new ChiTietSanPham();
        ctsp5.setDonVi(donVi);
        ctsp5.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp5.setGiaNhap(new BigDecimal(100000000));
        ctsp5.setHinhAnh(null);
        ctsp5.setNamBaoHanh(namBaoHanh);
        ctsp5.setSanPham(sanPham5);
        ctsp5.setSoLuongTon(100);
        session.save(ctsp5);
        
        ChiTietSanPham ctsp6 = new ChiTietSanPham();
        ctsp6.setDonVi(donVi);
        ctsp6.setGiaBan(new BigDecimal(10000000));
        ctsp6.setGiaNhap(new BigDecimal(100000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp6.setHinhAnh(null);
        ctsp6.setNamBaoHanh(namBaoHanh);
        ctsp6.setSanPham(sanPham8);
        ctsp6.setSoLuongTon(100);
        session.save(ctsp6);
        
        ChiTietSanPham ctsp7 = new ChiTietSanPham();
        ctsp7.setDonVi(donVi);
        ctsp7.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp7.setGiaNhap(new BigDecimal(100000000));
        ctsp7.setHinhAnh(null);
        ctsp7.setNamBaoHanh(namBaoHanh);
        ctsp7.setSanPham(sanPham8);
        ctsp7.setSoLuongTon(100);
        session.save(ctsp7);
        
        ChiTietSanPham ctsp8 = new ChiTietSanPham();
        ctsp8.setDonVi(donVi);
        ctsp8.setGiaBan(new BigDecimal(10000000));
        ctsp8.setGiaNhap(new BigDecimal(100000000));
        ctsp8.setHinhAnh(null);
        ctsp8.setNamBaoHanh(namBaoHanh);
        ctsp8.setSanPham(sanPham9);
        ctsp.setMau(MauConstant.DEN);
        ctsp8.setSoLuongTon(100);
        session.save(ctsp8);
        
        ChiTietSanPham ctsp9 = new ChiTietSanPham();
        ctsp9.setDonVi(donVi);
        ctsp9.setGiaBan(new BigDecimal(10000000));
        ctsp9.setGiaNhap(new BigDecimal(100000000));
        ctsp9.setHinhAnh(null);
        ctsp.setMau(MauConstant.DEN);
        ctsp9.setNamBaoHanh(namBaoHanh);
        ctsp9.setSanPham(sanPham5);
        ctsp9.setSoLuongTon(100);
        session.save(ctsp9);
        
        ChiTietSanPham ctsp10 = new ChiTietSanPham();
        ctsp10.setDonVi(donVi);
        ctsp10.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp10.setGiaNhap(new BigDecimal(100000000));
        ctsp10.setHinhAnh(null);
        ctsp10.setNamBaoHanh(namBaoHanh);
        ctsp10.setSanPham(sanPham);
        ctsp10.setSoLuongTon(100);
        session.save(ctsp10);
        
        ChiTietSanPham ctsp11 = new ChiTietSanPham();
        ctsp11.setDonVi(donVi);
        ctsp11.setGiaBan(new BigDecimal(10000000));
        ctsp11.setGiaNhap(new BigDecimal(100000000));
        ctsp11.setHinhAnh(null);
        ctsp11.setNamBaoHanh(namBaoHanh);
        ctsp.setMau(MauConstant.DEN);
        ctsp11.setSanPham(sanPham2);
        ctsp11.setSoLuongTon(100);
        session.save(ctsp11);
        
        ChiTietSanPham ctsp12 = new ChiTietSanPham();
        ctsp12.setDonVi(donVi);
        ctsp12.setGiaBan(new BigDecimal(10000000));
        ctsp12.setGiaNhap(new BigDecimal(100000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp12.setHinhAnh(null);
        ctsp12.setNamBaoHanh(namBaoHanh);
        ctsp12.setSanPham(sanPham4);
        ctsp12.setSoLuongTon(100);
        session.save(ctsp12);
        
        ChiTietSanPham ctsp13 = new ChiTietSanPham();
        ctsp13.setDonVi(donVi);
        ctsp13.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp13.setGiaNhap(new BigDecimal(100000000));
        ctsp13.setHinhAnh(null);
        ctsp13.setNamBaoHanh(namBaoHanh);
        ctsp13.setSanPham(sanPham6);
        ctsp13.setSoLuongTon(100);
        session.save(ctsp13);
        
        ChiTietSanPham ctsp14 = new ChiTietSanPham();
        ctsp14.setDonVi(donVi);
        ctsp14.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp14.setGiaNhap(new BigDecimal(100000000));
        ctsp14.setHinhAnh(null);
        ctsp14.setNamBaoHanh(namBaoHanh);
        ctsp14.setSanPham(sanPham7);
        ctsp14.setSoLuongTon(-100);
        session.save(ctsp14);
        
        ChiTietSanPham ctsp15 = new ChiTietSanPham();
        ctsp15.setDonVi(donVi);
        ctsp15.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp15.setGiaNhap(new BigDecimal(100000000));
        ctsp15.setHinhAnh(null);
        ctsp15.setNamBaoHanh(namBaoHanh);
        ctsp15.setSanPham(sanPham8);
        ctsp15.setSoLuongTon(-100);
        session.save(ctsp15);
        
        ChiTietSanPham ctsp16 = new ChiTietSanPham();
        ctsp16.setDonVi(donVi);
        ctsp16.setGiaBan(new BigDecimal(10000000));
        ctsp16.setGiaNhap(new BigDecimal(100000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp16.setHinhAnh(null);
        ctsp16.setNamBaoHanh(namBaoHanh);
        ctsp16.setSanPham(sanPham5);
        ctsp16.setSoLuongTon(-100);
        session.save(ctsp16);
        
        ChiTietSanPham ctsp17 = new ChiTietSanPham();
        ctsp17.setDonVi(donVi);
        ctsp17.setGiaBan(new BigDecimal(10000000));
        ctsp17.setGiaNhap(new BigDecimal(100000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp17.setHinhAnh(null);
        ctsp17.setNamBaoHanh(namBaoHanh);
        ctsp17.setSanPham(sanPham3);
        ctsp17.setSoLuongTon(-100);
        session.save(ctsp17);
        
        ChiTietSanPham ctsp18 = new ChiTietSanPham();
        ctsp18.setDonVi(donVi);
        ctsp18.setGiaBan(new BigDecimal(10000000));
        ctsp18.setGiaNhap(new BigDecimal(100000000));
        ctsp18.setHinhAnh(null);
        ctsp.setMau(MauConstant.DEN);
        ctsp18.setNamBaoHanh(namBaoHanh);
        ctsp18.setSanPham(sanPham9);
        ctsp18.setSoLuongTon(-100);
        session.save(ctsp18);
        
        ChiTietSanPham ctsp19 = new ChiTietSanPham();
        ctsp19.setDonVi(donVi);
        ctsp19.setGiaBan(new BigDecimal(10000000));
        ctsp.setMau(MauConstant.DEN);
        ctsp19.setGiaNhap(new BigDecimal(100000000));
        ctsp19.setHinhAnh(null);
        ctsp19.setNamBaoHanh(namBaoHanh);
        ctsp19.setSanPham(sanPham6);
        ctsp19.setSoLuongTon(-100);
        session.save(ctsp19);
        
        ChiTietSanPham ctsp20 = new ChiTietSanPham();
        ctsp20.setDonVi(donVi);
        ctsp20.setGiaBan(new BigDecimal(10000000));
        ctsp20.setGiaNhap(new BigDecimal(100000000));
        ctsp20.setHinhAnh(null);
        ctsp20.setNamBaoHanh(namBaoHanh);
        ctsp20.setSanPham(sanPham3);
        ctsp.setMau(MauConstant.DEN);
        ctsp20.setSoLuongTon(-100);
        session.save(ctsp20);
        
        ChiTietSanPham ctsp21 = new ChiTietSanPham();
        ctsp21.setDonVi(donVi);
        ctsp21.setGiaBan(new BigDecimal(10000000));
        ctsp21.setGiaNhap(new BigDecimal(100000000));
        ctsp21.setHinhAnh(null);
        ctsp21.setNamBaoHanh(namBaoHanh);
        ctsp.setMau(MauConstant.DEN);
        ctsp21.setSanPham(sanPham7);
        ctsp21.setSoLuongTon(-100);
        session.save(ctsp21);
        
        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
        ctpn.setIdChiTietSp(ctsp);
        ctpn.setIdPhieuNhap(phieuNhap);
        ctpn.setSoLuong(100);
        session.save(ctpn);
        
        ChiTietPhieuNhap ctpn1 = new ChiTietPhieuNhap();
        ctpn1.setIdChiTietSp(ctsp4);
        ctpn1.setIdPhieuNhap(phieuNhap3);
        ctpn1.setSoLuong(100);
        session.save(ctpn1);
       
        ChiTietPhieuNhap ctpn2 = new ChiTietPhieuNhap();
        ctpn2.setIdChiTietSp(ctsp3);
        ctpn2.setIdPhieuNhap(phieuNhap2);
        ctpn2.setSoLuong(100);
        session.save(ctpn2);
        
        ChiTietPhieuNhap ctpn3 = new ChiTietPhieuNhap();
        ctpn3.setIdChiTietSp(ctsp14);
        ctpn3.setIdPhieuNhap(phieuNhap);
        ctpn3.setSoLuong(100);
        session.save(ctpn);
        
        ChiTietPhieuNhap ctpn4 = new ChiTietPhieuNhap();
        ctpn4.setIdChiTietSp(ctsp9);
        ctpn4.setIdPhieuNhap(phieuNhap);
        ctpn4.setSoLuong(100);
        session.save(ctpn4);
        
        ChiTietPhieuNhap ctpn5 = new ChiTietPhieuNhap();
        ctpn5.setIdChiTietSp(ctsp2);
        ctpn5.setIdPhieuNhap(phieuNhap3);
        ctpn5.setSoLuong(100);
        session.save(ctpn5);
        
        ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
        ctpx.setIdChiTietSp(ctsp21);
        ctpx.setIdPhieuXuat(phieuXuat2);
        ctpx.setSoLuong(100);
        session.save(ctpx);
        
        ChiTietPhieuXuat ctpx1 = new ChiTietPhieuXuat();
        ctpx1.setIdChiTietSp(ctsp20);
        ctpx1.setIdPhieuXuat(phieuXuat);
        ctpx1.setSoLuong(100);
        session.save(ctpx1);
        
        ChiTietPhieuXuat ctpx2 = new ChiTietPhieuXuat();
        ctpx2.setIdChiTietSp(ctsp19);
        ctpx2.setIdPhieuXuat(phieuXuat1);
        ctpx2.setSoLuong(100);
        session.save(ctpx2);
        
        ChiTietPhieuXuat ctpx3 = new ChiTietPhieuXuat();
        ctpx3.setIdChiTietSp(ctsp18);
        ctpx3.setIdPhieuXuat(phieuXuat);
        ctpx3.setSoLuong(100);
        session.save(ctpx3);
        
        ChiTietPhieuXuat ctpx4 = new ChiTietPhieuXuat();
        ctpx4.setIdChiTietSp(ctsp17);
        ctpx4.setIdPhieuXuat(phieuXuat);
        ctpx4.setSoLuong(100);
        session.save(ctpx4);
        
        ChiTietPhieuXuat ctpx5 = new ChiTietPhieuXuat();
        ctpx5.setIdChiTietSp(ctsp16);
        ctpx5.setIdPhieuXuat(phieuXuat);
        ctpx5.setSoLuong(100);
        session.save(ctpx5);
        
        PhieuHoanNhap phn = new PhieuHoanNhap();
        phn.setGhiChu("Đồ chán");
        phn.setNgayTao(convertDateToTimeStampSecond());
        phn.setPhieuNhap(phieuNhap);
        session.save(phn);
        
        ChiTietPhieuHoanNhap ctphn = new ChiTietPhieuHoanNhap();
        ctphn.setIdPhieuHoanNhap(phn);
        ctphn.setIdChiTietSp(ctsp14);
        ctphn.setSoLuong(100);
        session.save(ctphn);
        
        PhieuHoanXuat phx = new PhieuHoanXuat();
        phx.setGhiChu("Thích thì hoàn");
        phx.setNgayTao(convertDateToTimeStampSecond());
        phx.setPhieuXuat(phieuXuat);
        session.save(phx);
        
        ChiTietPhieuHoanXuat ctphx = new ChiTietPhieuHoanXuat();
        ctphx.setIdPhieuHoanXuat(phx);
        ctphx.setIdChiTietSp(ctsp6);
        session.save(ctphx);
        
        
        trans.commit();
        session.close();
    }
}
