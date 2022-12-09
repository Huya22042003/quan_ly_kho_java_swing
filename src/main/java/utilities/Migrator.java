package utilities;

import domainModels.ChiTietPhieuHoanNhap;
import domainModels.ChiTietPhieuHoanXuat;
import domainModels.ChiTietPhieuKiemKe;
import domainModels.ChiTietPhieuNhap;
import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.ChucVu;
import domainModels.DonVi;
import domainModels.KhachHang;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import domainModels.PhieuHoanNhap;
import domainModels.PhieuHoanXuat;
import domainModels.PhieuKiemKe;
import domainModels.PhieuNhap;
import domainModels.PhieuXuat;
import domainModels.SanPham;
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhachHangConstant;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;
import infrastructures.constant.TrangThaiPhieuConstant;
import infrastructures.constant.TrangThaiPhieuHoanConstant;
import infrastructures.constant.TrangThaiPhieuKiemConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
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

        DonVi dv = new DonVi();
        dv.setDonViGoc("Đôi");
        dv.setDonViQuyDoi("Thùng");
        dv.setSoLuong(50);
        session.save(dv);

        DonVi dv1 = new DonVi();
        dv1.setDonViGoc("Đôi");
        dv1.setDonViQuyDoi("Túi");
        dv1.setSoLuong(10);
        session.save(dv1);

        DonVi dv2 = new DonVi();
        dv2.setDonViGoc("Đôi");
        dv2.setDonViQuyDoi("Lô");
        dv2.setSoLuong(500);
        session.save(dv2);
        
        DonVi dv3 = new DonVi();
        dv3.setDonViGoc("Đôi");
        dv3.setDonViQuyDoi("Đôi");
        dv3.setSoLuong(1);
        session.save(dv3);

        NhanVien a = new NhanVien();
        a.setDiaChi("Hà Nội");
        a.setEmail("a");
        a.setGioiTinh(GioiTinhConstant.NAM);
        a.setHinhAnh(null);
        a.setIdChucVu(chucVu);
        a.setMa(MaTuSinh.gen("NV"));
        a.setMatKhau("1");
        a.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        a.setSdt("0328843156");
        a.setTen("Nguyễn Quốc Huy");
        a.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(a);

        NhanVien b = new NhanVien();
        b.setDiaChi("Hà Nội");
        b.setEmail("b");
        b.setGioiTinh(GioiTinhConstant.NAM);
        b.setHinhAnh(null);
        b.setIdChucVu(chucVu1);
        b.setMa(MaTuSinh.gen("NV"));
        b.setMatKhau("1");
        b.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        b.setSdt("0328843156");
        b.setTen("Nguyễn Quốc Huy");
        b.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(b);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setDiaChi("Hà Nội");
        nhanVien.setEmail("huynqph26782@fpt.edu.vn");
        nhanVien.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien.setHinhAnh(null);
        nhanVien.setIdChucVu(chucVu);
        nhanVien.setMa(MaTuSinh.gen("NV"));
        nhanVien.setMatKhau("1");
        nhanVien.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        nhanVien.setSdt("0328843156");
        nhanVien.setTen("Nguyễn Quốc Huy");
        nhanVien.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien);

        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setDiaChi("Hà Nội");
        nhanVien1.setEmail("pengoanchamhoc@gmail.com");
        nhanVien1.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien1.setHinhAnh(null);
        nhanVien1.setIdChucVu(chucVu1);
        nhanVien1.setMa(MaTuSinh.gen("NV"));
        nhanVien1.setMatKhau("1");
        nhanVien1.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        nhanVien1.setSdt("0328843156");
        nhanVien1.setTen("Nguyễn Quốc Huy");
        nhanVien1.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien1);

        NhanVien nhanVien2 = new NhanVien();
        nhanVien2.setDiaChi("Hà Nội");
        nhanVien2.setEmail("a");
        nhanVien2.setGioiTinh(GioiTinhConstant.NAM);
        nhanVien2.setHinhAnh(null);
        nhanVien2.setIdChucVu(chucVu);
        nhanVien2.setMa(MaTuSinh.gen("NV"));
        nhanVien2.setMatKhau("a");
        nhanVien2.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        nhanVien2.setSdt("0328843156");
        nhanVien2.setTen("Nguyễn Quốc Huy");
        nhanVien2.setTrangThai(TrangThaiNhanVienConstant.DANG_HOAT_DONG);
        session.save(nhanVien2);

        KhachHang kh = new KhachHang();
        kh.setDanhGia(DanhGiaConstant.TAM_ON);
        kh.setDiaChi("Hà Nội");
        kh.setEmail("taintph26788@fpt.edu.vn");
        kh.setGioiTinh(GioiTinhConstant.NAM);
        kh.setHinhAnh(null);
        kh.setMa(MaTuSinh.gen("KH"));
        kh.setMatKhau("1");
        kh.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        kh.setSdt("0327777777");
        kh.setTen("Nguyễn Tiến Tài");
        kh.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(kh);

        KhachHang kh1 = new KhachHang();
        kh1.setDanhGia(DanhGiaConstant.TAM_ON);
        kh1.setDiaChi("Hà Nội");
        kh1.setEmail("taintph26788@fpt.edu.vn");
        kh1.setGioiTinh(GioiTinhConstant.NAM);
        kh1.setHinhAnh(null);
        kh1.setMa(MaTuSinh.gen("KH"));
        kh1.setMatKhau("1");
        kh1.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        kh1.setSdt("0327777777");
        kh1.setTen("Nguyễn Văn Thắng");
        kh1.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(kh1);

        KhachHang kh2 = new KhachHang();
        kh2.setDanhGia(DanhGiaConstant.TAM_ON);
        kh2.setDiaChi("Hà Nội");
        kh2.setEmail("taintph26788@fpt.edu.vn");
        kh2.setGioiTinh(GioiTinhConstant.NAM);
        kh2.setHinhAnh(null);
        kh2.setMa(MaTuSinh.gen("KH"));
        kh2.setMatKhau("1");
        kh2.setNgaySinh(DateTimeUtil.convertDateToTimeStampSecond());
        kh2.setSdt("0327777777");
        kh2.setTen("Phạm Hải Quân");
        kh2.setTrangThai(KhachHangConstant.DANG_LAM_VIEC);
        session.save(kh2);

        NhaCungCap ncc = new NhaCungCap();
        ncc.setDanhGia(DanhGiaConstant.TAM_ON);
        ncc.setDiaChi("Hà Nội");
        ncc.setEmail("huynqph26782@fpt.edu.vn");
        ncc.setMa(MaTuSinh.gen("NCC"));
        ncc.setSdt("0321111111");
        ncc.setTen("Phạm Xuân Hải");
        ncc.setTrangThai(KhachHangConstant.SAP_BO);
        session.save(ncc);

        NhaCungCap ncc1 = new NhaCungCap();
        ncc1.setDanhGia(DanhGiaConstant.TAM_ON);
        ncc1.setDiaChi("Hà Nội");
        ncc1.setEmail("huynqph26782@fpt.edu.vn");
        ncc1.setMa(MaTuSinh.gen("NCC"));
        ncc1.setSdt("0321111111");
        ncc1.setTen("Đinh Anh Tuấn");
        ncc1.setTrangThai(KhachHangConstant.SAP_BO);
        session.save(ncc1);

        NhaCungCap ncc2 = new NhaCungCap();
        ncc2.setDanhGia(DanhGiaConstant.TAM_ON);
        ncc2.setDiaChi("Hà Nội");
        ncc2.setEmail("huynqph26782@fpt.edu.vn");
        ncc2.setMa(MaTuSinh.gen("NCC"));
        ncc2.setSdt("0321111111");
        ncc2.setTen("Nguyễn Thị Khánh Linh");
        ncc2.setTrangThai(KhachHangConstant.SAP_BO);
        session.save(ncc2);

        SanPham sanPham = new SanPham();
        sanPham.setMa(MaTuSinh.gen("SP"));
        sanPham.setTen("Giày Nike");
        session.save(sanPham);

        SanPham sanPham1 = new SanPham();
        sanPham1.setMa(MaTuSinh.gen("SP"));
        sanPham1.setTen("Giày Gucci");
        session.save(sanPham1);

        SanPham sanPham2 = new SanPham();
        sanPham2.setMa(MaTuSinh.gen("SP"));
        sanPham2.setTen("Giày Chanel");
        session.save(sanPham2);

        SanPham sanPham3 = new SanPham();
        sanPham3.setMa(MaTuSinh.gen("SP"));
        sanPham3.setTen("Giày Adidas");
        session.save(sanPham3);

        SanPham sanPham4 = new SanPham();
        sanPham4.setMa(MaTuSinh.gen("SP"));
        sanPham4.setTen("Giày abcxyz");
        session.save(sanPham4);

        SanPham sanPham5 = new SanPham();
        sanPham5.setMa(MaTuSinh.gen("SP"));
        sanPham5.setTen("Giày bata");
        session.save(sanPham5);

        SanPham sanPham6 = new SanPham();
        sanPham6.setMa(MaTuSinh.gen("SP"));
        sanPham6.setTen("Giày bata");
        session.save(sanPham6);

        SanPham sanPham7 = new SanPham();
        sanPham7.setMa(MaTuSinh.gen("SP"));
        sanPham7.setTen("Giày thượng đình");
        session.save(sanPham7);

        SanPham sanPham8 = new SanPham();
        sanPham8.setMa(MaTuSinh.gen("SP"));
        sanPham8.setTen("Giày đá bóng");
        session.save(sanPham8);

        SanPham sanPham9 = new SanPham();
        sanPham9.setMa(MaTuSinh.gen("SP"));
        sanPham9.setTen("Giày đi mưa");
        session.save(sanPham9);

        SanPham sanPham10 = new SanPham();
        sanPham10.setMa(MaTuSinh.gen("SP"));
        sanPham10.setTen("Giày snacker");
        session.save(sanPham10);
        
        SanPham sanPham11 = new SanPham();
        sanPham11.setMa(MaTuSinh.gen("SP"));
        sanPham11.setTen("Giày puma");
        session.save(sanPham11);
        
        SanPham sanPham12 = new SanPham();
        sanPham12.setMa(MaTuSinh.gen("SP"));
        sanPham12.setTen("Giày zezy");
        session.save(sanPham12);
        
        SanPham sanPham13 = new SanPham();
        sanPham13.setMa(MaTuSinh.gen("SP"));
        sanPham13.setTen("Giày cao cổ");
        session.save(sanPham13);
        
        SanPham sanPham14 = new SanPham();
        sanPham14.setMa(MaTuSinh.gen("SP"));
        sanPham14.setTen("Giày thấp cổ");
        session.save(sanPham14);
        
        SanPham sanPham15 = new SanPham();
        sanPham15.setMa(MaTuSinh.gen("SP"));
        sanPham15.setTen("Giày lười");
        session.save(sanPham15);
        
        SanPham sanPham16 = new SanPham();
        sanPham16.setMa(MaTuSinh.gen("SP"));
        sanPham16.setTen("Giày đinh");
        session.save(sanPham16);
        
        SanPham sanPham17 = new SanPham();
        sanPham17.setMa(MaTuSinh.gen("SP"));
        sanPham17.setTen("Giày avatar");
        session.save(sanPham17);
        
        SanPham sanPham18 = new SanPham();
        sanPham18.setMa(MaTuSinh.gen("SP"));
        sanPham18.setTen("Bot beautifull");
        session.save(sanPham18);
        
        SanPham sanPham19 = new SanPham();
        sanPham19.setMa(MaTuSinh.gen("SP"));
        sanPham19.setTen("Giày leo núi");
        session.save(sanPham19);
        
        SanPham sanPham20 = new SanPham();
        sanPham20.setMa(MaTuSinh.gen("SP"));
        sanPham20.setTen("Giày lười");
        session.save(sanPham20);
        
        

        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setDonVi(dv1);
        ctsp.setGiaBan(new BigDecimal(150000));
        ctsp.setGiaNhap(new BigDecimal(80000));
        ctsp.setHinhAnh(null);
        ctsp.setMau(MauConstant.DEN);
        ctsp.setNamBaoHanh(1);
        ctsp.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp.setSanPham(sanPham);
        ctsp.setSize(38);
        ctsp.setSoLuongTon(510);
        ctsp.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp);

        ChiTietSanPham ctsp1 = new ChiTietSanPham();
        ctsp1.setDonVi(dv1);
        ctsp1.setGiaBan(new BigDecimal(120000));
        ctsp1.setGiaNhap(new BigDecimal(90000));
        ctsp1.setHinhAnh(null);
        ctsp1.setMau(MauConstant.DO);
        ctsp1.setNamBaoHanh(1);
        ctsp1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp1.setSanPham(sanPham1);
        ctsp1.setSize(39);
        ctsp1.setSoLuongTon(100);
        ctsp1.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp1);

        ChiTietSanPham ctsp2 = new ChiTietSanPham();
        ctsp2.setDonVi(dv1);
        ctsp2.setGiaBan(new BigDecimal(140000));
        ctsp2.setGiaNhap(new BigDecimal(70000));
        ctsp2.setHinhAnh(null);
        ctsp2.setMau(MauConstant.HONG);
        ctsp2.setNamBaoHanh(1);
        ctsp2.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp2.setSanPham(sanPham2);
        ctsp2.setSize(40);
        ctsp2.setSoLuongTon(80);
        ctsp2.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp2);

        ChiTietSanPham ctsp3 = new ChiTietSanPham();
        ctsp3.setDonVi(dv1);
        ctsp3.setGiaBan(new BigDecimal(500000));
        ctsp3.setGiaNhap(new BigDecimal(300000));
        ctsp3.setHinhAnh(null);
        ctsp3.setMau(MauConstant.TRANG);
        ctsp3.setNamBaoHanh(1);
        ctsp3.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp3.setSanPham(sanPham3);
        ctsp3.setSize(41);
        ctsp3.setSoLuongTon(600);
        ctsp3.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp3);

        ChiTietSanPham ctsp4 = new ChiTietSanPham();
        ctsp4.setDonVi(dv1);
        ctsp4.setGiaBan(new BigDecimal(700000));
        ctsp4.setGiaNhap(new BigDecimal(650000));
        ctsp4.setHinhAnh(null);
        ctsp4.setMau(MauConstant.XANH_DUONG);
        ctsp4.setNamBaoHanh(1);
        ctsp4.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp4.setSanPham(sanPham4);
        ctsp4.setSize(42);
        ctsp4.setSoLuongTon(180);
        ctsp4.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp4);

        ChiTietSanPham ctsp5 = new ChiTietSanPham();
        ctsp5.setDonVi(dv1);
        ctsp5.setGiaBan(new BigDecimal(70000));
        ctsp5.setGiaNhap(new BigDecimal(50000));
        ctsp5.setHinhAnh(null);
        ctsp5.setMau(MauConstant.TRANG);
        ctsp5.setNamBaoHanh(1);
        ctsp5.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp5.setSanPham(sanPham5);
        ctsp5.setSize(40);
        ctsp5.setSoLuongTon(200);
        ctsp5.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp5);

        ChiTietSanPham ctsp6 = new ChiTietSanPham();
        ctsp6.setDonVi(dv1);
        ctsp6.setGiaBan(new BigDecimal(180000));
        ctsp6.setGiaNhap(new BigDecimal(150000));
        ctsp6.setHinhAnh(null);
        ctsp6.setMau(MauConstant.KHAC);
        ctsp6.setNamBaoHanh(1);
        ctsp6.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp6.setSanPham(sanPham6);
        ctsp6.setSize(42);
        ctsp6.setSoLuongTon(260);
        ctsp6.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp6);

        ChiTietSanPham ctsp7 = new ChiTietSanPham();
        ctsp7.setDonVi(dv1);
        ctsp7.setGiaBan(new BigDecimal(250000));
        ctsp7.setGiaNhap(new BigDecimal(200000));
        ctsp7.setHinhAnh(null);
        ctsp7.setMau(MauConstant.CAM);
        ctsp7.setNamBaoHanh(1);
        ctsp7.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp7.setSanPham(sanPham7);
        ctsp7.setSize(38);
        ctsp7.setSoLuongTon(340);
        ctsp7.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp7);

        ChiTietSanPham ctsp8 = new ChiTietSanPham();
        ctsp8.setDonVi(dv1);
        ctsp8.setGiaBan(new BigDecimal(650000));
        ctsp8.setGiaNhap(new BigDecimal(490000));
        ctsp8.setHinhAnh(null);
        ctsp8.setMau(MauConstant.DO);
        ctsp8.setNamBaoHanh(1);
        ctsp8.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp8.setSanPham(sanPham7);
        ctsp8.setSize(39);
        ctsp8.setSoLuongTon(160);
        ctsp8.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp8);

        ChiTietSanPham ctsp9 = new ChiTietSanPham();
        ctsp9.setDonVi(dv1);
        ctsp9.setGiaBan(new BigDecimal(10000));
        ctsp9.setGiaNhap(new BigDecimal(8000));
        ctsp9.setHinhAnh(null);
        ctsp9.setMau(MauConstant.VANG);
        ctsp9.setNamBaoHanh(1);
        ctsp9.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp9.setSanPham(sanPham9);
        ctsp9.setSize(40);
        ctsp9.setSoLuongTon(234);
        ctsp9.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp9);

        ChiTietSanPham ctsp10 = new ChiTietSanPham();
        ctsp10.setDonVi(dv1);
        ctsp10.setGiaBan(new BigDecimal(130000));
        ctsp10.setGiaNhap(new BigDecimal(90000));
        ctsp10.setHinhAnh(null);
        ctsp10.setMau(MauConstant.HONG);
        ctsp10.setNamBaoHanh(1);
        ctsp10.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp10.setSanPham(sanPham10);
        ctsp10.setSize(42);
        ctsp10.setSoLuongTon(123);
        ctsp10.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp10);

        ChiTietSanPham ctsp11 = new ChiTietSanPham();
        ctsp11.setDonVi(dv1);
        ctsp11.setGiaBan(new BigDecimal(160000));
        ctsp11.setGiaNhap(new BigDecimal(120000));
        ctsp11.setHinhAnh(null);
        ctsp11.setMau(MauConstant.XANH_DUONG);
        ctsp11.setNamBaoHanh(1);
        ctsp11.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp11.setSanPham(sanPham11);
        ctsp11.setSize(43);
        ctsp11.setSoLuongTon(456);
        ctsp11.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp11);

        ChiTietSanPham ctsp12 = new ChiTietSanPham();
        ctsp12.setDonVi(dv1);
        ctsp12.setGiaBan(new BigDecimal(80000));
        ctsp12.setGiaNhap(new BigDecimal(60000));
        ctsp12.setHinhAnh(null);
        ctsp12.setMau(MauConstant.XANH_DUONG);
        ctsp12.setNamBaoHanh(1);
        ctsp12.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp12.setSanPham(sanPham12);
        ctsp12.setSize(41);
        ctsp12.setSoLuongTon(654);
        ctsp12.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp12);

        ChiTietSanPham ctsp13 = new ChiTietSanPham();
        ctsp13.setDonVi(dv1);
        ctsp13.setGiaBan(new BigDecimal(150000));
        ctsp13.setGiaNhap(new BigDecimal(80000));
        ctsp13.setHinhAnh(null);
        ctsp13.setMau(MauConstant.VANG);
        ctsp13.setNamBaoHanh(1);
        ctsp13.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp13.setSanPham(sanPham13);
        ctsp13.setSize(38);
        ctsp13.setSoLuongTon(380);
        ctsp13.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp13);

        ChiTietSanPham ctsp14 = new ChiTietSanPham();
        ctsp14.setDonVi(dv1);
        ctsp14.setGiaBan(new BigDecimal(180000));
        ctsp14.setGiaNhap(new BigDecimal(150000));
        ctsp14.setHinhAnh(null);
        ctsp14.setMau(MauConstant.KHAC);
        ctsp14.setNamBaoHanh(1);
        ctsp14.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp14.setSanPham(sanPham14);
        ctsp14.setSize(38);
        ctsp14.setSoLuongTon(560);
        ctsp14.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp14);

        ChiTietSanPham ctsp15 = new ChiTietSanPham();
        ctsp15.setDonVi(dv1);
        ctsp15.setGiaBan(new BigDecimal(170000));
        ctsp15.setGiaNhap(new BigDecimal(150000));
        ctsp15.setHinhAnh(null);
        ctsp15.setMau(MauConstant.TRANG);
        ctsp15.setNamBaoHanh(1);
        ctsp15.setSanPham(sanPham15);
        ctsp15.setSize(41);
        ctsp15.setSoLuongTon(260);
        ctsp15.setTrangThai(TrangThaiSanPhamConstanst.CHO_XAC_NHAN);
        session.save(ctsp12);

        ChiTietSanPham ctsp16 = new ChiTietSanPham();
        ctsp16.setDonVi(dv1);
        ctsp16.setGiaBan(new BigDecimal(180000));
        ctsp16.setGiaNhap(new BigDecimal(130000));
        ctsp16.setHinhAnh(null);
        ctsp16.setMau(MauConstant.HONG);
        ctsp16.setNamBaoHanh(1);
        ctsp16.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp16.setSanPham(sanPham16);
        ctsp16.setSize(41);
        ctsp16.setSoLuongTon(700);
        ctsp16.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp16);

        ChiTietSanPham ctsp17 = new ChiTietSanPham();
        ctsp17.setDonVi(dv1);
        ctsp17.setGiaBan(new BigDecimal(100000));
        ctsp17.setGiaNhap(new BigDecimal(80000));
        ctsp17.setHinhAnh(null);
        ctsp17.setMau(MauConstant.DO);
        ctsp17.setNamBaoHanh(1);
        ctsp17.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp17.setSanPham(sanPham17);
        ctsp17.setSize(41);
        ctsp17.setSoLuongTon(150);
        ctsp17.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp17);

        ChiTietSanPham ctsp18 = new ChiTietSanPham();
        ctsp18.setDonVi(dv1);
        ctsp18.setGiaBan(new BigDecimal(110000));
        ctsp18.setGiaNhap(new BigDecimal(9000));
        ctsp18.setHinhAnh(null);
        ctsp18.setMau(MauConstant.VANG);
        ctsp18.setNamBaoHanh(18);
        ctsp18.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp18.setSanPham(sanPham1);
        ctsp18.setSize(41);
        ctsp18.setSoLuongTon(342);
        ctsp18.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp18);

        ChiTietSanPham ctsp19 = new ChiTietSanPham();
        ctsp19.setDonVi(dv1);
        ctsp19.setGiaBan(new BigDecimal(200000));
        ctsp19.setGiaNhap(new BigDecimal(80000));
        ctsp19.setHinhAnh(null);
        ctsp19.setMau(MauConstant.DEN);
        ctsp19.setNamBaoHanh(1);
        ctsp19.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp19.setSanPham(sanPham19);
        ctsp19.setSize(40);
        ctsp19.setSoLuongTon(120);
        ctsp19.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp19);

        ChiTietSanPham ctsp20 = new ChiTietSanPham();
        ctsp20.setDonVi(dv1);
        ctsp20.setGiaBan(new BigDecimal(600000));
        ctsp20.setGiaNhap(new BigDecimal(550000));
        ctsp20.setHinhAnh(null);
        ctsp20.setMau(MauConstant.CAM);
        ctsp20.setNamBaoHanh(1);
        ctsp20.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp20.setSanPham(sanPham20);
        ctsp20.setSize(42);
        ctsp20.setSoLuongTon(80);
        ctsp20.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp20);

        ChiTietSanPham ctsp21 = new ChiTietSanPham();
        ctsp21.setDonVi(dv1);
        ctsp21.setGiaBan(new BigDecimal(130000));
        ctsp21.setGiaNhap(new BigDecimal(90000));
        ctsp21.setHinhAnh(null);
        ctsp21.setMau(MauConstant.XANH_DUONG);
        ctsp21.setNamBaoHanh(1);
        ctsp21.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp21.setSanPham(sanPham11);
        ctsp21.setSize(39);
        ctsp21.setSoLuongTon(50);
        ctsp21.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp21);

        ChiTietSanPham ctsp22 = new ChiTietSanPham();
        ctsp22.setDonVi(dv1);
        ctsp22.setGiaBan(new BigDecimal(120000));
        ctsp22.setGiaNhap(new BigDecimal(100000));
        ctsp22.setHinhAnh(null);
        ctsp22.setMau(MauConstant.XANH_LA);
        ctsp22.setNamBaoHanh(1);
        ctsp22.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp22.setSanPham(sanPham11);
        ctsp22.setSize(42);
        ctsp22.setSoLuongTon(100);
        ctsp22.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp22);

        ChiTietSanPham ctsp23 = new ChiTietSanPham();
        ctsp23.setDonVi(dv1);
        ctsp23.setGiaBan(new BigDecimal(100000));
        ctsp23.setGiaNhap(new BigDecimal(80000));
        ctsp23.setHinhAnh(null);
        ctsp23.setMau(MauConstant.TRANG);
        ctsp23.setNamBaoHanh(1);
        ctsp23.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp23.setSanPham(sanPham1);
        ctsp23.setSize(42);
        ctsp23.setSoLuongTon(200);
        ctsp23.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp23);

        ChiTietSanPham ctsp24 = new ChiTietSanPham();
        ctsp24.setDonVi(dv1);
        ctsp24.setGiaBan(new BigDecimal(350000));
        ctsp24.setGiaNhap(new BigDecimal(300000));
        ctsp24.setHinhAnh(null);
        ctsp24.setMau(MauConstant.HONG);
        ctsp24.setNamBaoHanh(1);
        ctsp24.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp24.setSanPham(sanPham1);
        ctsp24.setSize(42);
        ctsp24.setSoLuongTon(40);
        ctsp24.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp24);

        ChiTietSanPham ctsp25 = new ChiTietSanPham();
        ctsp25.setDonVi(dv1);
        ctsp25.setGiaBan(new BigDecimal(600000));
        ctsp25.setGiaNhap(new BigDecimal(550000));
        ctsp25.setHinhAnh(null);
        ctsp25.setMau(MauConstant.DO);
        ctsp25.setNamBaoHanh(2);
        ctsp25.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp25.setSanPham(sanPham1);
        ctsp25.setSize(42);
        ctsp25.setSoLuongTon(200);
        ctsp25.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp25);

        ChiTietSanPham ctsp26 = new ChiTietSanPham();
        ctsp26.setDonVi(dv1);
        ctsp26.setGiaBan(new BigDecimal(700000));
        ctsp26.setGiaNhap(new BigDecimal(550000));
        ctsp26.setHinhAnh(null);
        ctsp26.setMau(MauConstant.CAM);
        ctsp26.setNamBaoHanh(1);
        ctsp26.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp26.setSanPham(sanPham1);
        ctsp26.setSize(38);
        ctsp26.setSoLuongTon(500);
        ctsp26.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp26);

        PhieuNhap pn = new PhieuNhap();
        pn.setMaPhieu(MaTuSinh.gen("PX"));
        pn.setGhiChu("Giày đẹp");
        pn.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pn.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        pn.setNhaCungCap(ncc2);
        pn.setNhanVien(nhanVien);
        pn.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(pn);

        PhieuNhap pn1 = new PhieuNhap();
        pn1.setMaPhieu(MaTuSinh.gen("PX"));
        pn1.setGhiChu("Giày đẹp");
        pn1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pn1.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        pn1.setNhaCungCap(ncc2);
        pn1.setNhanVien(nhanVien);
        pn1.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(pn1);

        PhieuNhap pn2 = new PhieuNhap();
        pn2.setMaPhieu(MaTuSinh.gen("PX"));
        pn2.setGhiChu("Giày đẹp");
        pn2.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pn2.setNhaCungCap(ncc2);
        pn2.setNhanVien(nhanVien);
        pn2.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
        session.save(pn2);

        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
        ctpn.setIdChiTietSp(ctsp);
        ctpn.setIdPhieuNhap(pn);
        ctpn.setMaSanPhamNhaCungCap(MaTuSinh.gen("SP"));
        ctpn.setSoLuong(200);
        session.save(ctpn);

        ChiTietPhieuNhap ctpn1 = new ChiTietPhieuNhap();
        ctpn1.setIdChiTietSp(ctsp1);
        ctpn1.setIdPhieuNhap(pn);
        ctpn1.setMaSanPhamNhaCungCap(MaTuSinh.gen("SP"));
        ctpn1.setSoLuong(200);
        session.save(ctpn1);

        ChiTietPhieuNhap ctpn2 = new ChiTietPhieuNhap();
        ctpn2.setIdChiTietSp(ctsp2);
        ctpn2.setIdPhieuNhap(pn1);
        ctpn2.setMaSanPhamNhaCungCap(MaTuSinh.gen("SP"));
        ctpn2.setSoLuong(200);
        session.save(ctpn2);

        ChiTietPhieuNhap ctpn3 = new ChiTietPhieuNhap();
        ctpn3.setIdChiTietSp(ctsp3);
        ctpn3.setIdPhieuNhap(pn1);
        ctpn3.setMaSanPhamNhaCungCap(MaTuSinh.gen("SP"));
        ctpn3.setSoLuong(200);
        session.save(ctpn3);

        ChiTietPhieuNhap ctpn4 = new ChiTietPhieuNhap();
        ctpn4.setIdChiTietSp(ctsp4);
        ctpn4.setIdPhieuNhap(pn2);
        ctpn4.setMaSanPhamNhaCungCap(MaTuSinh.gen("SP"));
        ctpn4.setSoLuong(200);
        session.save(ctpn4);

        PhieuHoanNhap phn = new PhieuHoanNhap();
        phn.setGhiChu("Lỗi 50 chiếc");
        phn.setLiDo("Giày lỗi");
        phn.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        phn.setPhieuNhap(pn2);
        phn.setTrangThai(TrangThaiPhieuHoanConstant.CHO_XAC_NHAN);
        session.save(phn);

        ChiTietPhieuHoanNhap ctphn = new ChiTietPhieuHoanNhap();
        ctphn.setIdChiTietSp(ctsp4);
        ctphn.setSoLuong(50);
        ctphn.setIdPhieuHoanNhap(phn);
        session.save(ctphn);

        PhieuXuat px = new PhieuXuat();
        px.setMaPhieu(MaTuSinh.gen("PX"));
        px.setGhiChu("xuất gấp");
        px.setKhachHang(kh2);
        px.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px.setNhanVien(nhanVien1);
        px.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px);

        PhieuXuat px1 = new PhieuXuat();
        px1.setMaPhieu(MaTuSinh.gen("PX"));
        px1.setGhiChu("xuất gấp");
        px1.setKhachHang(kh2);
        px1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px1.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px1.setNhanVien(nhanVien1);
        px1.setTrangThai(TrangThaiPhieuConstant.DA_HUY);
        session.save(px1);

        PhieuXuat px2 = new PhieuXuat();
        px2.setMaPhieu(MaTuSinh.gen("PX"));
        px2.setGhiChu("xuất gấp");
        px2.setKhachHang(kh2);
        px2.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px2.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px2.setNhanVien(nhanVien1);
        px2.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px2);

        PhieuXuat px3 = new PhieuXuat();
        px3.setMaPhieu(MaTuSinh.gen("PX"));
        px3.setGhiChu("xuất gấp");
        px3.setKhachHang(kh2);
        px3.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px3.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px3.setNhanVien(nhanVien1);
        px3.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px3);

        PhieuXuat px4 = new PhieuXuat();
        px4.setMaPhieu(MaTuSinh.gen("PX"));
        px4.setGhiChu("xuất gấp");
        px4.setKhachHang(kh2);
        px4.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px4.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px4.setNhanVien(nhanVien1);
        px4.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
        session.save(px4);

        PhieuXuat px5 = new PhieuXuat();
        px5.setMaPhieu(MaTuSinh.gen("PX"));
        px5.setGhiChu("xuất gấp");
        px5.setKhachHang(kh2);
        px5.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px5.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px5.setNhanVien(nhanVien1);
        px5.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
        session.save(px5);

        ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
        ctpx.setIdChiTietSp(ctsp);
        ctpx.setIdPhieuXuat(px);
        ctpx.setSoLuong(100);
        session.save(ctpx);

        ChiTietPhieuXuat ctpx1 = new ChiTietPhieuXuat();
        ctpx1.setIdChiTietSp(ctsp1);
        ctpx1.setIdPhieuXuat(px);
        ctpx1.setSoLuong(100);
        session.save(ctpx1);

        ChiTietPhieuXuat ctpx2 = new ChiTietPhieuXuat();
        ctpx2.setIdChiTietSp(ctsp);
        ctpx2.setIdPhieuXuat(px1);
        ctpx2.setSoLuong(100);
        session.save(ctpx2);

        ChiTietPhieuXuat ctpx3 = new ChiTietPhieuXuat();
        ctpx3.setIdChiTietSp(ctsp);
        ctpx3.setIdPhieuXuat(px2);
        ctpx3.setSoLuong(50);
        session.save(ctpx3);

        ChiTietPhieuXuat ctpx4 = new ChiTietPhieuXuat();
        ctpx4.setIdChiTietSp(ctsp1);
        ctpx4.setIdPhieuXuat(px2);
        ctpx4.setSoLuong(50);
        session.save(ctpx4);

        ChiTietPhieuXuat ctpx5 = new ChiTietPhieuXuat();
        ctpx5.setIdChiTietSp(ctsp2);
        ctpx5.setIdPhieuXuat(px3);
        ctpx5.setSoLuong(50);
        session.save(ctpx5);

        ChiTietPhieuXuat ctpx6 = new ChiTietPhieuXuat();
        ctpx6.setIdChiTietSp(ctsp3);
        ctpx6.setIdPhieuXuat(px4);
        ctpx6.setSoLuong(50);
        session.save(ctpx6);

        ChiTietPhieuXuat ctpx7 = new ChiTietPhieuXuat();
        ctpx7.setIdChiTietSp(ctsp2);
        ctpx7.setIdPhieuXuat(px4);
        ctpx7.setSoLuong(50);
        session.save(ctpx7);

        ChiTietPhieuXuat ctpx8 = new ChiTietPhieuXuat();
        ctpx8.setIdChiTietSp(ctsp3);
        ctpx8.setIdPhieuXuat(px5);
        ctpx8.setSoLuong(50);
        session.save(ctpx8);

        PhieuHoanXuat phx = new PhieuHoanXuat();
        phx.setGhiChu("Giày hỏng");
        phx.setLiDo("Đứt chỉ");
        phx.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        phx.setNgayThanhToan(null);
        phx.setPhieuXuat(px);
        phx.setTrangThai(TrangThaiPhieuHoanConstant.CHO_XAC_NHAN);
        session.save(phx);

        ChiTietPhieuHoanXuat ctphx = new ChiTietPhieuHoanXuat();
        ctphx.setIdChiTietSp(ctsp);
        ctphx.setIdPhieuHoanXuat(phx);
        ctphx.setSoLuong(50);
        session.save(ctphx);

        ChiTietPhieuHoanXuat ctphx1 = new ChiTietPhieuHoanXuat();
        ctphx1.setIdChiTietSp(ctsp1);
        ctphx1.setIdPhieuHoanXuat(phx);
        ctphx1.setSoLuong(50);
        session.save(ctphx1);

        PhieuKiemKe pkk = new PhieuKiemKe();
        pkk.setGhiChu("Hàng bị chuột cắn");
        pkk.setMa(MaTuSinh.gen("PKK"));
        pkk.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pkk.setNgayXacNhan(DateTimeUtil.convertDateToTimeStampSecond());
        pkk.setNhanVien(nhanVien);
        pkk.setTrangThai(TrangThaiPhieuKiemConstant.DA_XAC_NHAN);
        session.save(pkk);

        ChiTietPhieuKiemKe ctpkk = new ChiTietPhieuKiemKe();
        ctpkk.setIdChiTietSp(ctsp);
        ctpkk.setIdPhieuKiemKe(pkk);
        ctpkk.setSoLuongThucTon(50);
        ctpkk.setSoLuongTon(50);
        session.save(ctpkk);

        trans.commit();
        session.close();
    }
}
