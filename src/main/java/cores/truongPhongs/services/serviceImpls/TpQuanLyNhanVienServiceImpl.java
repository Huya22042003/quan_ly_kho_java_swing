/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpNhanVienCustom;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiNhanVienConstant;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import cores.truongPhongs.repositories.TpQuanLyNhanVienRepository;
import utilities.Converter;
import utilities.palette.Combobox;
import cores.truongPhongs.services.TpQuanLyNhanVienSevice;

/**
 *
 * @author LENOVO
 */
public class TpQuanLyNhanVienServiceImpl implements TpQuanLyNhanVienSevice {

    private TpQuanLyNhanVienRepository rp;

    public TpQuanLyNhanVienServiceImpl() {
        rp = new TpQuanLyNhanVienRepository();
    }

    @Override
    public List<TpNhanVienCustom> getListNhanVien() {
        return rp.getList();
    }

    @Override
    public TpNhanVienCustom addNhanVien(TpNhanVienCustom ct) {
        NhanVien nv = new NhanVien();
        nv.setMa(ct.getMa());
        nv.setTen(ct.getTen());
        nv.setSdt(ct.getSdt());
        nv.setEmail(ct.getEmail());
        nv.setMatKhau(ct.getMatKhau());
        nv.setHinhAnh(ct.getHinhAnh());
        nv.setGioiTinh(ct.getGioiTinh());
        nv.setDiaChi(ct.getDiaChi());
        nv.setTrangThai(ct.getTrangThai());
        ct.setId(rp.addNhanVien(nv).getId());
        return ct;
    }

    @Override
    public boolean updateNhanVien(TpNhanVienCustom ct) {
        NhanVien nv = new NhanVien();
        nv.setMa(ct.getMa());
        nv.setTen(ct.getTen());
        nv.setSdt(ct.getSdt());
        nv.setEmail(ct.getEmail());
        nv.setMatKhau(ct.getMatKhau());
        nv.setHinhAnh(ct.getHinhAnh());
        nv.setGioiTinh(ct.getGioiTinh());
        nv.setDiaChi(ct.getDiaChi());
        nv.setTrangThai(ct.getTrangThai());
        nv.setId(ct.getId());
        return rp.updateNhanVien(nv);
    }

    @Override
    public boolean deleteNhanVien(UUID id) {
        return rp.deleteNhanVien(id);
    }

    @Override
    public void loadCombobox(Combobox cbb) {
        cbb.removeAll();
        cbb.addItem(Converter.trangThaiNhanVien(TrangThaiNhanVienConstant.CHUA_HOAT_DONG));
        cbb.addItem(Converter.trangThaiNhanVien(TrangThaiNhanVienConstant.DANG_HOAT_DONG));
        cbb.addItem(Converter.trangThaiNhanVien(TrangThaiNhanVienConstant.DA_NGHI_VIEC));
    }

    @Override
    public TrangThaiNhanVienConstant loc(int a) {
        switch(a){
            case 0:
                return TrangThaiNhanVienConstant.CHUA_HOAT_DONG;
                  case 1:
                return TrangThaiNhanVienConstant.DANG_HOAT_DONG;
                  case 2:
                return TrangThaiNhanVienConstant.DA_NGHI_VIEC;
                default:
                    return null;
        }
    }

    @Override
    public TpNhanVienCustom finNhanVienByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public TpNhanVienCustom checkValidate(TpNhanVienCustom nv, JLabel erroMa, JLabel erroTen, JLabel erroSDT, JLabel erroEmail, JLabel erroMatKhau, JLabel erroNgaySinh, JLabel erroDiaChi) {

 boolean check = true;
        if (nv.getMa() != null) {
            if (nv.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
            } else if (!nv.getMa().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroMa.setText("Mã không được có khoảng trắng");
                check = false;
            } else if (finNhanVienByMa(nv.getMa()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (nv.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else {
            erroTen.setText("");
        }
   if (nv.getSdt().trim().length() == 0) {
            erroSDT.setText("SDT không được để trống");
            check = false;
        } else {
            erroSDT.setText("");
        }
   if (nv.getEmail().trim().length() == 0) {
            erroEmail.setText("Email không được để trống");
            check = false;
        } else {
            erroEmail.setText("");
        }
  if (nv.getMatKhau().trim().length() == 0) {
            erroMatKhau.setText("Mật Khẩu không được để trống");
            check = false;
        } else {
            erroMatKhau.setText("");
        } 
//  if (Long.valueOf(nv.getNgaySinh().trim().length() == 0) ) {
//            erroEmail.setText("Ngày Sinh không được để trống");
//            check = false;
//        } else {
//            erroEmail.setText("");
//        }
  if (nv.getDiaChi().trim().length() == 0) {
            erroDiaChi.setText("Địa chỉ không được để trống");
            check = false;
        } else {
            erroDiaChi.setText("");
        } 

        if (!check) {
            return null;
        }

        return nv;
    }

    @Override
    public List<TpNhanVienCustom> findAllByRadio(String tk, TrangThaiNhanVienConstant tt, int rdo) {
     switch (rdo) {
            case 0:
                return rp.findAllByMa(tk, tt);
            case 1:
                return rp.findAllByTen(tk, tt);
            case 2:
                return rp.findAllByDiaChi(tk, tt);
            default:
               return null; 
        }

    }



 

}
