/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNccRepository;
import cores.nhanVienQuanLy.repositories.NvqlGetTenNhanVienRepository;
import cores.nhanVienQuanLy.repositories.NvqlQuanLyPhieuNhapRepository;
import cores.nhanVienQuanLy.services.NvqlQuanLyPhieuNhapService;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import domainModels.PhieuNhap;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

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
        NhaCungCap ncc = repoNcc.getNccById(p.getId());
        NhanVien nv = repoNv.getNhanVienById(p.getId());
        PhieuNhap pn = new PhieuNhap();
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayNhan(p.getNgayNhan());
        pn.setNgayTao(p.getNgayTao());
        pn.setNhaCungCap(ncc);
        pn.setNhanVien(nv);
        p.setId(repo.addPn(pn).getId());
        return p;
    }

    @Override
    public boolean updatePn(NvqlQuanLyPhieuNhapCustom p) {
        NhaCungCap ncc = repoNcc.getNccById(p.getId());
        NhanVien nv = repoNv.getNhanVienById(p.getId());
        PhieuNhap pn = new PhieuNhap();
        pn.setId(p.getId());
        pn.setGhiChu(p.getGhiChu());
        pn.setNgayNhan(p.getNgayNhan());
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
    public NvqlQuanLyPhieuNhapCustom checkValidate(NvqlQuanLyPhieuNhapCustom pn, JLabel errNgayNhap, JLabel errNgayTao, JLabel errGhiChu) {
        boolean check = true;
        if (pn.getGhiChu() != null) {
            if (pn.getGhiChu().length() > 255) {
                errGhiChu.setText("Ghi chú không quá 255 kí tự!");
                check = false;
            } else if (pn.getGhiChu().trim().length() == 0) {
                errGhiChu.setText("Ghi chú không được để trống!");
                check = false;
            } else {
                errGhiChu.setText("");
            }
        }
        if(pn.getGhiChu() == null){
            errGhiChu.setText("Ghi chú không được để trống!");
                check = false;
        }

        if (pn.getNgayNhan() == null) {
            errNgayNhap.setText("Không được để trống ngày nhận!");
            check = false;
        } else {
            errNgayNhap.setText("");
        }
        if (pn.getNgayTao() == null) {
            errNgayTao.setText("Không được để trống ngày tạo!");
            check = false;
        } else {
            errNgayTao.setText("");

        }
//        if (!String.valueOf(pn.getNgayNhan()).matches(ValidateConstant.REGEX_DATE)) {
//            errNgayNhap.setText("Sai định dạng ngày nhận!");
//            check = false;
//        } else {
//            errNgayNhap.setText("");
//
//        }
//        if (!String.valueOf(pn.getNgayTao()).matches(ValidateConstant.REGEX_DATE)) {
//            errNgayTao.setText("Sai định dạng ngày tạo!");
//            check = false;
//        } else {
//            errNgayTao.setText("");
//
//        }
        if (!check) {
            return null;
        }
        return pn;

    }

}
