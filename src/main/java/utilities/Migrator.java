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
        dv.setSoLuong(10);
        session.save(dv);

        DonVi dv1 = new DonVi();
        dv1.setDonViGoc("Đôi");
        dv1.setDonViQuyDoi("Túi");
        dv1.setSoLuong(100);
        session.save(dv1);
        
        DonVi dv2 = new DonVi();
        dv2.setDonViGoc("Đôi");
        dv2.setDonViQuyDoi("Lô");
        dv2.setSoLuong(1000);
        session.save(dv2);
        
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
        
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setDonVi(dv1);
        ctsp.setGiaBan(new BigDecimal(10000));
        ctsp.setGiaNhap(new BigDecimal(8000));
        ctsp.setHinhAnh(null);
        ctsp.setMau(MauConstant.DEN);
        ctsp.setNamBaoHanh(1);
        ctsp.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp.setSanPham(sanPham);
        ctsp.setSize(38);
        ctsp.setSoLuongTon(50);
        ctsp.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp);
        
        ChiTietSanPham ctsp1 = new ChiTietSanPham();
        ctsp1.setDonVi(dv1);
        ctsp1.setGiaBan(new BigDecimal(10000));
        ctsp1.setGiaNhap(new BigDecimal(8000));
        ctsp1.setHinhAnh(null);
        ctsp1.setMau(MauConstant.DEN);
        ctsp1.setNamBaoHanh(1);
        ctsp1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp1.setSanPham(sanPham1);
        ctsp1.setSize(38);
        ctsp1.setSoLuongTon(100);
        ctsp1.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp1);
        
        ChiTietSanPham ctsp2 = new ChiTietSanPham();
        ctsp2.setDonVi(dv1);
        ctsp2.setGiaBan(new BigDecimal(10000));
        ctsp2.setGiaNhap(new BigDecimal(8000));
        ctsp2.setHinhAnh(null);
        ctsp2.setMau(MauConstant.DEN);
        ctsp2.setNamBaoHanh(1);
        ctsp2.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp2.setSanPham(sanPham2);
        ctsp2.setSize(38);
        ctsp2.setSoLuongTon(100);
        ctsp2.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp2);
        
        ChiTietSanPham ctsp3 = new ChiTietSanPham();
        ctsp3.setDonVi(dv1);
        ctsp3.setGiaBan(new BigDecimal(10000));
        ctsp3.setGiaNhap(new BigDecimal(8000));
        ctsp3.setHinhAnh(null);
        ctsp3.setMau(MauConstant.DEN);
        ctsp3.setNamBaoHanh(1);
        ctsp3.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp3.setSanPham(sanPham3);
        ctsp3.setSize(38);
        ctsp3.setSoLuongTon(100);
        ctsp3.setTrangThai(TrangThaiSanPhamConstanst.DA_MO_BAN);
        session.save(ctsp3);
        
        ChiTietSanPham ctsp4 = new ChiTietSanPham();
        ctsp4.setDonVi(dv1);
        ctsp4.setGiaBan(new BigDecimal(10000));
        ctsp4.setGiaNhap(new BigDecimal(8000));
        ctsp4.setHinhAnh(null);
        ctsp4.setMau(MauConstant.DEN);
        ctsp4.setNamBaoHanh(1);
        ctsp4.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        ctsp4.setSanPham(sanPham1);
        ctsp4.setSize(38);
        ctsp4.setSoLuongTon(200);
        ctsp4.setTrangThai(TrangThaiSanPhamConstanst.CHO_XAC_NHAN);
        session.save(ctsp4);
        
        PhieuNhap pn = new PhieuNhap();
        pn.setGhiChu("Giày đẹp");
        pn.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pn.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        pn.setNhaCungCap(ncc2);
        pn.setNhanVien(nhanVien);
        pn.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(pn);
        
        PhieuNhap pn1 = new PhieuNhap();
        pn1.setGhiChu("Giày đẹp");
        pn1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        pn1.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        pn1.setNhaCungCap(ncc2);
        pn1.setNhanVien(nhanVien);
        pn1.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(pn1);
        
        PhieuNhap pn2 = new PhieuNhap();
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
        px.setGhiChu("xuất gấp");
        px.setKhachHang(kh2);
        px.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px.setNhanVien(nhanVien1);
        px.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px);
        
        PhieuXuat px1 = new PhieuXuat();
        px1.setGhiChu("xuất gấp");
        px1.setKhachHang(kh2);
        px1.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px1.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px1.setNhanVien(nhanVien1);
        px1.setTrangThai(TrangThaiPhieuConstant.DA_HUY);
        session.save(px1);
        
        PhieuXuat px2 = new PhieuXuat();
        px2.setGhiChu("xuất gấp");
        px2.setKhachHang(kh2);
        px2.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px2.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px2.setNhanVien(nhanVien1);
        px2.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px2);
        
        PhieuXuat px3 = new PhieuXuat();
        px3.setGhiChu("xuất gấp");
        px3.setKhachHang(kh2);
        px3.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px3.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px3.setNhanVien(nhanVien1);
        px3.setTrangThai(TrangThaiPhieuConstant.DA_THANH_TOAN);
        session.save(px3);
        
        PhieuXuat px4 = new PhieuXuat();
        px4.setGhiChu("xuất gấp");
        px4.setKhachHang(kh2);
        px4.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        px4.setNgayThanhToan(DateTimeUtil.convertDateToTimeStampSecond());
        px4.setNhanVien(nhanVien1);
        px4.setTrangThai(TrangThaiPhieuConstant.CHO_THANH_TOAN);
        session.save(px4);
        
        PhieuXuat px5 = new PhieuXuat();
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
