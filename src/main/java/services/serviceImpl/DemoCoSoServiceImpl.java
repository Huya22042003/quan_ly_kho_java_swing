/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.serviceImpl;

import customModels.DemoCoSoCustom;
import domainModels.CoSo;
import infrastructures.constant.CoSoConstant;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import repositories.DemoCoSoRepository;
import services.DemoCoSoService;
import utilities.Converter;
import utilities.palette.Combobox;

/**
 *
 * @author QUOC HUY
 */
public class DemoCoSoServiceImpl implements DemoCoSoService {

    private DemoCoSoRepository rp;

    public DemoCoSoServiceImpl() {
        rp = new DemoCoSoRepository();
    }

    @Override
    public List<DemoCoSoCustom> getListCoSo() {
        return rp.getList();
    }

    @Override
    public DemoCoSoCustom addCoSo(DemoCoSoCustom custom) {
        CoSo cs = new CoSo();
        cs.setMa(custom.getMa());
        cs.setTen(custom.getTen());
        cs.setViTri(custom.getViTri());
        cs.setTrangThai(custom.getTrangThai());
        custom.setId(rp.addCoSo(cs).getId());
        return custom;
    }

    @Override
    public boolean updateCoSo(DemoCoSoCustom custom) {
        CoSo cs = new CoSo();
        cs.setMa(custom.getMa());
        cs.setTen(custom.getTen());
        cs.setViTri(custom.getViTri());
        cs.setTrangThai(custom.getTrangThai());
        cs.setId(custom.getId());
        return rp.updateCoSo(cs);
    }

    @Override
    public boolean deleteCoSo(UUID id) {
        return rp.deleteCoSo(id);
    }

    @Override
    public void loadCombobox(Combobox cbb) {
        cbb.removeAll();
        cbb.addItem(Converter.trangThaiCoSo(CoSoConstant.DANG_HOAT_DONG));
        cbb.addItem(Converter.trangThaiCoSo(CoSoConstant.TAM_NGHI));
        cbb.addItem(Converter.trangThaiCoSo(CoSoConstant.DA_DONG_CUA));
        cbb.addItem(Converter.trangThaiCoSo(CoSoConstant.SAP_HOAT_DONG));
    }

    @Override
    public DemoCoSoCustom checkValidate(DemoCoSoCustom cs, JLabel erroMa, JLabel erroTen, JLabel erroViTri) {

        boolean check = true;

        if (cs.getMa() != null) {
            if (cs.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
            } else if (!cs.getMa().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroMa.setText("Mã không được có khoảng trắng");
                check = false;
            } else if (findCoSoByMa(cs.getMa()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (cs.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (cs.getViTri().trim().length() == 0) {
            erroViTri.setText("Vị trí không được để trống");
            check = false;
        } else {
            erroViTri.setText("");
        }

        if (!check) {
            return null;
        }

        return cs;
    }

    @Override
    public CoSoConstant loc(int a) {
        switch (a) {
            case 0:
                return CoSoConstant.DANG_HOAT_DONG;
            case 1:
                return CoSoConstant.TAM_NGHI;
            case 2:
                return CoSoConstant.DA_DONG_CUA;
            case 3:
                return CoSoConstant.SAP_HOAT_DONG;
            default:
                return null;
        }
    }

    @Override
    public DemoCoSoCustom findCoSoByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public List<DemoCoSoCustom> findAllByRadio(String tk, CoSoConstant tt, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByMa(tk, tt);
            case 1:
                return rp.findAllByTen(tk, tt);
            case 2:
                return rp.findAllByViTri(tk, tt);
            default:
               return null; 
        }
    }


}
