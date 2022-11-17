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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(p.getIdNhanVien());
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
        NhaCungCap ncc = repoNcc.getNccById(p.getIdNcc());
        NhanVien nv = repoNv.getNhanVienById(p.getIdNhanVien());
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

        if (ngayTao == null) {
            errNgayNhap.setText("Bạn chưa chọn ngày nhận!");
            check =false;
        } else {
            errNgayTao.setText("");
        }
        if (ngayNhan  == null) {
            errNgayTao.setText("Bạn chưa chọn ngày tạo!");
            check = false;
        } else {
            errNgayTao.setText("");
        }
         if (!check) {
            return null;
        }
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//        Date nn;
//        Date nt;
//        try {
//            nn = sdf.parse(ngayNhan.toString());
//            nt = sdf.parse(ngayTao.toString());
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            return null;   
//        }
       
//        if (!String.valueOf(ngayNhan).matches(ValidateConstant.REGEX_DATE)) {
//            errNgayNhap.setText("Sai định dạng ngày nhận!");
//            check = false;
//        } else {
//            errNgayNhap.setText("");
//
//        }
//        if (!String.valueOf(ngayTao).matches(ValidateConstant.REGEX_DATE)) {
//            errNgayTao.setText("Sai định dạng ngày tạo!");
//            check = false;
//        } else {
//            errNgayTao.setText("");
//        }
        if (!check) {
            return null;
        }
        NvqlQuanLyPhieuNhapCustom pn = new NvqlQuanLyPhieuNhapCustom();
        pn.setGhiChu(ghiChu);
        pn.setNgayNhan(ngayNhan.getTime());
        pn.setNgayTao(ngayTao.getTime());
        return pn;

    }

    @Override
    public NvqlQuanLyPhieuNhapCustom findPhieuNhapById(UUID id) {
        NvqlQuanLyPhieuNhapCustom p = new NvqlQuanLyPhieuNhapCustom();
        PhieuNhap pn = repo.findPhieuNhapById(id);
        p.setId(pn.getId());
        p.setIdNcc(pn.getNhaCungCap().getId());
        p.setIdNhanVien(pn.getNhanVien().getId());
        p.setGhiChu(pn.getGhiChu());
        p.setNgayNhan(pn.getNgayTao());
        p.setNgayTao(pn.getNgayNhan());
       
        return p;
    }

}
