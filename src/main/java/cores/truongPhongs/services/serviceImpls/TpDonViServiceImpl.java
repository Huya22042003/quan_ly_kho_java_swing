/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpDonViCustom;
import cores.truongPhongs.repositories.TpDonViRepository;
import cores.truongPhongs.services.TpDonViService;
import domainModels.DonVi;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class TpDonViServiceImpl implements TpDonViService {

    private TpDonViRepository rp;

    public TpDonViServiceImpl() {
        rp = new TpDonViRepository();
    }



    @Override
    public TpDonViCustom addDonVi(TpDonViCustom custom) {
        DonVi dv = new DonVi();
        dv.setDonViGoc(custom.getDonViGoc());
        dv.setDonViQuyDoi(custom.getDonViQuyDoi());
        dv.setSoLuong(custom.getSoLuong());
        custom.setId(rp.addDonVi(dv).getId());
        return custom;
    }

    @Override
    public boolean updateDonVi(TpDonViCustom custom) {
        DonVi dv = new DonVi();
        dv.setDonViGoc(custom.getDonViGoc());
        dv.setDonViQuyDoi(custom.getDonViQuyDoi());
        dv.setSoLuong(custom.getSoLuong());
        dv.setId(custom.getId());
        return rp.updateDonVi(dv);
    }

    @Override
    public boolean deleteDonVi(UUID id) {
        return rp.deleteDonVi(id);
    }

    @Override
    public TpDonViCustom checkValidate(TpDonViCustom dv, JLabel erroDonViGoc, JLabel erroDonViQuyDoi, JLabel erroSoLuong) {
  
 
       boolean check = true;
        if (dv.getDonViGoc() != null) {
            if (dv.getDonViGoc().trim().length() == 0) {
                erroDonViGoc.setText("Đơn Vị Gốc không được để trống");
                check = false;
            } else if (!dv.getDonViGoc().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroDonViGoc.setText("Đơn Vị Gốc không được có khoảng trắng");
                check = false;
            } 
            else if (findDonViByDonViQuyDoi(dv.getDonViGoc()) != null){
                erroDonViGoc.setText("Đơn Vị Gốc Đã Tồn Tại");
                check = false;
            }
            else{
                erroDonViGoc.setText("");
            }
        }
     if (dv.getDonViQuyDoi() != null) {
            if (dv.getDonViQuyDoi().trim().length() == 0) {
                erroDonViQuyDoi.setText("Đơn Vị Quy Đổi không được để trống");
                check = false;
            } else if (!dv.getDonViQuyDoi().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroDonViQuyDoi.setText("Đơn Vị Quy Đổi không được có khoảng trắng");
                check = false;
            } else if (findDonViByDonViQuyDoi(dv.getDonViQuyDoi()) != null) {
                erroDonViQuyDoi.setText("Đơn Vị Quy Đổi đã tồn tại");
                check = false;
            } else {
                erroDonViQuyDoi.setText("");
            }
        }

//          if(String.valueOf(dv.getSoLuong()).isEmpty()){
//                erroSoLuong.setText("k de trong");
//                check = false;
//            }else{
//                erroSoLuong.setText("");
//            }
//
        try {
            int sl = Integer.parseInt(erroSoLuong.getText().trim());
            if (sl <= 0) {
                erroSoLuong.setText(" Số Lượng Phải Là Số Nguyên Dương");
               check = false;
            }
        } catch (Exception e) {
          erroSoLuong.setText(" Số Lượng Phải Là Số ");
                check = false;
        }
        
        if (!check) {
            return null;
        }
       return dv;  
    } 
   
    @Override
    public List<TpDonViCustom> getListDonVi() {
         return rp.getList();
    }

    @Override
    public TpDonViCustom findDonViByDonViQuyDoi(String donViQuyDoi) {
   return rp.findByDonViGoc(donViQuyDoi);
    }

    @Override
    public List<TpDonViCustom> findAllByRadio(String donViGoc, int rdo) {
  switch (rdo) {
            case 0:
                return rp.findAllByDonViGoc(donViGoc);
            case 1:
                return rp.findAllByDonViQuyDoi(donViGoc);
            default:
               return null; 
        }
    }
}



        
