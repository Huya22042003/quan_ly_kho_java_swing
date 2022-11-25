/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.repositories.NVQLQuanLyPhieuXuatRepository;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import java.util.List;
import java.util.UUID;
import utilities.palette.Combobox;
import cores.nhanVienQuanLy.services.NVQLQuanLyPhieuXuatService;
import domainModels.KhachHang;
import domainModels.NhanVien;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.ArrayList;
import utilities.Converter;

/**
 *
 * @author admin
 */
public class NVQLQuanLyPhieuXuatServiceImpl implements NVQLQuanLyPhieuXuatService {

    private NVQLQuanLyPhieuXuatRepository rp;

    private List<NhanVien> listNV;
    private List<KhachHang> listKH;

    public NVQLQuanLyPhieuXuatServiceImpl() {
        rp = new NVQLQuanLyPhieuXuatRepository();
        listNV = new ArrayList<>();
        listKH = new ArrayList<>();
    }

    @Override
    public List<PhieuXuatCustom> getListByNgayTao(Long ngayBatDau, Long ngayKetThuc) {
        return rp.getListByNgayTao(ngayBatDau, ngayKetThuc);
    }

    @Override
    public PhieuXuatCustom addPhieuXuat(PhieuXuatCustom pxcs) {
        PhieuXuat px = new PhieuXuat();
        px.setNgayTao(pxcs.getNgayTao());
        px.setGhiChu(pxcs.getGhiChu());
        px.setNgayThanhToan(pxcs.getNgayThanhToan());
        px.setTrangThai(pxcs.getTrangThai());
        px.setNhanVien(pxcs.getNhanVien());
        px.setKhachHang(pxcs.getKhachHang());
        pxcs.setId(rp.addPhieuXuat(px).getId());
        return pxcs;
    }

    @Override
    public boolean updatePhieuXuat(PhieuXuatCustom pxcs) {
        PhieuXuat px = new PhieuXuat();
        px.setNgayTao(pxcs.getNgayTao());
        px.setGhiChu(pxcs.getGhiChu());
        px.setNgayThanhToan(pxcs.getNgayThanhToan());
        px.setTrangThai(pxcs.getTrangThai());
        px.setNhanVien(pxcs.getNhanVien());
        px.setKhachHang(pxcs.getKhachHang());
        px.setId(pxcs.getId());
        return rp.updatePhieuXuat(px);
    }

    @Override
    public boolean deletePhieuXuat(UUID id) {
        return rp.deletePhieuXuat(id);
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

    @Override
    public TrangThaiPhieuConstant loc(int a) {
        switch (a) {
            case 0:
                return TrangThaiPhieuConstant.CHO_THANH_TOAN;
            case 1:
                return TrangThaiPhieuConstant.DA_HUY;
            case 2:
                return TrangThaiPhieuConstant.DA_THANH_TOAN;
            default:
                return null;
        }
    }

    @Override
    public void loadComBoBoxNV(Combobox cbbNV) {
        listNV = rp.getListMaNhanVien();
        cbbNV.removeAll();
        for (NhanVien nv : listNV) {
            cbbNV.addItem(nv.getMa());
        }
    }

    @Override
    public void loadComBoBoxKh(Combobox cbbKH) {
        listKH = rp.getListMaKhachHang();
        cbbKH.removeAll();
        for (KhachHang kh : listKH) {
            cbbKH.addItem(kh.getMa());
        }
    }
//        for (LayListNhanVienCustom nv : listNV) {
//            cbbNhanVien.addItem(nv.getMa());
//        }
//    }

    @Override
    public List<NhanVien> getListMaNhanVien() {
        listNV = rp.getListMaNhanVien();
        return listNV;
    }

    @Override
    public List<KhachHang> getListMaKhachHang() {
        listKH = rp.getListMaKhachHang();
        return listKH;
    }

    @Override
    public NhanVien chonNV(int chon) {
        return listNV.get(chon);
    }

    @Override
    public KhachHang chonKH(int chon) {
        return listKH.get(chon);
    }

    @Override
    public List<PhieuXuatCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        return rp.getListByNgayThanhToan(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<PhieuXuatCustom> findAllByKhAndNV(String ma, TrangThaiPhieuConstant tt, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByIdNhanVien(ma, tt);
            case 1:
                return rp.findAllByIdKhachHang(ma, tt);
            default:
                return rp.findAllByIdKhachHang("", tt);
        }
    }

//    @Override
//    public List<PhieuXuatCustom> findByMaAndTT(UUID id, TrangThaiPhieuConstant tt) {
//        return rp.findAllByIdPhieu(id, tt);
//    }

    @Override
    public List<PhieuXuatCustom> findByMa(UUID id) {
        return rp.findAllByIdPhieu(id);
    }

    @Override
    public List<PhieuXuatCustom> getListDaThanhToan() {
        return rp.getListDaThanhToan();
    }

}
