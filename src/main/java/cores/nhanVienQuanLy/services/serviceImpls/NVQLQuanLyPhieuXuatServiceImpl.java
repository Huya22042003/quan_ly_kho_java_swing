/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.repositories.NVQLQuanLyPhieuXuatRepository;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import cores.nhanVienQuanLy.repositories.LayListKhachHangRepository;
import cores.nhanVienQuanLy.repositories.LayListNhanVienRepository;
import domainModels.PhieuNhap;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;
import cores.nhanVienQuanLy.services.NVQLQuanLyPhieuXuatService;
import domainModels.KhachHang;
import domainModels.NhanVien;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import utilities.Converter;

/**
 *
 * @author admin
 */
public class NVQLQuanLyPhieuXuatServiceImpl implements NVQLQuanLyPhieuXuatService {

    private NVQLQuanLyPhieuXuatRepository rp;
    private LayListNhanVienRepository rpNV;
    private LayListKhachHangRepository rpKH;

    public NVQLQuanLyPhieuXuatServiceImpl() {
        rp = new NVQLQuanLyPhieuXuatRepository();
        rpNV = new LayListNhanVienRepository();
        rpKH = new LayListKhachHangRepository();
    }

    @Override
    public List<PhieuXuatCustom> getListByNgayTao(Long ngayTao) {
        return rp.getListByNgayTao(ngayTao);
    }

    @Override
    public PhieuXuatCustom addPhieuXuat(PhieuXuatCustom pxcs) {
        KhachHang kh = rpKH.getListByID(pxcs.getKhachHang());
        NhanVien nv = rpNV.getListByID(pxcs.getNhanVien());
        PhieuXuat px = new PhieuXuat();
        px.setNgayTao(pxcs.getNgayTao());
        px.setGhiChu(pxcs.getGhiChu());
        px.setNgayThanhToan(pxcs.getNgayThanhToan());
        px.setTrangThai(pxcs.getTrangThai());
        px.setNhanVien(nv);
        px.setKhachHang(kh);
        pxcs.setId(rp.addPhieuXuat(px).getId());
        return pxcs;
    }

    @Override
    public boolean updatePhieuXuat(PhieuXuatCustom pxcs) {
        KhachHang kh = rpKH.getListByID(pxcs.getKhachHang());
        NhanVien nv = rpNV.getListByID(pxcs.getNhanVien());
        PhieuXuat px = new PhieuXuat();
        px.setNgayTao(pxcs.getNgayTao());
        px.setGhiChu(pxcs.getGhiChu());
        px.setNgayThanhToan(pxcs.getNgayThanhToan());
        px.setTrangThai(pxcs.getTrangThai());
        px.setNhanVien(nv);
        px.setKhachHang(kh);
        px.setId(pxcs.getId());
        return rp.updatePhieuXuat(px);
    }

    @Override
    public boolean deletePhieuXuat(UUID id) {
        return rp.deletePhieuNhap(id);
    }

//    public PhieuXuatCustom checkValidate(PhieuXuatCustom pncs, JLabel errNgayTao, JLabel errGhiChu, JLabel errNgayNhan) {
//        boolean check = true;
//        if (pncs.getNgayTao() == null) {
//            errNgayTao.setText("Ngày tạo không được để trống");
//            check = false;
//        } else {
//            errNgayTao.setText("");
//        }
//        if (pncs.getGhiChu().trim().length() == 0) {
//            errGhiChu.setText("Ghi chú không được để trống");
//            check = false;
//        } else {
//            errGhiChu.setText("");
//        }
//        if (pncs.getNgayNhan() == null) {
//            errNgayNhan.setText("Ngày nhận không được để trống");
//            check = false;
//        } else {
//            errNgayNhan.setText("");
//        }
//        if (!check) {
//            return null;
//        }
//        return pncs;
//    }
    @Override
    public List<PhieuXuatCustom> getList() {
        return rp.getList();
    }

    @Override
    public PhieuXuatCustom findByID(UUID id) {
        return rp.findById(id);
    }

    @Override
    public void loadComBox(Combobox cbbTT) {
        cbbTT.removeAll();
        cbbTT.addItem(Converter.TrangThaiPhieuXuat(TrangThaiPhieuConstant.CHO_THANH_TOAN));
        cbbTT.addItem(Converter.TrangThaiPhieuXuat(TrangThaiPhieuConstant.DA_HUY));
        cbbTT.addItem(Converter.TrangThaiPhieuXuat(TrangThaiPhieuConstant.DA_THANH_TOAN));
    }

    public TrangThaiPhieuConstant loc(int a) {
        switch (a) {
            case 1:
                return TrangThaiPhieuConstant.CHO_THANH_TOAN;
            case 2:
                return TrangThaiPhieuConstant.DA_HUY;
            case 3:
                return TrangThaiPhieuConstant.DA_THANH_TOAN;
            default:
                return null;
        }
    }
}
