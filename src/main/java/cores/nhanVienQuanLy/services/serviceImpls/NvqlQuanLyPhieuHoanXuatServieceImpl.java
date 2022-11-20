/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuHoanXuatCustom;
import cores.nhanVienQuanLy.repositories.NvqlQuanLyPhieuHoanXuatRepository;
import java.util.List;
import java.util.UUID;
import utilities.palette.Combobox;
import cores.nhanVienQuanLy.services.NvqlQuanLyPhieuHoanXuatService;
import domainModels.PhieuHoanXuat;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NvqlQuanLyPhieuHoanXuatServieceImpl implements NvqlQuanLyPhieuHoanXuatService {

    private NvqlQuanLyPhieuHoanXuatRepository rp;

    private List<PhieuXuat> listPX;

    public NvqlQuanLyPhieuHoanXuatServieceImpl() {
        rp = new NvqlQuanLyPhieuHoanXuatRepository();
        listPX = new ArrayList<>();
    }

    @Override
    public List<NvqlQuanLyPhieuHoanXuatCustom> getListByNgayTao(Long ngayBatDau, Long ngayKetThuc) {
        return rp.getListByNgayTao(ngayBatDau, ngayKetThuc);
    }

    @Override
    public NvqlQuanLyPhieuHoanXuatCustom addPhieuHoanXuat(NvqlQuanLyPhieuHoanXuatCustom phxcs) {
        PhieuHoanXuat phx = new PhieuHoanXuat();
        phx.setNgayTao(phxcs.getNgayTao());
        phx.setGhiChu(phxcs.getGhiChu());
        phx.setNgayThanhToan(phxcs.getNgayThanhToan());
        phx.setTrangThai(phxcs.getTrangThai());
        phx.setPhieuXuat(phxcs.getPhieuXuat());
        phx.setLiDo(phxcs.getLiDo());
        phxcs.setId(rp.addPhieuHoanXuat(phx).getId());
        return phxcs;
    }

    @Override
    public boolean updatePhieuHoanXuat(NvqlQuanLyPhieuHoanXuatCustom phxcs) {
        PhieuHoanXuat phx = new PhieuHoanXuat();
        phx.setNgayTao(phxcs.getNgayTao());
        phx.setGhiChu(phxcs.getGhiChu());
        phx.setNgayThanhToan(phxcs.getNgayThanhToan());
        phx.setTrangThai(phxcs.getTrangThai());
        phx.setPhieuXuat(phxcs.getPhieuXuat());
        phx.setId(phxcs.getId());
        return rp.updatePhieuHoanXuat(phx);
    }

    @Override
    public boolean deletePhieuHoanXuat(UUID id) {
        return rp.deletePhieuHoanXuat(id);
    }

//    public NvqlQuanLyPhieuHoanXuatCustom checkValidate(NvqlQuanLyPhieuHoanXuatCustom pncs, JLabel errNgayTao, JLabel errGhiChu, JLabel errNgayNhan) {
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
    public List<NvqlQuanLyPhieuHoanXuatCustom> getList() {
        return rp.getList();
    }

    @Override
    public NvqlQuanLyPhieuHoanXuatCustom findByID(UUID id) {
        return rp.findById(id);
    }

//    @Override
//    public void loadComBox(Combobox cbbTT) {
//        cbbTT.removeAll();
//        cbbTT.addItem(Converter.TrangThaiPhieuHoan(TrangThaiPhieuHoanConstant.CHO_XAC_NHAN));
//        cbbTT.addItem(Converter.TrangThaiPhieuHoan(TrangThaiPhieuHoanConstant.DA_HUY));
//    }

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

//    @Override
//    public List<PhieuXuat> getListMaPhieuXuat() {
//        listPX = rp.getListMaPhieuXuat();
//        return listPX;
//    }

    @Override
    public List<NvqlQuanLyPhieuHoanXuatCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        return rp.getListByNgayThanhToan(ngayBatDau, ngayKetThuc);
    }

    @Override
    public void loadComBoBoxPx(Combobox cbbPX) {
        listPX = rp.getListMaPhieuXuat();
        cbbPX.removeAll();
        for (PhieuXuat nv : listPX) {
            cbbPX.addItem(nv.getId());
        }
    }

    @Override
    public PhieuXuat chonPX(int chon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhieuXuat> getListMaPhieuXuat() {
        listPX = rp.getListMaPhieuXuat();
        return listPX;
    }
}
