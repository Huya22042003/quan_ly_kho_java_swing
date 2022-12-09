/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_SanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.repositories.TP_SanPhamRepository;
import cores.truongPhongs.services.TP_SanPhamService;
import domainModels.SanPham;
import infrastructures.constant.ValidateConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author asus
 */
public class TP_SanPhamServiceImpl implements TP_SanPhamService {

    private TP_SanPhamRepository rp = new TP_SanPhamRepository();

    @Override
    public List<TpQuanLySanPhamCustom> getAll(String ten) {
        return rp.getAll(ten);
    }

    @Override
    public TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        custom.setId(rp.addSanPham(sp).getId());
        return custom;
    }

    @Override
    public boolean updateSanPham(TP_SanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        sp.setId(custom.getId());
        return rp.updateSanPham(sp);
    }

    @Override
    public boolean deleteSanPham(UUID id) {
        return rp.deleteSanPham(id);
    }

    @Override
    public TpQuanLySanPhamCustom findSanPhamByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen) {
        boolean check = true;

        if (sp.getMa().trim() != null) {
            if (sp.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
            } else if (!sp.getMa().trim().matches(sp.getMa().toUpperCase())) {
                erroMa.setText("Mã phải viết hoa");
                check = false;
            } else if (!sp.getMa().trim().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroMa.setText("Mã không được có khoảng trắng");
                check = false;
            } else if (findSanPhamByMa(sp.getMa().trim()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (sp.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else if (!sp.getTen().matches("^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*")) {
            erroTen.setText("Tên sai định dạng");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (!check) {
            return null;
        }

        return sp;
    }

    @Override
    public List<TpQuanLySanPhamCustom> phanTrang(List<TpQuanLySanPhamCustom> list, int offset, int limit) {
        List<TpQuanLySanPhamCustom> listPhanTrang = new ArrayList<>();
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                break;
            }
            TpQuanLySanPhamCustom el = list.get(i);
            listPhanTrang.add(el);
        }
        return listPhanTrang;
    }

    @Override
    public List<TpQuanLySanPhamCustom> findAllByRadio(String tk, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByMa(tk);
            case 1:
                return rp.findAllByTen(tk);
            default:
                return null;
        }
    }

}
