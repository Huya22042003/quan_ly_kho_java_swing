/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.NvqlQuanLyPhieuNhapCustom;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNccRepository;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNhanVienRepository;
import cores.truongPhongs.repositories.NvqlQuanLyPhieuNhapRepository;
import cores.truongPhongs.services.NvqlQuanLyPhieuNhapService;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import domainModels.PhieuNhap;
import infrastructures.constant.TrangThaiPhieuConstant;
import infrastructures.constant.ValidateConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.DateTimeUtil;

/**
 *
 * @author Acer
 */
public class NvqlQuanLyPhieuNhapServiceImpl implements NvqlQuanLyPhieuNhapService {

    private NvqlQuanLyPhieuNhapRepository repo;
    private NvqlGetTenNccRepository repoNcc;
    private NvqlGetTenNhanVienRepository repoNv;

    public NvqlQuanLyPhieuNhapServiceImpl() {
        repo = new NvqlQuanLyPhieuNhapRepository();
        repoNcc = new NvqlGetTenNccRepository();
        repoNv = new NvqlGetTenNhanVienRepository();
    }

    @Override
    public List<NvqlQuanLyPhieuNhapCustom> getListPn() {
        return repo.getListPhieuNhap();
    }

    @Override
    public NvqlQuanLyPhieuNhapCustom addPn(NvqlQuanLyPhieuNhapCustom p) {
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(p.getIdNhanVien());
        PhieuNhap pn = new PhieuNhap();
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayThanhToan(p.getNgayThanhToan());
        pn.setNgayTao(p.getNgayTao());
        pn.setNhaCungCap(ncc);
        pn.setNhanVien(nv);
        pn.setTrangThai(p.getTrangThai());
        p.setId(repo.addPn(pn).getId());
        return p;
    }

    @Override
    public boolean updatePn(NvqlQuanLyPhieuNhapCustom p) {
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(p.getIdNhanVien());
        PhieuNhap pn = new PhieuNhap();
        pn.setId(p.getId());
        pn.setTrangThai(p.getTrangThai());
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayThanhToan(p.getNgayThanhToan());
        pn.setNgayTao(p.getNgayTao());
        pn.setNhaCungCap(ncc);
        pn.setNhanVien(nv);
        return repo.updatePn(pn);
    }

    @Override
    public boolean deletePn(UUID id) {
        return repo.deletePn(id);
    }

    @Override
    public NvqlQuanLyPhieuNhapCustom checkValidate(String ghiChu, Date ngayTao, Date ngayNhan, JLabel errNgayNhap, JLabel errNgayTao, JLabel errGhiChu) {
        boolean check = true;
        if (ghiChu.trim().length() == 0) {
            errGhiChu.setText("Ghi chú không được để trống!");
            check = false;
        } else if (ghiChu.trim().length() > 255) {
            errGhiChu.setText("Ghi chú không quá 255 kí tự!");
            check = false;
        } else {
            errGhiChu.setText("");
        }

//        if (ngayTao == null) {
//            errNgayNhap.setText("Bạn chưa chọn ngày tao!");
//            check =false;
//        } else {
//            errNgayTao.setText("");
//        }
        if (ngayTao  == null) {
            errNgayTao.setText("Bạn chưa chọn ngày thanh toán!");
            check = false;
        } else {
            errNgayTao.setText("");
        }
        if(ngayTao.getTime() < DateTimeUtil.convertDateToTimeStampSecond()){
            errNgayNhap.setText("Ngay thanh toán phải lớn hơn hoặc bằng ngày tạo!");
            check = false;
        }
            
        

        if (!check) {
            return null;
        }
        NvqlQuanLyPhieuNhapCustom pn = new NvqlQuanLyPhieuNhapCustom();
        pn.setGhiChu(ghiChu);
        pn.setNgayThanhToan(ngayNhan.getTime());
        pn.setNgayTao(ngayTao.getTime());
        return pn;

    }

    @Override
    public NvqlQuanLyPhieuNhapCustom findPhieuNhapById(UUID id) {
        NvqlQuanLyPhieuNhapCustom p = new NvqlQuanLyPhieuNhapCustom();
        PhieuNhap pn = repo.findPhieuNhapById(id);
        p.setId(pn.getId());
        p.setTrangThai(pn.getTrangThai());
        p.setIdNcc(pn.getNhaCungCap().getId());
        p.setIdNhanVien(pn.getNhanVien().getId());
        p.setGhiChu(pn.getGhiChu());
        p.setNgayThanhToan(pn.getNgayThanhToan());
        p.setNgayTao(pn.getNgayTao());
       
        return p;
    }

    @Override
    public TrangThaiPhieuConstant loc(int a) {
         switch (a) {
            case 0:
                return TrangThaiPhieuConstant.DA_THANH_TOAN;
            case 1:
                return TrangThaiPhieuConstant.DA_HUY;
            case 2:
                return TrangThaiPhieuConstant.CHO_THANH_TOAN;
            default:
                return null;
        }
    }

    @Override
    public List<NvqlQuanLyPhieuNhapCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        return repo.getListByNgayThanhToan(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<NvqlQuanLyPhieuNhapCustom> getListByNgayTao(Long ngayTao, Long ngayKetThuc) {
        return repo.getListByNgayTao(ngayTao, ngayKetThuc);
    }


}
